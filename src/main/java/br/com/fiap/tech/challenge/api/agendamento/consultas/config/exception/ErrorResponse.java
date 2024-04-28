package br.com.fiap.tech.challenge.api.agendamento.consultas.config.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {

    private HttpStatus httpStatus;
    private String message;
    private int code;

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.code = httpStatus.value();
    }

}
