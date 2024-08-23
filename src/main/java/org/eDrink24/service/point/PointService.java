package org.eDrink24.service.point;

import org.eDrink24.dto.coupon.CouponDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;

import java.util.List;

public interface PointService {

    // 쿠폰 목록 조회
    public Integer showTotalPoint(Integer userId);


}
