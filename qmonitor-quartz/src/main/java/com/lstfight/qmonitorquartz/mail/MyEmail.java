package com.lstfight.qmonitorquartz.mail;


import org.springframework.stereotype.Component;

/**
 * @author lst
 * Created on 2018/5/9.
 */
@Component
public class MyEmail {

    private String emailFrom = "cylstnewhands@163.com";

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

}
