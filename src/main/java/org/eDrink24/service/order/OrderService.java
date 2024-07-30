package org.eDrink24.service.order;

import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;

import java.util.List;

public interface OrderService {

    // 장바구니에 담긴 상품 불러오기
    public List<BasketDTO> showAllBasket(Integer userId);

    // 결제하기(ORDERS 테이블에 저장)
    public int buyProduct(List<OrderTransactionDTO> orderTransactionDTO);

    // 결제내역 저장(ORDERSHISTORY 테이블에 저장)
    public int saveBuyHistory(List<OrderTransactionDTO> orderTransactionDTO);

    // buyProduct, saveBuyHistory 동시에 트랙잭션으로 처리
    public void buyProductAndSaveHistory(List<OrderTransactionDTO> orderTransactionDTO);


}
