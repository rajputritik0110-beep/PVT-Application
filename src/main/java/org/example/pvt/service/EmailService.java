package org.example.pvt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(String name, String email, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("munnic102@gmail.com");
        mail.setTo("munnic102@gmail.com"); // ✅ Your inbox
        mail.setSubject("New Contact Form Submission from " + name);
        mail.setText("Name: " + name + "\nEmail: " + email + "\nMessage:\n" + message);
        mailSender.send(mail);
        System.out.println("Mail sent successfully");
    }
}

