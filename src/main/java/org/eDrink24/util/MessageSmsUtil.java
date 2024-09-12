package org.eDrink24.util;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class MessageSmsUtil {
    @Value("${coolsms.api.key}")
    private String apiKey;
    @Value("${coolsms.api.secret}")
    private String apiSecretKey;
    @Value("${coolsms.api.fromNumber}")
    private String fromNumber;

    private DefaultMessageService defaultMessageService;

    @PostConstruct
    private void init(){
        this.defaultMessageService
                = NurigoApp.INSTANCE.initialize(apiKey, apiSecretKey, "https://api.coolsms.co.kr");
    }

    public String createCertificateCode() {
        Random rand = new Random();
        String createCertificateCode = new Random().ints(6, 0, 10)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
        return createCertificateCode;
    };

    // SingleMessageSentResponse
    public SingleMessageSentResponse sendMessage(String phoneNum, String certificateCode) {
        try {
            Message message = new Message();
            message.setFrom(fromNumber);
            message.setTo(phoneNum);
            message.setText("[eDrink24] 인증번호 [" + certificateCode + "]");
            SingleMessageSentResponse response = this.defaultMessageService.sendOne(new SingleMessageSendingRequest(message));
            return response;
        } catch (Exception e) {
            throw new RuntimeException("메시지 전송 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

}
