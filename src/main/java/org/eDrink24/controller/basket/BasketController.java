package org.eDrink24.controller.basket;

import org.eDrink24.dto.basket.BasketJoinProductDTO;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.service.basket.BasketService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BasketController {

    BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    // basket 테이블에 userId, productId, basketQuantity 저장
    @PostMapping(value = {"/saveProductToBasket"})
    public void saveProductToBasket(@RequestBody BasketDTO baksetDTO) {
        basketService.saveProductToBasket(baksetDTO);
        //basketService.saveProductToBasket(baksetDTO);
    }

    // userId에 따라서 장바구니에 저장한 목록 보여주기
    @GetMapping(value = {"/showProductInBasket/{userId}"})
    public List<BasketJoinProductDTO> showProductInBasket(@PathVariable Integer userId) {
        return basketService.showProductInBasket(userId);
    }

    // 장바구니에 있는 모든 목록 삭제하기
    @DeleteMapping(value = {"/deleteAllProductInBasket"})
    public void deleteAllProductInBasket(){
        basketService.deleteAllProductInBasket();
    }

}
