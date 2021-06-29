package com.robins.robinsbackend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    private String contrasenha;

    @NotNull
    private String nombre;

    @NotNull
    @Size(max = 8)
    @Column(unique = true)
    private String dni;

    @NotNull
    @Size(max = 100)
    private String telefono;

    @NotNull
    @Column(unique = true)
    private String correo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Letra> letras;

}
