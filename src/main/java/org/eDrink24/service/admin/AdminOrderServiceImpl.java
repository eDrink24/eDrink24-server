package org.eDrink24.service.admin;

import org.eDrink24.config.AdminMapper;
import org.eDrink24.dto.Inventory.InventoryDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class AdminOrderServiceImpl implements AdminOrderService {


    AdminMapper adminMapper;

    public AdminOrderServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }


    @Override
    public void updateInventoryQuantity(InventoryDTO inventoryDTO) {
        adminMapper.updateInventoryQuantity(inventoryDTO);
    }

    @Override
    public InventoryDTO checkInventoryProduct(Integer productId, Integer storeId) {
        return adminMapper.checkInventoryProduct(productId, storeId);
    }

    @Override
    public void addProductToInventory(InventoryDTO inventoryDTO) {
        adminMapper.addProductToInventory(inventoryDTO);
    }

    @Override
    public void addAdminOrderHistory(InventoryDTO inventoryDTO) {
        adminMapper.addAdminOrderHistory(inventoryDTO);
    }

    @Override
    public List<InventoryDTO> showAdminOrderList(Integer storeId) {
        return adminMapper.showAdminOrderList(storeId);
    }

    @Transactional
    public void updateOrInsertInventory(Integer productId,Integer storeId, InventoryDTO inventoryDTO) {

        InventoryDTO existingInventory = adminMapper.checkInventoryProduct(productId, storeId);
        System.out.println("AAAAAAAA :" + existingInventory);

        if (existingInventory != null) {
            adminMapper.updateInventoryQuantity(inventoryDTO);
        } else {
            adminMapper.addProductToInventory(inventoryDTO);
        }

        adminMapper.addAdminOrderHistory(inventoryDTO);

    }

}
