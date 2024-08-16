package org.eDrink24.controller.admin;


import org.eDrink24.dto.Inventory.InventoryDTO;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.eDrink24.service.admin.AdminOrderService;
import org.eDrink24.service.basket.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminOrderController {

    AdminOrderService adminOrderService;

    public AdminOrderController(AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }

    @PostMapping(value = {"/updateOrInsertInventory/{storeId}/{productId}"})
    public ResponseEntity<String> updateOrInsertInventory(@PathVariable Integer productId, @PathVariable Integer storeId,
                                                            @RequestBody InventoryDTO inventoryDTO) {

        try {
            adminOrderService.updateOrInsertInventory(productId, storeId, inventoryDTO);
            return ResponseEntity.ok("Admin Order successful");
        } catch (Exception e)    {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping(value = {"/showAdminOrderPage/{storeId}/{productId}"})
    public List<InventoryDTO> showAdminOrderPage(@PathVariable Integer storeId, @PathVariable Integer productId) {
        return adminOrderService.showAdminOrderPage(storeId, productId);
    }

}
