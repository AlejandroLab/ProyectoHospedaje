/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softhostal.softhostal.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.softhostal.softhostal.models.Email;
/**
 *
 * @author mmaria
 */
public class EmailService {
    public static void SolicitarEnvio(Email email, JavaMailSender emailSender) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("mariahj756@gmail.com");
            message.setTo(email.getTo());
            message.setSubject(email.getSubject());
            message.setText(email.getMessage());
            emailSender.send(message);
        } catch (Exception e) {  
        }
    }
}
