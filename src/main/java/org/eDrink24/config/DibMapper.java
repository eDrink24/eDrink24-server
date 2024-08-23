package org.eDrink24.config;

import org.apache.ibatis.annotations.Mapper;
import org.eDrink24.dto.dibs.DibDTO;

import java.util.List;


@Mapper
public interface DibMapper {

    // 상품 찜하기(dibs 테이블에 저장)
    public void addDibs(DibDTO dibDTO);

    // 찜 목록 조회
    public List<DibDTO> showAllDibs(String loginId);

}
