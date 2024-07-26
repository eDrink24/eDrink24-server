package org.eDrink24.service.order;

import org.eDrink24.config.OrderMapper;
import org.eDrink24.config.ProductMapper;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderDTO;
import org.eDrink24.dto.product.DetailProductDTO;
import org.eDrink24.dto.product.ProductDTO;
import org.eDrink24.service.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

   OrderMapper orderMapper;

   public OrderServiceImpl(OrderMapper orderMapper) {
      this.orderMapper = orderMapper;
   }
    
    @Override
    public List<BasketDTO> showAllBasket() {
        return orderMapper.showAllBasket();
    }

    @Override
    public int buyProduct(List<OrderDTO> orderDTO) {
        return orderMapper.buyProduct(orderDTO);
    }


}
