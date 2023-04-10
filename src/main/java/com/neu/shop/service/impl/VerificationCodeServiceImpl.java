package com.neu.shop.service.impl;
import com.neu.shop.service.VerificationCodeSenderService;
import com.neu.shop.service.VerificationCodeService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

    private final Map<String, String> verificationCodeMap = new HashMap<>();

    @Override
    public boolean verifyCode(String phoneNumber, String code) {
        String savedCode = verificationCodeMap.get(phoneNumber);
        return savedCode != null && savedCode.equals(code);
    }

    @RabbitListener(queues = "verification-code-queue")
    public void receiveMessage(String message) {
        String[] parts = message.split(":");
        String phoneNumber = parts[0];
        String code = parts[1];
        verificationCodeMap.put(phoneNumber, code);
    }
}
