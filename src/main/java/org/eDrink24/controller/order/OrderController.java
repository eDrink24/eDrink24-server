package org.eDrink24.controller.order;

import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.eDrink24.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

  OrderService orderService;

  public OrderController(OrderService orderService) {
      this.orderService = orderService;
  }


    // 결제하기(ORDERS, ORDERHISTORY 테이블에 저장)
    @PostMapping("/showAllBasket/userId/{userId}/buyProductAndSaveHistory")
    public ResponseEntity<String> buyProductAndSaveHistory(@RequestBody List<OrderTransactionDTO> orderTransactionDTO,
                                                           @PathVariable Integer userId) {

      
        try {
            orderService.buyProductAndSaveHistory(orderTransactionDTO);
            return ResponseEntity.ok("Purchase successful");
        } catch (Exception e) {
            // 예외 처리 로직
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error processing purchase: " + e.getMessage());
        }
    }


}
