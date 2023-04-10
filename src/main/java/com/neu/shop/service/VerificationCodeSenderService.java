package com.neu.shop.service;

public interface VerificationCodeSenderService {
    void sendVerificationCode(String phoneNumber, String code);
}
