package org.eDrink24.service.message;

import org.eDrink24.dto.message.MessageSmsDTO;

public interface MessageSmsService {
    public void sendMessageSms(MessageSmsDTO messageSmsDTO);
    public void verifyMessageSms(MessageSmsDTO messageSmsDTO);
    public boolean isVerified(MessageSmsDTO messageSmsDTO);
}
