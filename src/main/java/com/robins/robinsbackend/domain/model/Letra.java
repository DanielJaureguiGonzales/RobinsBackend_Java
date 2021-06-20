package com.robins.robinsbackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="letras")
public class Letra extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "dias_por_anho")
    private Integer diasPorAnho;


    @Column(name = "plazo_tasa")
    private Integer plazoTasa;

    @Column(name = "tipo_tasa")
    private Boolean tipoTasa;


    @Column(name = "porcentaje_tasa")
    private Float porcentajeTasa;

    @Column(name = "valor_recibido")
    private Integer valor_recibido;

    @Column(name = "descuento")
    private Float descuento;

    @Column(name = "tcea")
    private Float tcea;

    @Column(name = "periodo_capital")
    private Integer periodoCapital;


    @Column(name = "fecha_descuento")
    private Date fechadescuento;


    @Column(name = "fecha_giro")
    private Date fechaGiro;


    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;


    @Column(name = "valor_nominal")
    private Float valorNominal;


    @Column(name = "retencion")
    private Float retencion;


    @Column(name = "tipo_moneda")
    private Boolean tipoMoneda;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


}
