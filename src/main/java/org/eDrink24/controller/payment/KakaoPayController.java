package org.eDrink24.controller.payment;

import lombok.extern.slf4j.Slf4j;
import org.eDrink24.service.payment.KakaoPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class KakaoPayController {
    @Autowired
    private KakaoPayService kakaoPayService;

    @GetMapping("/api/kakaoPay")
    public Map<String, Object> kakaoPayReady() {
        return kakaoPayService.kakaoPayReady();
    }

}
