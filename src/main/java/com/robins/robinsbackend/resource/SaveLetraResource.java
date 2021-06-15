package com.robins.robinsbackend.resource;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.Date;

@Getter
@Setter
public class SaveLetraResource {

    private Integer diasPorAnho;
    private Integer plazoTasa;
    private Boolean tipoTasa;
    private Float porcentajeTasa;
    private Integer periodoCapital;
    private Date fechadescuento;
    private Date fechaGiro;
    private Date fechaVencimiento;
    private Float valorNominal;
    private Float retencion;
    private Boolean tipoMoneda;
    private Long usuarioId;

}
