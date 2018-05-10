package com.lstfight.qmonitorquartz.mail;

import javafx.util.Pair;

import java.io.File;
import java.util.List;

/**
 * @author lst
 * Created on 2018/5/9.
 */
public interface Emailer {
    /**
     * 发送简单邮件
     * @param sendTo 收件人地址
     * @param titel  邮件标题
     * @param content 邮件内容
     */
    public void sendSimpleMail(String sendTo, String titel, String content);

    /**
     * 发送简单邮件
     * @param sendTo 收件人地址
     * @param titel  邮件标题
     * @param content 邮件内容
     * @param attachments<文件名，附件> 附件列表
     */
    public void sendAttachmentsMail(String sendTo, String titel, String content, List<Pair<String, File>> attachments);

}
