package com.robins.robinsbackend.resource;

import javax.validation.constraints.*;

public class SaveCarteraResource {

    @NotNull
    @NotBlank
    private String nombreEmpresa;

    @NotNull
    @NotBlank
    @Size(max = 11)
    private String ruc;

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
