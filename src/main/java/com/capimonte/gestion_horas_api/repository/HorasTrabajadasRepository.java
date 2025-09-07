package com.capimonte.gestion_horas_api.repository;

import com.capimonte.gestion_horas_api.model.HorasTrabajadas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorasTrabajadasRepository extends JpaRepository<HorasTrabajadas, Long> {
}

