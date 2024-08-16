package org.eDrink24.dto.admin;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;


@Alias("AdminDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AdminDTO {

    private Integer ordersId;
    private Integer storeId;
    private Integer userId;
    private Integer productId;
    private LocalDateTime orderDate;
    private Boolean isCompleted;
    private String changeStatus;
    private LocalDateTime changeDate;
    private Integer orderQuantity;

    /*
    select o.ordersId, o.storeId, o.userId, o.productId, o.orderDate, o.isCompleted, oh.changeStatus,oh.changeDate
     */

}