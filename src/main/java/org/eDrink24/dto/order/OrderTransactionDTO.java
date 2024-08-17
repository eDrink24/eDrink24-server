package org.eDrink24.dto.order;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Alias("OrderTransactionDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OrderTransactionDTO {

    private Integer storeId;
    private Integer userId;
    private Integer productId;
    private LocalDateTime orderDate;
    private LocalDateTime pickupDate;
    private Boolean isCompleted;
    private String orderStatus;
    private Integer orderQuantity;

    private Integer ordersId;
    private String changeStatus;
    private LocalDateTime changeDate;

    private Integer basketId;
    private Integer itemId;
    private String defaultImage;
    private String productName;
    private Integer price;
    private Integer basketQuantity;

    OrderTransactionDTO (Integer storeId, Integer userId, Integer productId, LocalDateTime orderDate,
              Boolean isCompleted, String orderStatus, Integer orderQuantity) {

        this.storeId = storeId;
        this.userId = userId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.isCompleted = isCompleted;
        this.orderStatus = orderStatus;
        this.orderQuantity = orderQuantity;
    }

    OrderTransactionDTO (Integer ordersId, String changeStatus, LocalDateTime changeDate) {

        this.ordersId = ordersId;
        this.changeStatus = changeStatus;
        this.changeDate = changeDate;
    }

    OrderTransactionDTO (Integer basketId, Integer userId) {

        this.basketId = basketId;
        this.userId = userId;
    }

    OrderTransactionDTO (Integer itemId, Integer basketId, Integer productId, String defaultImage,
                         String productName, Integer price, Integer basketQuantity ) {

        this.itemId = itemId;
        this.basketId = basketId;
        this.productId = productId;
        this.defaultImage = defaultImage;
        this.productName = productName;
        this.price = price;
        this.basketQuantity = basketQuantity;
    }

}

