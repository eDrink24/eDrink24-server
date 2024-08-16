package org.eDrink24.dto.Inventory;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;


@Alias("InventoryDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class InventoryDTO {

    private Integer inventoryId;
    private Integer storeId;
    private Integer productId;
    private Integer quantity;
    private String productName;

    InventoryDTO(Integer storeId, Integer productId, Integer quantity) {
        this.storeId = storeId;
        this.productId = productId;
        this.quantity = quantity;
    }


    /*
    select i.inventoryId, i.storeId, i.productId, i.quantity, p.productName
    from INVENTORY i join Product p on i.productId = p.productId;
     */

}