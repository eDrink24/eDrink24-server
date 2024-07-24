CREATE TABLE `CUSTOMER` (
                            `userId`	INT	NOT NULL auto_increment,
                            `userName`	VARCHAR(20)	NOT NULL,
                            `loginId`	VARCHAR(20)	NOT NULL,
                            `pw`	VARCHAR(20)	NOT NULL,
                            `gender` ENUM('남','여') NOT NULL DEFAUlT('남'),
                            `birthdate`	DATETIME	NOT NULL,
                            `phoneNum`	VARCHAR(20)	NOT NULL,
                            `email`	VARCHAR(50)	NOT NULL,
                            `postalCode` VARCHAR(50)	NOT NULL,
                            `address1`	VARCHAR(20)	NOT NULL,
                            `address2`	VARCHAR(20)	NOT NULL,
                            `currentLocation`	VARCHAR(50)	NULL,
                            `currentStore`	VARCHAR(50)	NULL,
                            `totalPoint`	INT	NOT NULL	DEFAULT 0,
                            `role`	VARCHAR(20)	NOT NULL	DEFAULT '일반회읜'
);

