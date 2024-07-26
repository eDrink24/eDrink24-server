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

    private int basketId;
    private int userId;
    private int productId;
    private String productName;
    private int price;
    private int basketQuantity;

}
