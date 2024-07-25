package org.eDrink24.dto.product;

import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Alias("ProductDTO")
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
    private String promotionId;
    private String price;
    private String defaultImage;
    private String countDibs;
    private String isCoupon;
    private String isPoint;
    private LocalDate enrollDate;

}
