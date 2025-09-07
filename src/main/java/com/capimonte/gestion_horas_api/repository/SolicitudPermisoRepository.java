package com.capimonte.gestion_horas_api.repository;

import com.capimonte.gestion_horas_api.model.SolicitudPermiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudPermisoRepository extends JpaRepository<SolicitudPermiso, Long> {
}

