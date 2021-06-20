package com.robins.robinsbackend.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SaveCosteResource {


    private Boolean tipo;

    private String motivo;

    private Boolean valorExpresado;

    private Float monto;
    private Long letraId;



}
