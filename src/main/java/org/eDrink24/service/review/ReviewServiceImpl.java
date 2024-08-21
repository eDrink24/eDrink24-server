package org.eDrink24.service.review;

import org.eDrink24.config.ReviewMapper;
import org.eDrink24.dto.review.ReviewDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    ReviewMapper reviewMapper;

    public ReviewServiceImpl(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }

    @Override
    public List<ReviewDTO> showProductReview(Integer productId) {
        return reviewMapper.showProductReview(productId);
    }

    @Override
    public Boolean addReview(ReviewDTO reviewDTO) {
        if(reviewMapper.isOrderPickuped(reviewDTO.getOrdersId())){
            reviewMapper.insertReview(reviewDTO);
            return true;
        }
        return false; // 주문상태 PICKUPED가 아니면 리뷰 작성 불가
    }
}
