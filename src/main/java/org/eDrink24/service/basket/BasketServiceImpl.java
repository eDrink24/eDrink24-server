package org.eDrink24.service.basket;

import org.eDrink24.config.BasketMapper;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.basket.BasketItemDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class BasketServiceImpl implements BasketService {


    BasketMapper basketMapper;

    public BasketServiceImpl(BasketMapper basketMapper) {
        this.basketMapper = basketMapper;
    }


    @Override
    public void saveProductToBasket(BasketDTO basketDTO) {

        System.out.println(">>>>>>>>>>>>>>>>>>>>." + basketDTO);

        //부모 테이블에 저장
        basketMapper.saveBasket(basketDTO);
        // 부모 테이블에 저장 후 자동 생성된 basketId 설정
        Integer basketId = basketDTO.getBasketId();
        //자식 테이블에 저장
        List<BasketItemDTO> items2 = basketDTO.getItems();

        for (BasketItemDTO items : items2) {

            //기존에 장바구니에 있는 목록인지 확인
            BasketItemDTO AlreadyExistingItem = basketMapper.checkBasketItem(items.getProductId());

            //장바구니에 이미 제품이 존재할 때
            if (AlreadyExistingItem != null) {
                //수량 업데이트
                basketMapper.updateBasketQuantity(items.getProductId(),items.getBasketQuantity());
            }else {
                // 장바구니에 제품이 존재하지 않으면 새로 추가
                basketMapper.saveBasketItem(basketId, items);
            }
        }
    }

    @Override
    public List<BasketDTO> showProductInBasket(Integer userId) {
        List<BasketDTO> baskets = basketMapper.showProductInBasket(userId);

        for (BasketDTO basket : baskets) {
            List<BasketItemDTO> items = basketMapper.getBasketItems(basket.getBasketId());
            basket.setItems(items);
        }

        return baskets;
    }

    // 삭제할 때 주의할 점: 외래 키 제약 조건으로 인해 basket 테이블의 데이터를 삭제할 수 없다
    // 자식 테이블(BasketItem)의 데이터를 먼저 삭제하고, 이후에 부모 테이블(basket)의 데이터를 삭제하도록 해야함.
    @Override
    public void deleteAllProductInBasket(Integer userId) {
        basketMapper.deleteAllBasketItems(userId);
        basketMapper.deleteAllBasket(userId);
    }


    @Override
    public void deleteProductByBasketIdInBasket(Integer userId, Integer basketId) {
        basketMapper.deleteSelectedBasketItems(basketId);
        basketMapper.deleteSelectedBasket(userId, basketId);
    }

}
