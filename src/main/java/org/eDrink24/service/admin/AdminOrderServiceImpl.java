package org.eDrink24.service.admin;

import org.eDrink24.config.AdminMapper;
import org.eDrink24.config.CustomerMapper;
import org.eDrink24.config.ProductMapper;
import org.eDrink24.dto.Inventory.InventoryDTO;
import org.eDrink24.dto.admin.AdminDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class AdminOrderServiceImpl implements AdminOrderService {

    AdminMapper adminMapper;
    CustomerMapper customerMapper;
    ProductMapper productMapper;
    public AdminOrderServiceImpl(AdminMapper adminMapper, CustomerMapper customerMapper, ProductMapper productMapper) {
        this.adminMapper = adminMapper;
        this.customerMapper = customerMapper;
        this.productMapper = productMapper;
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
    public void updatePickupType(InventoryDTO inventoryDTO) {
        adminMapper.updatePickupType(inventoryDTO);
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
        adminMapper.updatePickupType(inventoryDTO);

    }

    @Override
    public List<AdminDTO> showReservationPickupPage() {
        List<AdminDTO> adminList = adminMapper.showReservationPickupPage();
        for (AdminDTO admin : adminList) {
            Integer userId = admin.getUserId();
            Integer productId = admin.getProductId();
            admin.setUserName(customerMapper.findUserNameByUserId(userId));
            admin.setProductName(productMapper.findProductNameByProductId(productId));
        }
        return adminList;
    }

}
