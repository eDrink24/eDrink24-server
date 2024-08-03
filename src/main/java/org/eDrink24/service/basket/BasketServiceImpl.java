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
        // 저장할때는,
        // 부모 테이블 저장
        // 부모 아이디 리턴
        // 자식 테이블 저장 (부모 아이디 산입)
        basketMapper.saveProductToBasket(basketDTO);

        // 장나구니 자식 테이블 저장할떄는 패턴이 2개가 있는데, 둘 다 잘 쓰임
        // 1) recreate 패턴 -> 장바구니 아이템 전부 삭제 후 다시 생성
        // 2) update 패턴 -> 장바구니 아이템 전부 조회 후, 새로운 아이템 추가 & 기존 아이템 업데이트
    }

    @Override
    public List<BasketDTO> showProductInBasket(String loginId) {
        // 2번 조회 하여 DTO 를 꾸민다.
        // 부모 DTO 조회
        // 자식 DTO 조회
        // 부모 DTO에 자식 DTO를 넣는다.
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
