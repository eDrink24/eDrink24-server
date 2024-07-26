package org.eDrink24.service.basket;

import org.eDrink24.config.BasketMapper;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.basket.BasketJoinProductDTO;
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
    public List<BasketJoinProductDTO> showProductInBasket(Integer userId) {
        return basketMapper.showProductInBasket(userId);
    }

    @Override
    public void deleteAllProductInBasket() {
        basketMapper.deleteAllProductInBasket();
    }

}
