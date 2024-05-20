package br.com.fiap.tech.challenge.api.scheduling.medical.appointments.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@Getter
public class SchedulingAppointmentsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -50956220809772608L;

    private final ErrorCode errorCode;

    public SchedulingAppointmentsException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return errorCode.getHttpStatus();
    }
}
