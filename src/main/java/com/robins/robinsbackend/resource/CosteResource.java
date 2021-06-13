package com.robins.robinsbackend.resource;

import com.robins.robinsbackend.domain.model.AuditModel;

public class CosteResource extends AuditModel {

    private Long id;
    private Boolean tipo;
    private String motivo;
    private Boolean valorExpresado;
    private Float valor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
