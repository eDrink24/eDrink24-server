package org.eDrink24.dto.order;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;


@Alias("OrderDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OrderDTO {

    private int storeId;
    private int userId;
    private int productId;
    private LocalDate orderDate;
    private LocalDate pickupDate;
    private Boolean isCompleted;
    private String orderStatus;

}

