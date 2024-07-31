package org.eDrink24.service.message;

import org.eDrink24.dto.message.MessageSmsDTO;
import org.eDrink24.excpetion.message.SmsMismatchException;
import org.eDrink24.repository.message.MessageSmsRepository;
import org.eDrink24.util.MessageSmsUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageSmsServiceImpl implements MessageSmsService {

    private final MessageSmsRepository messageSmsRepository;
    private MessageSmsUtil messageSmsUtil;

    public MessageSmsServiceImpl(MessageSmsUtil messageSmsUtil, MessageSmsRepository messageSmsRepository) {
        this.messageSmsUtil = messageSmsUtil;
        this.messageSmsRepository = messageSmsRepository;
    }

    @Override
    public void sendMessageSms(MessageSmsDTO messageSmsDTO) {
        String phoneNum = messageSmsDTO.getPhoneNum();
        String certificateCode = messageSmsUtil.createCertificateCode();
        messageSmsUtil.sendMessage(phoneNum, certificateCode);
        messageSmsRepository.createSmsCertification(phoneNum, certificateCode);
    }

    @Override
    public void verifyMessageSms(MessageSmsDTO messageSmsDTO) {
        if (!isVerified(messageSmsDTO)) {
            throw new SmsMismatchException("인증번호가 일치하지 않습니다.");
        }
        messageSmsRepository.removeSmsCertification(messageSmsDTO.getPhoneNum());
    }

    @Override
    public boolean isVerified(MessageSmsDTO messageSmsDTO) {
        String storedData = messageSmsRepository.getSmsCertification(messageSmsDTO.getPhoneNum());
        return storedData != null && storedData.equals(messageSmsDTO.getCertificateCode());
    }
}
