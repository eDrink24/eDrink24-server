-- 주류 데이터 삽입 예제

INSERT INTO `PRODUCT` (
    `productId`,
    `productImageId`,
    `productName`,
    `category1`,
    `category2`,
    `price`,
    `releaseDate`,
    `rating`,
    `countReview`,
    `countDibs`,
    `image`,
    `isPromotion`,
    `isCoupon`,
    `isPoint`
) VALUES
      (1, 101, 'Grape Wine', 'Wine', 'Red', 15000, '2024-01-15 10:00:00', 4, 120, 30, 'wine_grape.jpg', false, true, true),
      (2, 102, 'Premium Beer', 'Beer', 'Ale', 8000, '2024-03-10 14:30:00', 5, 250, 45, 'beer_premium.jpg', true, false, true),
      (3, 103, 'Whiskey Blend', 'Whiskey', 'Scotch', 35000, '2024-05-20 17:45:00', 4, 80, 20, 'whiskey_blend.jpg', false, true, false),
      (4, 104, 'Vodka Classic', 'Vodka', 'Classic', 22000, '2024-06-25 09:00:00', 3, 60, 10, 'vodka_classic.jpg', true, false, true),
      (5, 105, 'Rum Dark', 'Rum', 'Dark', 25000, '2024-07-30 11:15:00', 5, 100, 25, 'rum_dark.jpg', false, true, false);
