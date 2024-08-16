package org.eDrink24.dto.store;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;


@Alias("StoreDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class StoreDTO {
    private Integer storeId;
    private String storeName;
    private String storeAddress;
    private String storePhoneNum;

}

