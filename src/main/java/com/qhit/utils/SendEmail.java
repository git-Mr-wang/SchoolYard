package com.qhit.utils;


//import com.sun.mail.util.MailSSLSocketFactory;

import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;


/**
 * Created by 16682 on 2019/3/26.
 */
@Component
public class SendEmail {
    public static String ssendemail(String to) throws GeneralSecurityException, GeneralSecurityException {

        //六位数验证码
        String count="";

        // 收件人电子邮箱
//        to = "@qq.com";

        // 发件人电子邮箱
        String from = "908589432@qq.com";

        // 指定发送邮件的主机为 smtp.qq.com
        String host = "smtp.qq.com";  //QQ 邮件服务器

        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("908589432@qq.com", "dlomvzsecycfbeic"); //发件人邮件用户名、密码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject("校园通验证码");

            // 设置消息体
            Random random=new Random();

            for (int i = 1; i <=6 ; i++) {
                count += random.nextInt(10)+"";
            }
            message.setText("请输入此六位数验证码\r\n有效时间为五分钟\r\n"+count+"");

            // 发送消息
            Transport.send(message);
            System.out.println("邮件已经发送！！！！");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return count;
    }
}
