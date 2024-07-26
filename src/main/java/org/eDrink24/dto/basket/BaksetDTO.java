package org.eDrink24.dto.basket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.eDrink24.dto.product.ProductDTO;

import javax.persistence.criteria.CriteriaBuilder;

@Alias("BasketDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaksetDTO {

    private Integer userId;
    private Integer productId;
    private Integer basketQuantity;

}
