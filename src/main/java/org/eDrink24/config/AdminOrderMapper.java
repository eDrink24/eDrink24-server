package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.eDrink24.dto.Inventory.InventoryDTO;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.basket.BasketItemDTO;

import java.util.List;

@Mapper
public interface AdminOrderMapper {

    // 발주신청시 매장 내 해당재고 갯수 증가
    public void updateInventoryQuantity(InventoryDTO inventoryDTO);

    // 장바구니 목록에 이미 존재하는지 확인
    public InventoryDTO checkInventoryProduct(Integer productId, Integer storeId);

    // 해당재고 없으면 INVENTORY에 추가
    public void addProductToInventory(InventoryDTO inventoryDTO);

    // 발주완료 목록 조회
    public List<InventoryDTO> showAdminOrderPage(Integer storeId, Integer productId);

}
