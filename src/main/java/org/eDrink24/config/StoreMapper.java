package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.eDrink24.dto.store.StoreDTO;

import java.util.List;


@Mapper
public interface StoreMapper {

    // 매장 목록 조회
    public List<StoreDTO> showAllStore();

}
