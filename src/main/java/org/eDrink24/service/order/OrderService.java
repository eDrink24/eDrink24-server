package org.eDrink24.service.order;

import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderDTO;
import org.eDrink24.dto.product.DetailProductDTO;
import org.eDrink24.dto.product.ProductDTO;

import java.util.List;

public interface OrderService {

    // 장바구니에 담긴 상품 불러오기
    public List<BasketDTO> showAllBasket();

    // 결제하기(ORDERS 테이블에 저장)
    public int buyProduct(List<OrderDTO> orderDTO);



}
