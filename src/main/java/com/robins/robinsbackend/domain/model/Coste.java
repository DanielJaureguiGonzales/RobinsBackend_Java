package com.robins.robinsbackend.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="costes")
public class Coste extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Boolean tipo;

    @NotNull
    private String motivo;

    @NotNull
    @Column(name = "valor_expresado")
    private Boolean valorExpresado;

    @NotNull
    private Float monto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "letra_id", nullable = false)
    private Letra letra;

    public Coste() {
    }

    public Coste(Long id, @NotNull Boolean tipo, @NotNull String motivo, @NotNull Boolean valorExpresado, @NotNull Float monto, Letra letra) {
        this.id = id;
        this.tipo = tipo;
        this.motivo = motivo;
        this.valorExpresado = valorExpresado;
        this.monto = monto;
        this.letra = letra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getTipo() {
        return tipo;
    }

    public void setTipo(Boolean tipo) {
        this.tipo = tipo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Boolean getValorExpresado() {
        return valorExpresado;
    }

    public void setValorExpresado(Boolean valorExpresado) {
        this.valorExpresado = valorExpresado;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Letra getLetra() {
        return letra;
    }

    public void setLetra(Letra letra) {
        this.letra = letra;
    }
}
