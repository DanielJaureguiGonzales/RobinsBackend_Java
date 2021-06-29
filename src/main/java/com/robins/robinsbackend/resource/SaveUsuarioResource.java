package com.robins.robinsbackend.resource;


import javax.validation.constraints.*;

public class SaveUsuarioResource {

    @NotNull
    @NotBlank
    @Size(max = 15)
    private String contrasenha;

    @NotNull
    @NotBlank
    private String nombre;

    @NotNull
    @NotBlank
    @Size(max = 8)
    private String dni;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String telefono;

    @NotNull
    @NotBlank
    private String correo;


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
