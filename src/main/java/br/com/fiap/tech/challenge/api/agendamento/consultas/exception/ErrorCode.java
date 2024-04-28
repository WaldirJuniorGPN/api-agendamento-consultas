package br.com.fiap.tech.challenge.api.agendamento.consultas.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    SPECIALTY_NOT_FOUND("Especialização não encontrada", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;
    private final int code;

    ErrorCode(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.code = httpStatus.value();
    }

}
