package org.eDrink24.service.basket;

import org.apache.ibatis.annotations.Param;
import org.eDrink24.dto.basket.BasketDTO;

import java.util.List;

public interface BasketService {

    public Integer changeLoginIdToUserId(String loginId);
    public void saveProductToBasket(BasketDTO basketDTO);
    public List<BasketDTO> showProductInBasket(@Param("loginId") String loginId);
    public void deleteAllProductInBasket(@Param("loginId") String loginId);
    public void deleteProductByBasketIdInBasket(@Param("loginId") String loginId,@Param("basketId") Integer basketId);

}
