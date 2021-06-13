package com.robins.robinsbackend.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "usuarios")
public class Usuario extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    private String contrasenha;

    @NotNull
    private String nombre;

    @NotNull
    @Size(max = 8)
    @Column(unique = true)
    private String dni;

    @NotNull
    @Size(max = 100)
    private String telefono;

    @NotNull
    @Column(unique = true)
    private String correo;

}
