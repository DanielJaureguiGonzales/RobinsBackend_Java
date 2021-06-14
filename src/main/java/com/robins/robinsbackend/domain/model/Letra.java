package com.robins.robinsbackend.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity

@Table(name="letras")
public class Letra extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "dias_por_anho")
    private Integer diasPorAnho;

    @NotNull
    @Column(name = "plazo_tasa")
    private Integer plazoTasa;

    @NotNull
    @Column(name = "tipo_tasa")
    private Boolean tipoTasa;

    @NotNull
    @Column(name = "porcentaje_tasa")
    private Float porcentajeTasa;

    @Null
    @Column(name = "periodo_capital")
    private Integer periodoCapital;

    @NotNull
    @Column(name = "fecha_descuento")
    private Date fechaDescuento;

    @NotNull
    @Column(name = "fecha_giro")
    private Date fechaGiro;

    @NotNull
    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @NotNull
    @Column(name = "valor_nominal")
    private Float valorNominal;

    @NotNull
    private Float retencion;

    @NotNull
    @Column(name = "tipo_moneda")
    private Boolean tipoMoneda;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuario;

    public Letra() {
    }

    public Letra(Long id, @NotNull Integer diasPorAnho, @NotNull Integer plazoTasa, @NotNull Boolean tipoTasa, @NotNull Float porcentajeTasa, @Null Integer periodoCapital, @NotNull Date fechaDescuento, @NotNull Date fechaGiro, @NotNull Date fechaVencimiento, @NotNull Float valorNominal, @NotNull Float retencion, @NotNull Boolean tipoMoneda, Usuario usuario) {
        this.id = id;
        this.diasPorAnho = diasPorAnho;
        this.plazoTasa = plazoTasa;
        this.tipoTasa = tipoTasa;
        this.porcentajeTasa = porcentajeTasa;
        this.periodoCapital = periodoCapital;
        this.fechaDescuento = fechaDescuento;
        this.fechaGiro = fechaGiro;
        this.fechaVencimiento = fechaVencimiento;
        this.valorNominal = valorNominal;
        this.retencion = retencion;
        this.tipoMoneda = tipoMoneda;
        this.usuario = usuario;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
