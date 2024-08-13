package org.eDrink24.service.order;

import org.eDrink24.config.BasketMapper;
import org.eDrink24.config.OrderMapper;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.basket.BasketItemDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    OrderMapper orderMapper;
    BasketMapper basketMapper;

    public OrderServiceImpl(OrderMapper orderMapper, BasketMapper basketMapper) {
        this.orderMapper = orderMapper;
        this.basketMapper = basketMapper;
    }

    @Override
    public List<BasketDTO> showAllBasket(String loginId) {
        return orderMapper.showAllBasket(loginId);
    }

    @Override
    public int buyProduct(List<OrderTransactionDTO> orderTransactionDTO) {
        return orderMapper.buyProduct(orderTransactionDTO);
    }

    @Override
    public int saveBuyHistory(List<OrderTransactionDTO> orderTransactionDTO) {
        return orderMapper.saveBuyHistory(orderTransactionDTO);
    }

    @Override
    public void deleteBasketItems( HashMap<String , Object> map) {
        orderMapper.deleteBasketItems(map);
    }

    @Override
    public void deleteBasket( HashMap<String , Object> map) {
        orderMapper.deleteBasket(map);
    }

    @Transactional
    public void buyProductAndSaveHistory(List<OrderTransactionDTO> orderTransactionDTO) {
        if (orderTransactionDTO != null && !orderTransactionDTO.isEmpty()) {
            // 주문 저장
            orderMapper.buyProduct(orderTransactionDTO);

            // 주문 내역 저장
            orderMapper.saveBuyHistory(orderTransactionDTO);
        }
    }

    @Transactional
    public void deleteBasketAndItem(List<OrderTransactionDTO> orderTransactionDTO, Integer userId) {
        // basketId 목록 수집
        List<Integer> basketIds = orderTransactionDTO.stream()
                .map(OrderTransactionDTO::getBasketId)
                .distinct()
                .collect(Collectors.toList());

        HashMap<String , Object> map = new HashMap<>();
        map.put("userid", userId);
        map.put("basketIds", basketIds);

            // basketItem에서 구매한 상품 삭제
            orderMapper.deleteBasketItems(map);
            // basket에서 구매한 상품 삭제
            orderMapper.deleteBasket(map);

    }

    @Override
    public void saveNotPurchasedBasket(BasketDTO basketDTO) {
        orderMapper.saveNotPurchasedBasket(basketDTO);
    }

    @Override
    public void saveNotPurchasedBasketItem(Integer basketId, BasketItemDTO items) {
        // Set basketId in item before saving
        items.setBasketId(basketId);
        orderMapper.saveNotPurchasedBasketItem(basketId, items);
    }

    @Transactional
    public void saveNotPurchasedBasketAndItems(Integer userId, List<BasketDTO> basketDTOList) {
        List<Integer> purchasedBasketIds = new ArrayList<>();

        // 구매한 basketId 목록 수집
        for (BasketDTO dto : basketDTOList) {
            Integer basketId = dto.getBasketId();
            if (basketId != null && !purchasedBasketIds.contains(basketId)) {
                purchasedBasketIds.add(basketId);
            }
        }

        List<BasketDTO> allBaskets = basketMapper.showProductInBasket(userId);
        List<BasketDTO> notPurchasedBaskets = allBaskets.stream()
                .filter(basket -> !purchasedBasketIds.contains(basket.getBasketId()))
                .collect(Collectors.toList());

        for (BasketDTO basket : notPurchasedBaskets) {
            // basket에 저장
            orderMapper.saveNotPurchasedBasket(basket);

            // basketItem에 저장
            List<BasketItemDTO> basketItems = basket.getItems();
            if (basketItems != null) {
                for (BasketItemDTO item : basketItems) {
                    orderMapper.saveNotPurchasedBasketItem(basket.getBasketId(), item);
                }
            }
        }
    }



}