package com.learnrest.rest.webservices.restfulwebservices.javamail.api;

import com.learnrest.rest.webservices.restfulwebservices.javamail.domain.JavaMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("/sendemail")
@CrossOrigin("http://localhost:4200")
public class JavaMailController {

    @Autowired
    public JavaMailSender emailSender;

    @PostMapping("/sendUserMail")
    public ResponseEntity<String> sendHtmlEmail(@RequestBody JavaMail javaMail) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

        String htmlMsg = "<h1> Hope General Clinic</h1>"+
                "<h3><b>DO NOT SHARE YOUR CREDENTIALS WITH ANYONE!!!</b></h3>"+
                "<p>" + "userName: " + javaMail.getUserName() + "<br>" +
                "password: " + javaMail.getPassword();

        message.setContent(htmlMsg, "text/html");
        helper.setTo(javaMail.getUserEmail());
        helper.setSubject("User Credentials");

        this.emailSender.send(message);

        return new ResponseEntity<>("Email Sent!", HttpStatus.OK);

    }
}
