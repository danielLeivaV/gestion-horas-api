package com.capimonte.gestion_horas_api.service;

import com.capimonte.gestion_horas_api.model.SolicitudPermiso;
import com.capimonte.gestion_horas_api.repository.SolicitudPermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudPermisoService {

    private final SolicitudPermisoRepository solicitudPermisoRepository;

    public SolicitudPermisoService(SolicitudPermisoRepository solicitudPermisoRepository) {
        this.solicitudPermisoRepository = solicitudPermisoRepository;
    }

    public List<SolicitudPermiso> listarPermisos() {
        return solicitudPermisoRepository.findAll();
    }

    public Optional<SolicitudPermiso> obtenerPermiso(Long id) {
        return solicitudPermisoRepository.findById(id);
    }

    public SolicitudPermiso guardarPermiso(SolicitudPermiso permiso) {
        return solicitudPermisoRepository.save(permiso);
    }

    public void eliminarPermiso(Long id) {
        solicitudPermisoRepository.deleteById(id);
    }
}

