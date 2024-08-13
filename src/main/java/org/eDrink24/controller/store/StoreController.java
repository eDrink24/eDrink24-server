package org.eDrink24.controller.store;

import org.eDrink24.dto.store.StoreDTO;
import org.eDrink24.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping("/allStores")
    public ResponseEntity<List<StoreDTO>> showAllStore() {
        List<StoreDTO> stores = storeService.findAllStores();
        return ResponseEntity.ok(stores);
    }


}
