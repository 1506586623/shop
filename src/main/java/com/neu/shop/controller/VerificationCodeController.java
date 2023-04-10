package com.neu.shop.controller;

import com.neu.shop.service.VerificationCodeSenderService;
import com.neu.shop.service.VerificationCodeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/verification-code")
public class VerificationCodeController {

    private final VerificationCodeSenderService verificationCodeSenderService;
    private final VerificationCodeService verificationCodeService;

    public VerificationCodeController(VerificationCodeSenderService verificationCodeSenderService, VerificationCodeService verificationCodeService) {
        this.verificationCodeSenderService = verificationCodeSenderService;
        this.verificationCodeService = verificationCodeService;
    }

    @PostMapping("/send")
    public void sendVerificationCode(@RequestParam String phoneNumber) {
        // 生成随机验证码
        String code = generateCode();
        // 调用Service发送验证码
        verificationCodeSenderService.sendVerificationCode(phoneNumber, code);
    }

    @PostMapping("/verify")
    public boolean verifyCode(@RequestParam String phoneNumber, @RequestParam String code) {
        return verificationCodeService.verifyCode(phoneNumber, code);
    }

    private String generateCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}

