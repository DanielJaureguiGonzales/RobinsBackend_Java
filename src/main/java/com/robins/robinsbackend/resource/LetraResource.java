package com.robins.robinsbackend.resource;

import com.robins.robinsbackend.domain.model.AuditModel;

import java.util.Date;

public class LetraResource extends AuditModel {

    private Long id;
    private Integer diasPorAnho;
    private Integer plazoTasa;
    private String tipoTasa;
    private Float porcentajeTasa;
    private Integer periodoCapital;
    private Date fechaDescuento;
    private Date fechaGiro;
    private Date fechaVencimiento;
    private Float valorNominal;
    private Float retencion;
    private String tipoMoneda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDiasPorAnho() {
        return diasPorAnho;
    }

    public void setDiasPorAnho(Integer diasPorAnho) {
        this.diasPorAnho = diasPorAnho;
    }

    public Integer getPlazoTasa() {
        return plazoTasa;
    }

    public void setPlazoTasa(Integer plazoTasa) {
        this.plazoTasa = plazoTasa;
    }

    public String getTipoTasa() {
        return tipoTasa;
    }

    public void setTipoTasa(String tipoTasa) {
        this.tipoTasa = tipoTasa;
    }

    public Float getPorcentajeTasa() {
        return porcentajeTasa;
    }

    public void setPorcentajeTasa(Float porcentajeTasa) {
        this.porcentajeTasa = porcentajeTasa;
    }

    public Integer getPeriodoCapital() {
        return periodoCapital;
    }

    public void setPeriodoCapital(Integer periodoCapital) {
        this.periodoCapital = periodoCapital;
    }

    public Date getFechaDescuento() {
        return fechaDescuento;
    }

    public void setFechaDescuento(Date fechaDescuento) {
        this.fechaDescuento = fechaDescuento;
    }

    public Date getFechaGiro() {
        return fechaGiro;
    }

    public void setFechaGiro(Date fechaGiro) {
        this.fechaGiro = fechaGiro;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Float getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(Float valorNominal) {
        this.valorNominal = valorNominal;
    }

    public Float getRetencion() {
        return retencion;
    }

    public void setRetencion(Float retencion) {
        this.retencion = retencion;
    }

    public String getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
}
