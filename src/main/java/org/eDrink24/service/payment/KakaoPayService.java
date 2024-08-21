package org.eDrink24.service.payment;

import java.util.Map;

public interface KakaoPayService {
    public Map<String, Object> kakaoPayReady();
    public Map<String, Object> kakaoPayApprove(String tid, String pgToken);
}
