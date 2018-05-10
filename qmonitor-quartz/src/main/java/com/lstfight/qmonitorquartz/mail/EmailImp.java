package com.lstfight.qmonitorquartz.mail;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

/**
 * @author lst
 * Created on 2018/5/9.
 */
@Component
public class EmailImp implements Emailer {

    private final MyEmail emailConfig;

    private final JavaMailSender mailSender;

    @Autowired
    public EmailImp(MyEmail emailConfig, JavaMailSender mailSender) {
        this.emailConfig = emailConfig;
        this.mailSender = mailSender;
    }

    @Override
    public void sendSimpleMail(String sendTo, String titel, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailConfig.getEmailFrom());
        message.setTo(sendTo);
        message.setSubject(titel);
        message.setText(content);
        mailSender.send(message);
    }

    @Override
    public void sendAttachmentsMail(String sendTo, String titel, String content, List<Pair<String, File>> attachments) {

    }
}
