package br.com.fiap.tech.challenge.api.agendamento.consultas.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class EntityModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 7268496271692023683L;

    @Column(name = "input_date")
    private LocalDateTime inputDate;

    @Column(name = "update_date")
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
