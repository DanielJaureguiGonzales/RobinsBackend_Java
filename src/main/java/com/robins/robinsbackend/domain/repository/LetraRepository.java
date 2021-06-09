package com.robins.robinsbackend.domain.repository;

import com.robins.robinsbackend.domain.model.Letra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetraRepository extends JpaRepository<Letra,Long> {
}
