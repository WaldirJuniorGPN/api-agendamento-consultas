package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import lombok.Getter;

@Getter
public enum WorkingDay {

    MONDAY("SEGUNDA", 1),
    TUESDAY("TERÇA", 2),
    WEDNESDAY("QUARTA", 3),
    THURSDAY("QUINTA", 4),
    FRIDAY("SEXTA", 5),
    SATURDAY("SÁBADO", 6),
    SUNDAY("DOMINGO", 7);

    private final String description;
    private final int dayOfWeek;

    WorkingDay(String description, int dayOfWeek) {
        this.description = description;
        this.dayOfWeek = dayOfWeek;
    }

    public static WorkingDay fromDayOfWeek(int dayOfWeek) {
        for (WorkingDay workingDay : WorkingDay.values()) {
            if (workingDay.dayOfWeek == dayOfWeek) {
                return workingDay;
            }
        }
        return null;
    }

    public static WorkingDay fromDescription(String description) {
        for (WorkingDay workingDay : WorkingDay.values()) {
            if (workingDay.description.equals(description)) {
                return workingDay;
            }
        }
        return null;
    }

}
