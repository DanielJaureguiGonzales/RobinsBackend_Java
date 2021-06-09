package com.robins.robinsbackend.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="carteras")
public class Cartera extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @NotNull
    @Size(max = 11)
    @Column(unique = true)
    private String ruc;

}
