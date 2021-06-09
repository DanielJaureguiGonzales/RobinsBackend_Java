package com.robins.robinsbackend.resource;

import com.robins.robinsbackend.domain.model.AuditModel;

public class CarteraResource extends AuditModel {

    private Long id;
    private String nombreEmpresa;
    private String ruc;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
}
