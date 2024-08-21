package org.eDrink24.controller.review;

import org.eDrink24.dto.admin.AdminDTO;
import org.eDrink24.dto.review.ReviewDTO;
import org.eDrink24.service.admin.AdminService;
import org.eDrink24.service.review.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 제품에 대한 리뷰 조회
    @GetMapping(value = {"showProductReview/{productId}"})
    public ResponseEntity<List<ReviewDTO>> showProductReview(@PathVariable Integer productId) {
        List<ReviewDTO> reviews=reviewService.showProductReview(productId);
        return ResponseEntity.ok(reviews);
    }

    // 리뷰 작성
    @PostMapping(value = {"/addReview"})
    public ResponseEntity<String> addReview(@RequestBody ReviewDTO reviewDTO) {
        boolean isAdded = reviewService.addReview(reviewDTO);
        if (isAdded) {
            return ResponseEntity.ok("리뷰작성 성공");
        } else {
            return ResponseEntity.status(400).body("리뷰작성 실패. 주문상태 확인 바람");
        }
    }

}
