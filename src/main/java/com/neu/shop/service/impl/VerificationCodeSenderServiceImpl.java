package com.neu.shop.service.impl;

import com.neu.shop.service.VerificationCodeSenderService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
//生产者
@Service
public class VerificationCodeSenderServiceImpl implements VerificationCodeSenderService {

    private final AmqpTemplate amqpTemplate;

    public VerificationCodeSenderServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendVerificationCode(String phoneNumber, String code) {
        amqpTemplate.convertAndSend("verification-code-exchange", "verification-code", phoneNumber + ":" + code);
    }
}

