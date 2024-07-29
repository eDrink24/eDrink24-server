package org.eDrink24.dto.basket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Alias("BasketJoinProductDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketJoinProductDTO {

    private String productName;
    private Integer price;
    private String defaultImage;
    private Integer basketQuantity;

}
