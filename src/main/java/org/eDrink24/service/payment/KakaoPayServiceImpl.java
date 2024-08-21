package org.eDrink24.service.payment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KakaoPayServiceImpl implements  KakaoPayService {
    @Value("${kakao_pay.secret_key}")
    private String secret_key;
    @Value("${client_url}")
    private String client_url;

    private static final String KAKAO_PAY_READY_URL = "https://open-api.kakaopay.com/online/v1/payment/ready";
    private static final String KAKAO_PAY_APPROVE_URL = "https://kapi.kakao.com/v1/payment/approve";
    private static final String CID = "TC0ONETIME"; // 테스트용

    @Override
    public Map<String, Object> kakaoPayReady() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        // 헤더설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "SECRET_KEY " + secret_key);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> params = new HashMap<>();
        params.put("cid", CID);
        params.put("partner_order_id", "order_id_12345");
        params.put("partner_user_id", "user_id_12345");
        params.put("item_name", "테스트 상품");
        params.put("quantity", "1");
        params.put("total_amount", "2200");
        params.put("tax_free_amount", "0");
        params.put("approval_url", "http://localhost:3000/eDrink24/order/payment/success");
        params.put("cancel_url", "http://localhost:3000/eDrink24/order/payment/cancel");
        params.put("fail_url", "http://localhost:3000/eDrink24/order/payment/fail");

        System.out.println("Request Headers: " + headers);
        System.out.println("Request Body: " + params);

        HttpEntity<Map<String, String>> body = new HttpEntity<>(params, headers);
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                KAKAO_PAY_READY_URL, HttpMethod.POST, body, new ParameterizedTypeReference<Map<String, Object>>() {});

        return response.getBody();
    }
}
