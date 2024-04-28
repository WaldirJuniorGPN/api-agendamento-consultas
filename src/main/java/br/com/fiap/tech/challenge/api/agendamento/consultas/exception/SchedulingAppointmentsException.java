package br.com.fiap.tech.challenge.api.agendamento.consultas.exception;

import org.springframework.http.HttpStatus;

public class SchedulingAppointmentsException extends RuntimeException {

    private final ErrorCode errorCode;

    public SchedulingAppointmentsException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus();
    }

    public int getCode() {
        return errorCode.getCode();
    }

}
