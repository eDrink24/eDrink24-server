package org.eDrink24.service.basket;

import org.apache.ibatis.annotations.Param;
import org.eDrink24.dto.basket.BaksetDTO;
import org.eDrink24.dto.basket.BasketJoinProductDTO;

import java.util.List;

public interface BasketService {

    public void saveProductToBasket(BaksetDTO basketDTO);
    public List<BasketJoinProductDTO> showProductInBasket(Integer userId);

}
