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

    /*
    CREATE TABLE `STORE` (
    `storeId` INT NOT NULL AUTO_INCREMENT,
    `userId` INT NOT NULL,
    `storeName` VARCHAR(50) NOT NULL,
    `storeAddress` VARCHAR(100) NOT NULL,
    `storePhoneNum` VARCHAR(50) NULL,
    PRIMARY KEY (`storeId`),
    FOREIGN KEY (`userId`) REFERENCES `CUSTOMER`(`userId`)
);
     */

}

