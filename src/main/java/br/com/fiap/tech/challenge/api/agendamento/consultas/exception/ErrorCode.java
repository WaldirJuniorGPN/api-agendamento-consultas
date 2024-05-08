package br.com.fiap.tech.challenge.api.agendamento.consultas.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
public enum ErrorCode {

    UNKNOWN_ERROR("Erro desconhecido", INTERNAL_SERVER_ERROR, TRUE),
    SPECIALTY_NOT_FOUND("Especialização não encontrada", NOT_FOUND, FALSE),
    PATIENT_NOT_FOUND("Paciente não encontrado", NOT_FOUND, FALSE),
    ASSISTANT_NOT_FOUND("Auxiliar não encontrado", NOT_FOUND, FALSE),
    MEDICAL_INSURANCE_NOT_FOUND("Convênio não encontrado", NOT_FOUND, FALSE),
    DOCTOR_NOT_FOUND("Doutor não encontrado", NOT_FOUND, FALSE),
    SCHEDULE_NOT_FOUND("Agendamento não encontrado", NOT_FOUND, FALSE),
    MAX_DOCTOR_SCHEDULE_CREATED("O doutor atingiu o limite de agendamento criado", BAD_REQUEST, FALSE),
    SCHEDULE_FOUND_FOR_DOCTOR("Agendamento encontrado para o doutor informado. Por favor editar os agendamentos existentes do médico", BAD_REQUEST, FALSE);

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
