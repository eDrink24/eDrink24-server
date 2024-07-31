package org.eDrink24.dto.dibs;

import lombok.*;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;


@Alias("DibDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class DibDTO {

    private Integer userId;
    private Integer productId;

    /*
    CREATE TABLE `dibs` (
    `DibsId` INT NOT NULL AUTO_INCREMENT,
    `userId` INT NOT NULL,
    `productId` INT NOT NULL,
    PRIMARY KEY (`DibsId`),
    FOREIGN KEY (`userId`) REFERENCES `CUSTOMER`(`userId`),
    FOREIGN KEY (`productId`) REFERENCES `Product`(`productId`)
);
     */

}
