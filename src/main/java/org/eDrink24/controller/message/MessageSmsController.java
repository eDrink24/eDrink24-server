package org.eDrink24.controller.message;

import lombok.extern.slf4j.Slf4j;
import org.eDrink24.dto.message.MessageSmsDTO;
import org.eDrink24.excpetion.message.SmsMismatchException;
import org.eDrink24.service.message.MessageSmsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MessageSmsController {

    private final MessageSmsService messageSmsService;

    public MessageSmsController(MessageSmsService messageSmsService) {
        this.messageSmsService = messageSmsService;
    }

    @PostMapping("/signup/sms/send")
    public ResponseEntity<String> sendMessageSms(@RequestBody MessageSmsDTO messageSmsDTO) {
        try {
            messageSmsService.sendMessageSms(messageSmsDTO);
            return new ResponseEntity<>("SMS 전송성공", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/signup/sms/check")
    public ResponseEntity<String> SmsVerification(@RequestBody MessageSmsDTO messageSmsDTO) {
        try {
            boolean isUsed = messageSmsService.isUsedPhoneNum(messageSmsDTO.getPhoneNum());
            if (isUsed) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 가입된 회원입니다.");
            } else {
                messageSmsService.verifyMessageSms(messageSmsDTO);
                return ResponseEntity.ok("인증 성공");
            }
        } catch (SmsMismatchException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
