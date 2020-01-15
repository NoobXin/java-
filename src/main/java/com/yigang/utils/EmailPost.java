package com.yigang.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import com.sun.mail.util.MailSSLSocketFactory;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailPost {

    public static void postMail(String email,String description) throws Exception {
        Properties prop = new Properties();
        prop.setProperty("mail.host", "smtp.qq.com"); //// 设置QQ邮件服务器
        prop.setProperty("mail.transport.protocol", "smtp"); // 邮件发送协议
        prop.setProperty("mail.smtp.auth", "true"); // 需要验证用户名密码
        // 关于QQ邮箱，还要设置SSL加密，加上以下代码即可
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);

        //使用JavaMail发送邮件的5个步骤

        //创建定义整个应用程序所需的环境信息的 Session 对象
        Session session = Session.getDefaultInstance(prop, new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                //发件人邮件用户名、授权码
                return new PasswordAuthentication("827158171@qq.com", "ryhumoinbdrabcgc");
            }
        });
        //2、通过session得到transport对象
        Transport ts = session.getTransport();
        //3、使用邮箱的用户名和授权码连上邮件服务器
        ts.connect("smtp.qq.com", "827158171@qq.com", "ryhumoinbdrabcgc");
        //4、创建邮件
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("827158171@qq.com"));
        //指明邮件的收件人，现在发件人和收件人是一样的，那就是自己给自己发
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        //邮件的标题
        message.setSubject("报修信息");
        //邮件的文本内容
        message.setContent(description,"text/html;charset=UTF-8");
        //5、发送邮件
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

}
