package org.eDrink24.controller.order;

import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderDTO;
import org.eDrink24.dto.product.ProductDTO;
import org.eDrink24.service.order.OrderService;
import org.eDrink24.service.product.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

  OrderService orderService;

  public OrderController(OrderService orderService) {
      this.orderService = orderService;
  }

    // 장바구니에 담긴 상품 불러오기
    @GetMapping("/showAllBasket")
    public ResponseEntity<List<BasketDTO>> showAllBasket() {
        List<BasketDTO> baskets = orderService.showAllBasket();
        return ResponseEntity.ok(baskets);
    }

    // 결제하기(ORDERS 테이블에 저장)
    @PostMapping("/showAllBasket/buyProduct")
    public ResponseEntity<Integer> buyProduct(@RequestBody List<OrderDTO> orderList) {
      int orders = orderService.buyProduct(orderList);
      return ResponseEntity.ok(orders);
    }


}
