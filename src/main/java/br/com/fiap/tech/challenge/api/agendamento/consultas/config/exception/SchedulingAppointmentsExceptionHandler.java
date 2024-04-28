package br.com.fiap.tech.challenge.api.agendamento.consultas.config.exception;

import br.com.fiap.tech.challenge.api.agendamento.consultas.exception.SchedulingAppointmentsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SchedulingAppointmentsExceptionHandler {

    @ExceptionHandler(SchedulingAppointmentsException.class)
    public ResponseEntity<ErrorResponse> handleException(SchedulingAppointmentsException e) {
        var errorResponse = new ErrorResponse(e.getHttpStatus(), e.getMessage());
        return new ResponseEntity<>(errorResponse, e.getHttpStatus());
    }

}
