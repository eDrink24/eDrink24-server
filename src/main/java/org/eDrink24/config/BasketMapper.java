package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.eDrink24.dto.basket.BaksetDTO;
import org.eDrink24.dto.basket.BasketJoinProductDTO;

import java.util.List;

@Mapper
public interface BasketMapper {

    public void saveProductToBasket(BaksetDTO basketDTO);
    public List<BasketJoinProductDTO> showProductInBasket(Integer userId);


}
