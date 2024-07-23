INSERT INTO `CUSTOMERS` (
    `userId`,
    `userName`,
    `loginId`,
    `pw`,
    `birthdate`,
    `phoneNum`,
    `email`,
    `address1`,
    `address2`,
    `currentLocation`,
    `currentStore`,
    `totalPoint`,
    `role`
) VALUES (
             1, -- userId: 고객 ID를 적절히 설정해주세요.
             '홍길동', -- userName: 회원 이름
             'abcd', -- loginId: 로그인 아이디
             '1234', -- pw: 비밀번호
             '1990-01-01 00:00:00', -- birthdate: 생년월일 (형식: YYYY-MM-DD HH:MI:SS)
             '010-1234-5678', -- phoneNum: 전화번호
             'hong@example.com', -- email: 이메일
             '서울시 강남구', -- address1: 주소 1
             '테헤란로', -- address2: 주소 2
             NULL, -- currentLocation: 현재 위치 (없다면 NULL)
             NULL, -- currentStore: 현재 가게 (없다면 NULL)
             0, -- totalPoint: 총 포인트 (기본값 0)
             '일반회원' -- role: 역할 (기본값 '일반회원')
         );
