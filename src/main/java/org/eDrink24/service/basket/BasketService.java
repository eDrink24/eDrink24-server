package org.eDrink24.service.basket;

import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.basket.BasketJoinProductDTO;

import java.util.List;

public interface BasketService {

    public void saveProductToBasket(BasketDTO basketDTO);
    public List<BasketJoinProductDTO> showProductInBasket(Integer userId);

}
