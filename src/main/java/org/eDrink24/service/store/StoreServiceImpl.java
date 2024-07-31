package org.eDrink24.service.store;

import org.eDrink24.config.OrderMapper;
import org.eDrink24.config.StoreMapper;
import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.order.OrderTransactionDTO;
import org.eDrink24.dto.store.StoreDTO;
import org.eDrink24.service.order.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    StoreMapper storeMapper;

   public StoreServiceImpl(StoreMapper storeMapper) {
      this.storeMapper = storeMapper;
   }


    @Override
    public List<StoreDTO> showAllStore() {
        return storeMapper.showAllStore();
    }
}
