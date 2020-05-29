package com.luzj.mailsender.service;

import javax.mail.MessagingException;

/**
 * @author luzj
 * @description:
 * @date 2018/9/11
 */
public interface IMailService {
    /**
     * 发送文本文件
     * @param to 目标邮箱
     * @param subject 标题
     * @param content 内容
     */
    public void sendSimpleMail(String to,String subject,String content);
    public void sendSimpleMail(String to,String subject,String content,String... cc);

    /**
     * 发送Html邮件
     * @param to 发送地址
     * @param subject 标题
     * @param content html模板
     */
    public void sendHtmlMail(String to,String subject,String content) throws MessagingException;
    public void sendHtmlMail(String to,String subject,String content,String... cc);

    /**
     * 发送附件
     * @param to
     * @param subject
     * @param content
     * @param filePath 附件路径
     * @throws MessagingException
     */
    public void sendAttachmentsMail(String to,String subject,String content,String filePath) throws MessagingException;
    public void sendAttachmentsMail(String to,String subject,String content,String filePath,String... cc)
            throws MessagingException;


    /**
     * 发送有静态资源的邮件
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     * @throws MessagingException
     */
    public void sendResourceMail(String to,String subject,String content,String rscPath,String rscId)
            throws MessagingException;
    public void sendResourceMail(String to,String subject,String content,String rscPath,String rscId,
                                 String... cc);








}
