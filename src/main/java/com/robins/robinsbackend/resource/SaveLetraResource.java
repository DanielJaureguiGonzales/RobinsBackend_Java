package com.robins.robinsbackend.resource;


import javax.validation.constraints.*;
import java.util.Date;

public class SaveLetraResource {

    @NotNull
    @NotBlank
    private Integer diasPorAnho;

    @NotNull
    @NotBlank
    private Integer plazoTasa;

    @NotNull
    @NotBlank
    private Boolean tipoTasa;

    @NotNull
    @NotBlank
    private Float porcentajeTasa;

    @Null
    private Integer periodoCapital;

    @NotNull
    @NotBlank
    private Date fechaDescuento;

    @NotNull
    @NotBlank
    private Date fechaGiro;

    @NotNull
    @NotBlank
    private Date fechaVencimiento;

    @NotNull
    @NotBlank
    private Float valorNominal;

    @NotNull
    private Float retencion;

    @NotNull
    @NotBlank
    private Boolean tipoMoneda;

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

    public Boolean getTipoTasa() {
        return tipoTasa;
    }

    public void setTipoTasa(Boolean tipoTasa) {
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

    public Boolean getTipoMoneda() {
        return tipoMoneda;
    }

    public void setTipoMoneda(Boolean tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
}
