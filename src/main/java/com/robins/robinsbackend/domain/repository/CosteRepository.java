package com.robins.robinsbackend.domain.repository;

import com.robins.robinsbackend.domain.model.Coste;
import com.robins.robinsbackend.domain.model.Letra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CosteRepository extends JpaRepository<Coste,Long> {

    List<Coste> getAllByLetra(Letra letra);
}
