package com.joshbarros.springproviders.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column
    private BigDecimal price;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
}