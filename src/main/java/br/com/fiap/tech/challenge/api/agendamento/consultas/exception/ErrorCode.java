package br.com.fiap.tech.challenge.api.agendamento.consultas.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@Getter
public enum ErrorCode {

    UNKNOWN_ERROR("Erro desconhecido", HttpStatus.INTERNAL_SERVER_ERROR, TRUE),
    SPECIALTY_NOT_FOUND("Especialização não encontrada", HttpStatus.NOT_FOUND, FALSE),
    PATIENT_NOT_FOUND("Paciente não encontrado", HttpStatus.NOT_FOUND, FALSE),
    ASSISTANT_NOT_FOUND("Auxiliar não encontrado", HttpStatus.NOT_FOUND, FALSE);

    private final String message;
    private final HttpStatus httpStatus;
    private final int code;
    private final boolean stackTrace;

    ErrorCode(String message, HttpStatus httpStatus, boolean stackTrace) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.code = httpStatus.value();
        this.stackTrace = stackTrace;
    }

}
