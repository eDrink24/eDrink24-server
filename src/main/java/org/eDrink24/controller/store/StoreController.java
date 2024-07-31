package org.eDrink24.controller.store;

import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.eDrink24.dto.store.StoreDTO;
import org.eDrink24.service.order.OrderService;
import org.eDrink24.service.store.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {

  StoreService storeService;

  public StoreController(StoreService storeService) {
      this.storeService = storeService;
  }

    // 매장 목록 조회
    @GetMapping("/showAllStore")
    public ResponseEntity<List<StoreDTO>> showAllStore() {
        List<StoreDTO> stores = storeService.showAllStore();
        return ResponseEntity.ok(stores);
    }


}
