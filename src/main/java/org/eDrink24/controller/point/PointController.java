package org.eDrink24.controller.point;

import org.eDrink24.dto.coupon.CouponDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.eDrink24.service.coupon.CouponService;
import org.eDrink24.service.point.PointService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PointController {

  PointService pointService;

  public PointController(PointService pointService) {
      this.pointService = pointService;
  }

    // 포인트 조회
    @GetMapping("/showTotalPoint/{userId}")
    public ResponseEntity<Integer> showTotalPoint(@PathVariable Integer userId) {
        Integer points = pointService.showTotalPoint(userId);
        return ResponseEntity.ok(points);
    }


}
