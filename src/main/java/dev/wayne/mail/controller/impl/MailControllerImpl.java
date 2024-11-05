package dev.wayne.mail.controller.impl;

import dev.wayne.mail.controller.MailController;
import dev.wayne.mail.dto.MailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@RequiredArgsConstructor
public class MailControllerImpl implements MailController {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public ResponseEntity<?> send(MailDto mailDto) {
        MimeMessage mimeMessage = buildMimeMessage(mailDto);
        if (mimeMessage != null) {
            mailSender.send(mimeMessage);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    private MimeMessage buildMimeMessage(MailDto mailDto) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

            messageHelper.setFrom(username);
            messageHelper.setTo(mailDto.getMail());
            messageHelper.setSubject(mailDto.getHeader());
            messageHelper.setText(mailDto.getMessage());
            return mimeMessage;
        } catch (MessagingException e) {
            return null;
        }
    }
}
