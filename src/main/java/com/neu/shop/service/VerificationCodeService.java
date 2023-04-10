package com.neu.shop.service;

public interface VerificationCodeService {
    boolean verifyCode(String phoneNumber, String code);
}