package org.eDrink24.dto.product;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProductDTO {
    private Integer productId;
    private Integer productImageId;
    private String productName;
    private String category1;
    private String category2;
    private Integer price;
    private Date releaseDate;
    private Integer rating;
    private Integer countReview;
    private Integer countDibs;
    private String image;
    private Boolean isPromotion;
    private Boolean isCoupon;
    private Boolean isPoint;
}
