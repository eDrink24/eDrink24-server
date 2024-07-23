package org.eDrink24.domain.product;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer productId;

    @Column(name = "productImageId", nullable = true)
    private Integer productImageId;

    @Column (name = "productName", nullable = false, length = 30)
    private String productName;

    @Column(name = "category1", nullable = false, length = 20)
    private String category1;

    @Column(name = "category2", length = 20)
    private String category2;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "releaseDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releaseDate;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "countReview", nullable = false)
    private Integer countReview;

    @Column(name = "countDibs", nullable = false)
    private Integer countDibs;

    @Column(name = "image", length = 100)
    private String image;

    @Column(name = "isPromotion")
    private Boolean isPromotion;

    @Column(name = "isCoupon")
    private Boolean isCoupon;

    @Column(name = "isPoint")
    private Boolean isPoint;

}
