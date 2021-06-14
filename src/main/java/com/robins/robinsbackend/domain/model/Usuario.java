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

    public Usuario() {
    }

    public Usuario(Long id, @NotNull @Size(max = 15) String contrasenha, @NotNull String nombre, @NotNull @Size(max = 8) String dni, @NotNull @Size(max = 100) String telefono, @NotNull String correo) {
        this.id = id;
        this.contrasenha = contrasenha;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
