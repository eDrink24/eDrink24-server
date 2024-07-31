package org.eDrink24.controller.dibs;

import org.eDrink24.dto.basket.BasketDTO;
import org.eDrink24.dto.dibs.DibDTO;
import org.eDrink24.dto.store.StoreDTO;
import org.eDrink24.service.basket.BasketService;
import org.eDrink24.service.dibs.DibService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DibController {

    DibService dibService;

    public DibController(DibService dibService) {
        this.dibService = dibService;
    }

    // 상품 찜하기(dibs 테이블에 저장)
    @PostMapping(value = {"/addDibs"})
    public void addDibs(@RequestBody DibDTO dibDTO) {
        dibService.addDibs(dibDTO);
    }

    // 매장 목록 조회
    @GetMapping("/showAllDibs/loginId/{loginId}")
    public ResponseEntity<List<DibDTO>> showAllDibs(@PathVariable String loginId) {
        List<DibDTO> dibs = dibService.showAllDibs(loginId);
        return ResponseEntity.ok(dibs);
    }

}
