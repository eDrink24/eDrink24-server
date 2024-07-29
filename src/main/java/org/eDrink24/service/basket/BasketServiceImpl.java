package org.eDrink24.service.basket;

import org.eDrink24.config.BasketMapper;
import org.eDrink24.dto.basket.BasketDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BasketServiceImpl implements BasketService {


    BasketMapper basketMapper;

    public BasketServiceImpl (BasketMapper basketMapper) {
        this.basketMapper = basketMapper;
    }

    @Override
    public void saveProductToBasket(BasketDTO basketDTO) {
        basketMapper.saveProductToBasket(basketDTO);
    }

    @Override
    public List<BasketDTO> showProductInBasket(Integer userId) {
        return basketMapper.showProductInBasket(userId);
    }

    @Override
    public void deleteAllProductInBasket(Integer userId) {
        basketMapper.deleteAllProductInBasket(userId);
    }

    @Override
    public void deleteProductByBasketIdInBasket(Integer userId,Integer basketId) {
        basketMapper.deleteProductByBasketIdInBasket(userId,basketId);
    }


}
