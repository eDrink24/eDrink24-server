CREATE TABLE `USER` (
                        `userId`	INT	NOT NULL AUTO_INCREMENT,
                        `userName`	VARCHAR(20)	NOT NULL,
                        `loginId`	VARCHAR(20)	NOT NULL,
                        `pw`	VARCHAR(20)	NOT NULL,
                        `birthdate`	DATETIME	NOT NULL,
                        `phoneNum`	VARCHAR(20)	NOT NULL,
                        `email`	VARCHAR(50)	NOT NULL,
                        `address1`	VARCHAR(20)	NOT NULL,
                        `address2`	VARCHAR(20)	NOT NULL,
                        `currentLocation`	VARCHAR(50)	NULL,
                        `currentStore`	VARCHAR(50)	NULL,
                        `totalPoint`	INT	NOT NULL	DEFAULT 0,
                        `role`	VARCHAR(20)	NOT NULL	DEFAULT '일반회읜'
);

CREATE TABLE `PRODUCT` (
                           `productId`	INT	NOT NULL AUTO_INCREMENT,
                           `productImageId`	INT	NOT NULL,
                           `productName`	VARCHAR(30)	NOT NULL,
                           `category1`	VARCHAR(30)	NOT NULL,
                           `category2`	VARCHAR(30)	NULL,
                           `price`	INT	NOT NULL	DEFAULT 0,
                           `releaseDate`	DATETIME	NULL,
                           `rating`	INT	NOT NULL	DEFAULT 0,
                           `countReview`	INT	NOT NULL	DEFAULT 0,
                           `countDibs`	INT	NOT NULL	DEFAULT 0,
                           `image`	VARCHAR(100)	NULL,
                           `isPromotion`	BOOLEAN	NULL	DEFAULT false,
                           `isCoupon`	BOOLEAN	NULL	DEFAULT false,
                           `isPoint`	BOOLEAN	NULL	DEFAULT false
);

CREATE TABLE `STORE` (
                         `storeId`	INT	NOT NULL AUTO_INCREMENT,
                         `userId`	INT	NOT NULL,
                         `storeName`	VARCHAR(50)	NOT NULL,
                         `storeAddress`	VARCHAR(100)	NOT NULL,
                         `storePhoneNum`	VARCHAR(50)	NULL
);

CREATE TABLE `dibs` (
                        `DibsId`	INT	NOT NULL AUTO_INCREMENT,
                        `productId`	INT	NOT NULL,
                        `userId`	INT	NOT NULL
);

CREATE TABLE `store_product` (
                                 `storeProductId`	INT	NOT NULL AUTO_INCREMENT,
                                 `storeId`	INT	NOT NULL,
                                 `productId`	INT	NOT NULL,
                                 `quantity`	INT	NOT NULL	DEFAULT 0
);

CREATE TABLE `ORDER` (
                         `orderId`	INT	NOT NULL AUTO_INCREMENT,
                         `storeId`	INT	NOT NULL,
                         `userId3`	INT	NOT NULL,
                         `productId`	INT	NOT NULL,
                         `orderDate`	DATETIME	NOT NULL,
                         `pickupDate`	DATETIME	NOT NULL,
                         `pickupTime`	TIMESTAMP	NOT NULL,
                         `isCompleted`	BOOLEAN	NOT NULL	DEFAULT false
);

CREATE TABLE `coupon` (
                          `couponId`	INT	NOT NULL AUTO_INCREMENT,
                          `userId`	INT	NOT NULL	DEFAULT 0,
                          `discountAmout`	INT	NULL,
                          `issueDate`	TIMESTAMP	NOT NULL,
                          `endDate`	TIMESTAMP	NOT NULL,
                          `useDate`	DATETIME	NULL,
                          `used`	BOOLEAN	NOT NULL	DEFAULT false
);

CREATE TABLE `POINTDETAILS` (
                                `pointDetailsId`	INT	NOT NULL AUTO_INCREMENT,
                                `orderId`	INT	NOT NULL,
                                `saveDate`	TIMESTAMP	NOT NULL,
                                `point`	INT	NOT NULL
);

CREATE TABLE `BASKET` (
                          `basketId`	INT	NOT NULL AUTO_INCREMENT,
                          `userId2`	INT	NOT NULL,
                          `productId`	INT	NOT NULL,
                          `Field4`	INT	NOT NULL	DEFAULT 1
);

CREATE TABLE `ProductImage` (
                                `productImageId`	INT	NOT NULL AUTO_INCREMENT,
                                `image`	VARCHAR(50)	NOT NULL
);

CREATE TABLE `REVIEW` (
                          `reviewId`	INT	NOT NULL AUTO_INCREMENT,
                          `orderId`	INT	NOT NULL,
                          `productId`	INT	NOT NULL,
                          `content`	TEXT	NOT NULL,
                          `enrollDate`	TIMESTAMP	NOT NULL,
                          `modifiedDate`	TIMESTAMP	NULL,
                          `image`	VARCHAR(50)	NULL,
                          `rating`	INT	NULL	DEFAULT 1,
                          `sugarRating`	INT	NULL	DEFAULT 1,
                          `acidityRating`	INT	NULL	DEFAULT 1,
                          `throatRating`	INT	NULL	DEFAULT 1
);

ALTER TABLE `USER` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                                         `userId`
    );

ALTER TABLE `PRODUCT` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
                                                               `productId`
    );

ALTER TABLE `STORE` ADD CONSTRAINT `PK_STORE` PRIMARY KEY (
                                                           `storeId`
    );

ALTER TABLE `dibs` ADD CONSTRAINT `PK_DIBS` PRIMARY KEY (
                                                         `DibsId`
    );

ALTER TABLE `store_product` ADD CONSTRAINT `PK_STORE_PRODUCT` PRIMARY KEY (
                                                                           `storeProductId`
    );

ALTER TABLE `ORDER` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
                                                           `orderId`
    );

ALTER TABLE `coupon` ADD CONSTRAINT `PK_COUPON` PRIMARY KEY (
                                                             `couponId`
    );

ALTER TABLE `POINTDETAILS` ADD CONSTRAINT `PK_POINTDETAILS` PRIMARY KEY (
                                                                         `pointDetailsId`
    );

ALTER TABLE `BASKET` ADD CONSTRAINT `PK_BASKET` PRIMARY KEY (
                                                             `basketId`
    );

ALTER TABLE `ProductImage` ADD CONSTRAINT `PK_PRODUCTIMAGE` PRIMARY KEY (
                                                                         `productImageId`
    );

ALTER TABLE `REVIEW` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
                                                             `reviewId`,
                                                             `orderId`
    );

ALTER TABLE `REVIEW` ADD CONSTRAINT `FK_ORDER_TO_REVIEW_1` FOREIGN KEY (
                                                                        `orderId`
    )
    REFERENCES `ORDER` (
                        `orderId`
        );

