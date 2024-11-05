package dev.wayne.mail.config;

import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import static dev.wayne.mail.util.MailPropUtil.getProp;

@Configuration
public class MailConfig {

    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @Bean
    public JavaMailSenderImpl javaMailSender() {
        Session session = Session.getInstance(getProp(), new jakarta.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setSession(session);
        return mailSender;
    }
}
