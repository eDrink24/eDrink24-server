package org.eDrink24.service.dibs;

import org.eDrink24.dto.dibs.DibDTO;

import java.util.List;

public interface DibService {

    // 상품 찜하기(dibs 테이블에 저장)
    public void addDibs(DibDTO dibDTO);

    // 찜 목록 조회
    public List<DibDTO> showAllDibs(String loginId);


}
