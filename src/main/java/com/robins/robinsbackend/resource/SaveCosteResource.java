package com.robins.robinsbackend.resource;

import javax.validation.constraints.*;

public class SaveCosteResource {

    @NotNull
    @NotBlank
    private Boolean tipo;

    @NotNull
    @NotBlank
    private String motivo;

    @NotNull
    @NotBlank
    private Boolean valorExpresado;

    @NotNull
    @NotBlank
    private Float valor;

    @NotNull
    @NotBlank
    private Long letraId;


    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Boolean getValorExpresado() {
        return valorExpresado;
    }

    public void setValorExpresado(Boolean valorExpresado) {
        this.valorExpresado = valorExpresado;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Long getLetraId() {
        return letraId;
    }

    public void setLetraId(Long letraId) {
        this.letraId = letraId;
    }
}
