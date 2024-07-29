package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.eDrink24.dto.basket.BasketDTO;

import java.util.List;

@Mapper
public interface BasketMapper {

    public void saveProductToBasket(BasketDTO basketDTO);
    public List<BasketDTO> showProductInBasket(Integer userId);
    public void deleteAllProductInBasket(Integer userId);
    public void deleteProductByBasketIdInBasket(Integer userId,Integer basketId);

}
