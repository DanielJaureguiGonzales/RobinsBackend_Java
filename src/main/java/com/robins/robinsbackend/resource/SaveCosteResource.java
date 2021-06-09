package com.robins.robinsbackend.resource;

import javax.validation.constraints.*;

public class SaveCosteResource {

    @NotNull
    @NotBlank
    @Size(max = 7)
    private String tipo;

    @NotNull
    @NotBlank
    private String motivo;

    @NotNull
    @NotBlank
    private Float valor;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
