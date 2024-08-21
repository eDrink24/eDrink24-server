package org.eDrink24.service.payment;

import org.eDrink24.dto.payment.KakaoPayReadyResponse;
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
    @Value("${kakao_pay.cid}")
    private String cid;

    private static final String KAKAO_PAY_READY_URL = "https://open-api.kakaopay.com/online/v1/payment/ready";
    private static final String KAKAO_PAY_APPROVE_URL = "https://open-api.kakaopay.com/online/v1/payment/approve";


    @Override
    public Map<String, Object> kakaoPayReady() {
        RestTemplate restTemplate = new RestTemplate();

        // 헤더설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "SECRET_KEY " + secret_key);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> params = new HashMap<>();
        params.put("cid", cid);
        params.put("partner_order_id", "order_id_12345");
        params.put("partner_user_id", "user_id_12345");
        params.put("item_name", "테스트 상품");
        params.put("quantity", "1");
        params.put("total_amount", "2200");
        params.put("tax_free_amount", "0");
        params.put("approval_url", client_url+"/order/approval");
        params.put("cancel_url", client_url);
        params.put("fail_url", client_url);

        HttpEntity<Map<String, Object>> body = new HttpEntity<>(params, headers);
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                KAKAO_PAY_READY_URL, HttpMethod.POST, body, new ParameterizedTypeReference<Map<String, Object>>() {});
        return response.getBody();
    }


    @Override
    public Map<String, Object> kakaoPayApprove(String tid, String pgToken) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "SECRET_KEY " + secret_key);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> params = new HashMap<>();
        params.put("cid", cid);
        params.put("tid", tid);
        params.put("partner_order_id", "order_id_12345");
        params.put("partner_user_id", "user_id_12345");
        params.put("pg_token", pgToken);

        HttpEntity<Map<String, Object>> body = new HttpEntity<>(params, headers);

        ResponseEntity<Map> response = restTemplate.exchange(KAKAO_PAY_APPROVE_URL, HttpMethod.POST, body, Map.class);
        System.out.println("Pay Complete: " + response);
        return response.getBody();
    }
}
