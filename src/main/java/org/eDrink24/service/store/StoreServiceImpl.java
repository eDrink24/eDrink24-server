package org.eDrink24.service.store;

import org.eDrink24.dto.store.StoreDTO;
import org.eDrink24.domain.store.Store;
import org.eDrink24.repository.store.StoreRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StoreDTO> findAllStores() {
        List<Store> stores = storeRepository.findAll();
        return stores.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private StoreDTO convertToDTO(Store store) {
        return modelMapper.map(store, StoreDTO.class);
    }
}
