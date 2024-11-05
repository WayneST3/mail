package dev.wayne.mail.controller;

import dev.wayne.mail.dto.MailDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public interface MailController {

    @Operation(summary = "Отправление сообщения на почту",
            operationId = "send_mail",
            description = "Отправить сообщения на почту")
    @ApiResponse(responseCode = "" + HttpServletResponse.SC_NO_CONTENT, description = "Сообщение успешно отправлено")
    @ApiResponse(responseCode = "" + HttpServletResponse.SC_BAD_REQUEST, description = "Ошибка отправки сообщения")
    @PostMapping("/send")
    ResponseEntity<?> send(MailDto mailDto);
}
