package com.robins.robinsbackend.domain.repository;

import com.robins.robinsbackend.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
