package org.eDrink24.dto.order;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;


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
    private LocalDate orderDate;
    private LocalDate pickupDate;
    private Boolean isCompleted;
    private String orderStatus;

    private Integer ordersId;
    private String changeStatus;
    private LocalDate changeDate;

    OrderTransactionDTO (Integer storeId, Integer userId, Integer productId, LocalDate orderDate, LocalDate pickupDate,
              Boolean isCompleted, String orderStatus) {

        this.storeId = storeId;
        this.userId = userId;
        this.productId = productId;
        this.orderDate = orderDate;
        this.pickupDate = pickupDate;
        this.isCompleted = isCompleted;
        this.orderStatus = orderStatus;
    }

    OrderTransactionDTO (Integer ordersId, String changeStatus, LocalDate changeDate) {

        this.ordersId = ordersId;
        this.changeStatus = changeStatus;
        this.changeDate = changeDate;
    }

}

