package br.com.fiap.tech.challenge.api.agendamento.consultas.config.exception;

import br.com.fiap.tech.challenge.api.agendamento.consultas.exception.SchedulingAppointmentsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class SchedulingAppointmentsExceptionHandler {

    @ExceptionHandler(SchedulingAppointmentsException.class)
    public ResponseEntity<ErrorResponse> handleException(SchedulingAppointmentsException e) {
        var errorResponse = new ErrorResponse(e.getHttpStatus(), e.getMessage());

        if (e.getErrorCode().isStackTrace()) {
            log.error("Error", e);
        } else {
            log.error("Error: {}", errorResponse.getMessage());
        }

        return new ResponseEntity<>(errorResponse, e.getHttpStatus());
    }

}
