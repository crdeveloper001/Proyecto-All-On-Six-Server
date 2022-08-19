package com.example.allon6webserver.Services;

import com.example.allon6webserver.DTO.EmailDTO;
import com.example.allon6webserver.Interfaces.IEmails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailsService implements IEmails {

    @Autowired
    private JavaMailSenderImpl mailSender;

    public EmailsService(JavaMailSenderImpl _javaMailSender){
        this.mailSender = _javaMailSender;
    }

    @Override
    public JavaMailSender getJavaMailSender() {
        mailSender.setHost("smtpout.secureserver.net");
        mailSender.setPort(587);
        mailSender.setUsername("Meditur@allonsixcostarica.com");
        mailSender.setPassword("Freerdental2020@");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtpout");
        props.put("mail.smtpout.auth", "true");
        props.put("mail.smtpout.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Override
    public String SendContactInformation(EmailDTO emailInformation) {

     try{
         SimpleMailMessage message = new SimpleMailMessage();
         message.setFrom("Meditur@allonsixcostarica.com");
         message.setCc("Hola@vostokcr.com");
         message.setTo("Meditur@allonsixcostarica.com");
         message.setSubject("Information Request From: "+emailInformation.getName());
         message.setText("Hi there: our system was receive a new message from the customer: "+emailInformation.getName()+"\n"+"" +
                 "This are the details about this client: "+"\n"+"_____________________________________________________________"+"\n" +
                 "Client Name: "+emailInformation.getName()+"\n"+
                 "Client Email Address: "+emailInformation.getEmail()+"\n"+
                 "Client Phone Number: "+emailInformation.getPhone()+"\n"+
                 "I want to be contacted by: "+emailInformation.getTypeContactSelection()+"\n"+
                 "Do I have passport: "+emailInformation.getPassPort()+"\n"+
                 "Procedure that I am interested in: "+emailInformation.getProcedureSelection()+"\n"+
                 "----------------------------------------- ------------------------------------------");

         mailSender.send(message);

         return "Thank you! "+emailInformation.getName()+ " Your information has sended";
     }catch (Exception errorEmailSender){

         return errorEmailSender.getMessage();
     }
    }
}
