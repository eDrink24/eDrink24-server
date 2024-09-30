package org.eDrink24;

import org.eDrink24.config.InventoryMapper;
import org.eDrink24.domain.customer.Customer;
import org.eDrink24.dto.Inventory.InventoryDTO;
import org.eDrink24.dto.customer.CustomerDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.eDrink24.service.customer.AuthenticationService;
import org.eDrink24.service.customer.AuthenticationServiceImpl;
import org.eDrink24.service.customer.CustomerService;
import org.eDrink24.service.order.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@SpringBootTest
@Transactional
public class OrderTests {

    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private InventoryMapper inventoryMapper;

    @Test
    public void ConcurrencyTest() throws InterruptedException {
        int storeId = 1331;
        int productId = 81;
        int orderQuantity = 3;

        Map<String, Integer> map = new HashMap<>();
        map.put("storeId", storeId);
        map.put("productId", productId);
        map.put("quantity", orderQuantity);

        // 동시성 테스트를 위한 스레드 동기화
        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {
            try {
                InventoryDTO inventory = inventoryMapper.findInventoryForUpdate(map);
                if (inventory == null || inventory.getQuantity() < orderQuantity) {
                    System.out.println("재고 부족으로 주문 불가");
                } else {
                    inventoryMapper.updateInventory(map);
                    System.out.println("재고 감소 성공");
                }
            } catch (Exception e) {
                System.out.println("예외 발생: " + e.getMessage());
            } finally {
                latch.countDown();
            }
        };

        // 각 스레드 생성
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();

        latch.await();

        // 결과 확인
        System.out.println("동시성 테스트 완료");

        // 최종 재고 수량 확인
        InventoryDTO finalInventory = inventoryMapper.findInventoryForUpdate(map);
        System.out.println("최종 재고 수량: " + (finalInventory != null ? finalInventory.getQuantity() : "재고 없음"));
    }
}
