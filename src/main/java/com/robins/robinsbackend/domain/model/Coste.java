package com.robins.robinsbackend.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="costes")
public class Coste extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 7)
    private String tipo;

    @NotNull
    private String motivo;

    @NotNull
    private Float valor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "letra_id", nullable = false)
    private Letra letra;

}
