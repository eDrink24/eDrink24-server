package org.eDrink24.service.admin;

import org.eDrink24.config.AdminOrderMapper;
import org.eDrink24.config.BasketMapper;
import org.eDrink24.dto.Inventory.InventoryDTO;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.basket.BasketItemDTO;
import org.eDrink24.service.basket.BasketService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class AdminOrderServiceImpl implements AdminOrderService {


    AdminOrderMapper adminOrderMapper;

    public AdminOrderServiceImpl(AdminOrderMapper adminOrderMapper) {
        this.adminOrderMapper = adminOrderMapper;
    }


    @Override
    public void updateInventoryQuantity(InventoryDTO inventoryDTO) {
        adminOrderMapper.updateInventoryQuantity(inventoryDTO);
    }

    @Override
    public InventoryDTO checkInventoryProduct(Integer productId, Integer storeId) {
        return adminOrderMapper.checkInventoryProduct(productId, storeId);
    }

    @Override
    public void addProductToInventory(InventoryDTO inventoryDTO) {
        adminOrderMapper.addProductToInventory(inventoryDTO);
    }

    @Override
    public List<InventoryDTO> showAdminOrderPage(Integer storeId, Integer productId) {
        return adminOrderMapper.showAdminOrderPage(storeId, productId);
    }

    @Transactional
    public void updateOrInsertInventory(Integer productId,Integer storeId, InventoryDTO inventoryDTO) {

        InventoryDTO existingInventory = adminOrderMapper.checkInventoryProduct(productId, storeId);
        System.out.println("AAAAAAAA :" + existingInventory);

        if (existingInventory != null) {
            adminOrderMapper.updateInventoryQuantity(inventoryDTO);
        } else {
            adminOrderMapper.addProductToInventory(inventoryDTO);
        }

    }

}
