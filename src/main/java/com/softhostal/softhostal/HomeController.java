/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.softhostal.softhostal;

import com.softhostal.softhostal.models.Email;
import com.softhostal.softhostal.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author maria
 */
@Controller
public class HomeController {
    @Autowired
    private JavaMailSender emailSender;
    @RequestMapping("/")
    public String page() {
        EmailService.SolicitarEnvio(
                new Email("mariahuaccachi_123@hotmail.com","Mensaje de prueba","Pollo a la brasa"),
                emailSender);
        return "home";
    }
}
