package com.robins.robinsbackend.resource;

import com.robins.robinsbackend.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LetraResource extends AuditModel {

    private Long id;
    private Integer diasPorAnho;
    private  Float valor_recibido;
    private  Float TCEA;
    /*private  Float SVR;
    private  Float STCEA;*/
    private Float Descuento;
    private Date fechaGiro;
    private Date fechaVencimiento;
    private Float valorNominal;
    private Float retencion;
    private String tipoMoneda;
    private Long usuarioId;

}
