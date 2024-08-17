package org.eDrink24.controller.store;

import lombok.extern.slf4j.Slf4j;
import org.eDrink24.dto.store.StoreDTO;
import org.eDrink24.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping("/api/findStore/{storeId}")
    public ResponseEntity<StoreDTO> findStore(@PathVariable("storeId") int storeId) {
        try {
            StoreDTO storeDTO = storeService.findByStoreId(storeId);
            log.info(storeDTO.toString());
            return ResponseEntity.ok(storeDTO);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/allStores")
    public ResponseEntity<List<StoreDTO>> showAllStore() {
        List<StoreDTO> stores = storeService.findAllStores();
        return ResponseEntity.ok(stores);
    }

}
