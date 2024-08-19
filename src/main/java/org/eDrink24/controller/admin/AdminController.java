package org.eDrink24.controller.admin;

import org.eDrink24.dto.admin.AdminDTO;
import org.eDrink24.service.admin.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    
    @PutMapping(value = {"/updateStateAfterCompletedPickup/{ordersId}"})
    public ResponseEntity<Void> updateStateAfterCompletedPickup(@PathVariable Integer ordersId) {
        adminService.updateStateAfterCompletedPickup(ordersId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = {"/showPickupCompletedPage"})
    public List<AdminDTO> showPickupCompletedPage() {
        return adminService.showPickupCompletedPage();
    }

    @GetMapping(value = {"/showPickupPage"})
    public List<AdminDTO> showTodayPickupPage() {
        return adminService.showTodayPickupPage();
    }
}
