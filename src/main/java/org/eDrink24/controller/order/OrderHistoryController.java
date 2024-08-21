package org.eDrink24.controller.order;

import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.eDrink24.service.order.OrderHistoryService;
import org.eDrink24.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderHistoryController {

  OrderHistoryService orderHistoryService;

  public OrderHistoryController(OrderHistoryService orderHistoryService) {
      this.orderHistoryService = orderHistoryService;
  }

    // 포인트 조회
    @GetMapping("/showOrderHistory/{userId}")
    public ResponseEntity<List<OrderTransactionDTO>> showOrderHistory(@PathVariable Integer userId) {
        List<OrderTransactionDTO> orderTransactionDTO = orderHistoryService.showOrderHistory(userId);
        return ResponseEntity.ok(orderTransactionDTO);
    }

}
