package com.example.allon6webserver.Interfaces;

import com.example.allon6webserver.DTO.EmailDTO;
import org.springframework.mail.javamail.JavaMailSender;

public interface IEmails {

    JavaMailSender getJavaMailSender();
    String SendContactInformation(EmailDTO emailInformation);
}
