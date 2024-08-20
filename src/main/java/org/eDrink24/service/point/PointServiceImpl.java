package org.eDrink24.service.point;

import org.eDrink24.config.CouponMapper;
import org.eDrink24.config.PointMapper;
import org.eDrink24.dto.coupon.CouponDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.eDrink24.service.coupon.CouponService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointService {

    PointMapper pointMapper;

   public PointServiceImpl(PointMapper pointMapper) {
      this.pointMapper = pointMapper;
   }

    @Override
    public Integer showTotalPoint(Integer userId) {
        return pointMapper.showTotalPoint(userId);
    }
}
