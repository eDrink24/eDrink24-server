CREATE TABLE `CUSTOMER` (
                            `userId`	INT	NOT NULL,
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

CREATE TABLE `StandardProducts` (
                                    `productId`	INT	NOT NULL,
                                    `productName`	VARCHAR(30)	NOT NULL,
                                    `category1`	VARCHAR(30)	NOT NULL,
                                    `category2`	VARCHAR(30)	NULL
);

CREATE TABLE `STORE` (
                         `storeId`	INT	NOT NULL,
                         `userId`	INT	NOT NULL,
                         `storeName`	VARCHAR(50)	NOT NULL,
                         `storeAddress`	VARCHAR(100)	NOT NULL,
                         `storePhoneNum`	VARCHAR(50)	NULL
);

CREATE TABLE `dibs` (
                        `DibsId`	INT	NOT NULL,
                        `userId`	INT	NOT NULL,
                        `dProductId`	int	NOT NULL
);

CREATE TABLE `INVENTORY` (
                             `inventoryId`	INT	NOT NULL,
                             `storeId`	INT	NOT NULL,
                             `dProductId`	INT	NOT NULL,
                             `quantity`	INT	NOT NULL	DEFAULT 0
);

CREATE TABLE `ORDER` (
                         `orderId`	INT	NOT NULL,
                         `storeId`	INT	NOT NULL,
                         `userId`	INT	NOT NULL,
                         `dProductId`	INT	NOT NULL,
                         `orderDate`	TIMESTAMP	NOT NULL,
                         `pickupDate`	TIMESTAMP	NOT NULL,
                         `isCompleted`	BOOLEAN	NOT NULL	DEFAULT false,
                         `orderStatus`	VARCHAR(20)	NOT NULL	DEFAULT 'ORDERED'
);

CREATE TABLE `coupon` (
                          `couponId`	INT	NOT NULL,
                          `userId`	INT	NOT NULL	DEFAULT 0,
                          `discountAmout`	INT	NULL,
                          `issueDate`	TIMESTAMP	NOT NULL,
                          `endDate`	TIMESTAMP	NOT NULL,
                          `useDate`	DATETIME	NULL,
                          `used`	BOOLEAN	NOT NULL	DEFAULT false
);

CREATE TABLE `POINTDETAILS` (
                                `pointDetailsId`	INT	NOT NULL,
                                `orderId`	INT	NOT NULL,
                                `saveDate`	TIMESTAMP	NOT NULL,
                                `point`	INT	NOT NULL
);

CREATE TABLE `BASKET` (
                          `basketId`	INT	NOT NULL,
                          `userId`	INT	NOT NULL,
                          `dProductId`	int	NOT NULL,
                          `basketQuantity`	INT	NOT NULL	DEFAULT 1
);

CREATE TABLE `PRODUCTIMAGE` (
                                `productImageId`	INT	NOT NULL,
                                `productOptionId`	int	NOT NULL,
                                `detailImage`	VARCHAR(50)	NOT NULL
);

CREATE TABLE `REVIEW` (
                          `reviewId`	INT	NOT NULL,
                          `orderId`	INT	NOT NULL,
                          `content`	VARCHAR(255)	NULL,
                          `enrolledDate`	TIMESTAMP	NOT NULL,
                          `modifiedDate`	TIMESTAMP	NULL,
                          `reviewImage`	VARCHAR(50)	NULL,
                          `rating`	INT	NULL	DEFAULT 1,
                          `sugarRating`	INT	NULL	DEFAULT 1,
                          `acidityRating`	INT	NULL	DEFAULT 1,
                          `throatRating`	INT	NULL	DEFAULT 1
);

CREATE TABLE `DisplayProducts` (
                                   `dProductId`	INT	NOT NULL,
                                   `productId`	INT	NOT NULL,
                                   `promotionId`	INT	NULL,
                                   `price`	INT	NOT NULL	DEFAULT 0,
                                   `defalutImage`	VARCHAR(50)	NULL,
                                   `countDibs`	INT	NOT NULL	DEFAULT 0,
                                   `isCoupon`	BOOLEAN	NOT NULL	DEFAULT false,
                                   `isPoint`	BOOLEAN	NOT NULL	DEFAULT false
);

CREATE TABLE `PROMOTIONS` (
                              `promotionId`	INT	NOT NULL,
                              `title`	VARCHAR(50)	NOT NULL,
                              `contentImage`	VARCHAR(50)	NOT NULL,
                              `startDate`	TIMESTAMP	NOT NULL,
                              `endDate`	TIMESTAMP	NOT NULL
);

CREATE TABLE `ORDERHISTORY` (
                                `historyId`	INT	NOT NULL,
                                `orderId`	INT	NOT NULL,
                                `changeStatus`	VARCHAR(20)	NOT NULL	DEFAULT 'ORDERED',
                                `changeDate`	TIMESTAMP	NULL
);

ALTER TABLE `CUSTOMER` ADD CONSTRAINT `PK_CUSTOMER` PRIMARY KEY (
                                                                 `userId`
    );

ALTER TABLE `StandardProducts` ADD CONSTRAINT `PK_STANDARDPRODUCTS` PRIMARY KEY (
                                                                                 `productId`
    );

ALTER TABLE `STORE` ADD CONSTRAINT `PK_STORE` PRIMARY KEY (
                                                           `storeId`
    );

ALTER TABLE `dibs` ADD CONSTRAINT `PK_DIBS` PRIMARY KEY (
                                                         `DibsId`
    );

ALTER TABLE `INVENTORY` ADD CONSTRAINT `PK_INVENTORY` PRIMARY KEY (
                                                                   `inventoryId`
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

ALTER TABLE `PRODUCTIMAGE` ADD CONSTRAINT `PK_PRODUCTIMAGE` PRIMARY KEY (
                                                                         `productImageId`
    );

ALTER TABLE `REVIEW` ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
                                                             `reviewId`,
                                                             `orderId`
    );

ALTER TABLE `DisplayProducts` ADD CONSTRAINT `PK_DISPLAYPRODUCTS` PRIMARY KEY (
                                                                               `dProductId`,
                                                                               `productId`
    );

ALTER TABLE `PROMOTIONS` ADD CONSTRAINT `PK_PROMOTIONS` PRIMARY KEY (
                                                                     `promotionId`
    );

ALTER TABLE `ORDERHISTORY` ADD CONSTRAINT `PK_ORDERHISTORY` PRIMARY KEY (
                                                                         `historyId`
    );

ALTER TABLE `REVIEW` ADD CONSTRAINT `FK_ORDER_TO_REVIEW_1` FOREIGN KEY (
                                                                        `orderId`
    )
    REFERENCES `ORDER` (
                        `orderId`
        );

ALTER TABLE `DisplayProducts` ADD CONSTRAINT `FK_StandardProducts_TO_DisplayProducts_1` FOREIGN KEY (
                                                                                                     `productId`
    )
    REFERENCES `StandardProducts` (
                                   `productId`
        );

