package org.eDrink24.service.review;

import org.eDrink24.dto.Inventory.InventoryDTO;
import org.eDrink24.dto.admin.AdminDTO;
import org.eDrink24.dto.review.ReviewDTO;

import java.util.List;

public interface ReviewService {

    public List<ReviewDTO> showProductReview(Integer productId);

    // 리뷰 작성 후 저장
    public Boolean addReview(ReviewDTO reviewDTO);
}
