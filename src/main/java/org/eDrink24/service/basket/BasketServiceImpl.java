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
    public Integer changeLoginIdToUserId(String loginId) {
        return basketMapper.changeLoginIdToUserId(loginId);
    }

    @Override
    public void saveProductToBasket(BasketDTO basketDTO) {
        basketMapper.saveProductToBasket(basketDTO);
    }

    @Override
    public List<BasketDTO> showProductInBasket(String loginId) {
        return basketMapper.showProductInBasket(loginId);
    }

    @Override
    public void deleteAllProductInBasket(String loginId) {
        basketMapper.deleteAllProductInBasket(loginId);
    }

    @Override
    public void deleteProductByBasketIdInBasket(String loginId,Integer basketId) {
        basketMapper.deleteProductByBasketIdInBasket(loginId,basketId);
    }


}
