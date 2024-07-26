package org.eDrink24.dto.basket;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;


@Alias("BasketDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class BasketDTO {

    private Integer basketId;
    private Integer userId;
    private Integer productId;
    private String productName;
    private Integer price;
    private Integer basketQuantity;

}
