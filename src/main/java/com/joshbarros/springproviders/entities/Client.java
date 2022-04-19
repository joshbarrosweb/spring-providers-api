package com.joshbarros.springproviders.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{field.name.required}")
    private String name;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{field.cpf.required}")
    @CPF(message = "{field.cpf.invalid}")
    private String cpf;

    @Column(name = "created_at", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdAt;

    @PrePersist
    public void prePersist() {
        setCreatedAt(LocalDate.now());
    }
}
