package com.robins.robinsbackend.resource;

import com.robins.robinsbackend.domain.model.AuditModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CosteResource extends AuditModel {

    private Long id;
    private Boolean tipo;
    private String motivo;
    private Boolean valorExpresado;
    private Float monto;

}
