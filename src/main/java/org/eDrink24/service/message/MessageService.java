package org.eDrink24.service.message;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

@Service
public class MessageService {
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

    private String createRandomNumber() {
        Random rand = new Random();
        String randomNumber = "";
        for (int i = 0; i < 6; i++) {
            String random = Integer.toString(rand.nextInt(10));
            randomNumber += random;
        }
        return randomNumber;
    };
    // SingleMessageSentResponse
    public SingleMessageSentResponse sendMessage(String to) {
        try {
            String randomNum = createRandomNumber();
            Message message = new Message();
            message.setFrom(fromNumber);
            message.setTo("01083446235");
            message.setText("[eDrink24] 인증번호 [" + randomNum + "]");
            SingleMessageSentResponse response = this.defaultMessageService.sendOne(new SingleMessageSendingRequest(message));
            System.out.println(response);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("메시지 전송 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
