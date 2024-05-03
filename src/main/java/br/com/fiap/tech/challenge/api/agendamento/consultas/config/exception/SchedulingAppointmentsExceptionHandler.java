package br.com.fiap.tech.challenge.api.agendamento.consultas.config.exception;

import br.com.fiap.tech.challenge.api.agendamento.consultas.exception.SchedulingAppointmentsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SchedulingAppointmentsExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulingAppointmentsExceptionHandler.class);

    @ExceptionHandler(SchedulingAppointmentsException.class)
    public ResponseEntity<ErrorResponse> handleException(SchedulingAppointmentsException e) {
        var errorResponse = new ErrorResponse(e.getHttpStatus(), e.getMessage());

        if (e.getErrorCode().isStackTrace()) {
            LOGGER.error("Error", e);
        } else {
            LOGGER.error("Error: {}", errorResponse.getMessage());
        }

        return new ResponseEntity<>(errorResponse, e.getHttpStatus());
    }

}
