package com.example.inventoryalert.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendLowStockAlert(List<String> toEmails, String productName, int stock) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1274370263@qq.com");
        message.setTo(toEmails.toArray(new String[0]));
        message.setSubject("库存预警通知");
        message.setText(String.format("商品 %s 库存不足！当前库存：%d", productName, stock));
        mailSender.send(message);
    }
}