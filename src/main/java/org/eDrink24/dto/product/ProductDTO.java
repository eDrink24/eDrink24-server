package org.eDrink24.dto.product;

import org.apache.ibatis.type.Alias;
import lombok.*;
import org.apache.ibatis.type.Alias;
import java.time.LocalDate;


@Alias("ProductDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProductDTO {

    private String productName;
    private String category1;
    private String category2;
    private int promotionId;
    private int price;
    private String defaultImage;
    private String countDibs;
    private Boolean isCoupon;
    private Boolean isPoint;
    private LocalDate enrollDate;

}
