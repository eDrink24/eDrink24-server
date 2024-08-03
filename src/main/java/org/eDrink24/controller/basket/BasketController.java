package org.eDrink24.controller.basket;

import com.nimbusds.jose.proc.SecurityContext;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.service.basket.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
public class BasketController {

    BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    // basket 테이블에 userId, productId, basketQuantity 저장
    // loginId에 맞는 userId를 가져와서 BasketDTO 에 저장
    @PostMapping(value = {"/saveProductToBasket"})
    public void saveProductToBasket(@RequestBody BasketDTO basketDTO) {
       Integer userId = basketService.changeLoginIdToUserId(basketDTO.getLoginId());
       basketDTO.setUserId(userId);
       System.out.println(basketDTO);
       basketService.saveProductToBasket(basketDTO);
    }

    // userId에 따라서 장바구니에 저장한 목록 보여주기
    @GetMapping(value = {"/showProductInBasket/{loginId}"})
    public List<BasketDTO> showProductInBasket(@PathVariable String loginId) {
        return basketService.showProductInBasket(loginId);
    }

    // 장바구니에 있는 모든 목록 삭제하기
    @DeleteMapping(value = {"/deleteAllProductInBasket/{loginId}"})
    public void deleteAllProductInBasket(@PathVariable String loginId){
        basketService.deleteAllProductInBasket(loginId);
    }

    // 장바구니에 있는 목록 선택해서 삭제하기
    @DeleteMapping(value = {"/deleteProductByBasketIdInBasket/{loginId}/{basketId}"})
    public void deleteProductByBasketIdInBasket(@PathVariable String loginId,
                                                @PathVariable Integer basketId){
        basketService.deleteProductByBasketIdInBasket(loginId,basketId);
    }

}
