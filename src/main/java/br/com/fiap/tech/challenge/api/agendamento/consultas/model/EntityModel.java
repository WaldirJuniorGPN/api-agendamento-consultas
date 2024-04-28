package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class EntityModel {

    private LocalDateTime inputDate;

    private LocalDateTime updateDate;

     @PrePersist
     public void prePersist() {
         this.inputDate = LocalDateTime.now();
     }

    @PreUpdate
    public void preUpdate() {
        this.updateDate = LocalDateTime.now();
    }
}
