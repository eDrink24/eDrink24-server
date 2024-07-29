package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderDTO;
import java.util.List;



@Mapper
public interface OrderMapper {

    // 장바구니에 담긴 상품 불러오기
    public List<BasketDTO> showAllBasket(Integer userId);

    // 결제하기(ORDERS 테이블에 저장)
    public int buyProduct(List<OrderDTO> orderDTO);

}
