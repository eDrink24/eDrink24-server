package org.eDrink24.service.order;

import org.eDrink24.config.OrderMapper;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

   OrderMapper orderMapper;

   public OrderServiceImpl(OrderMapper orderMapper) {
      this.orderMapper = orderMapper;
   }
    
    @Override
    public List<BasketDTO> showAllBasket(Integer userId) {
        return orderMapper.showAllBasket(userId);
    }

    @Override
    public int buyProduct(List<OrderTransactionDTO> orderTransactionDTO) {
        return orderMapper.buyProduct(orderTransactionDTO);
    }

    @Override
    public int saveBuyHistory(List<OrderTransactionDTO> orderTransactionDTO) {
        return orderMapper.saveBuyHistory(orderTransactionDTO);
    }

    @Transactional
    public void buyProductAndSaveHistory(List<OrderTransactionDTO> orderTransactionDTO) {
        // 주문 저장
        if (orderTransactionDTO != null && !orderTransactionDTO.isEmpty()) {
            orderMapper.buyProduct(orderTransactionDTO);
        }

        // 주문 내역 저장
        if (orderTransactionDTO != null && !orderTransactionDTO.isEmpty()) {
            orderMapper.saveBuyHistory(orderTransactionDTO);
        }
    }

}
