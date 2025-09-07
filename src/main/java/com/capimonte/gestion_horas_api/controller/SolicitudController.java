package com.capimonte.gestion_horas_api.controller;

import com.capimonte.gestion_horas_api.model.SolicitudPermiso;
import com.capimonte.gestion_horas_api.service.SolicitudPermisoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudPermisoService solicitudService;

    public SolicitudController(SolicitudPermisoService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public List<SolicitudPermiso> listarSolicitudes() {
        return solicitudService.listarPermisos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudPermiso> obtenerSolicitud(@PathVariable Long id) {
        return solicitudService.obtenerPermiso(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SolicitudPermiso crearSolicitud(@RequestBody SolicitudPermiso solicitud) {
        return solicitudService.guardarPermiso(solicitud);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SolicitudPermiso> actualizarSolicitud(@PathVariable Long id, @RequestBody SolicitudPermiso solicitud) {
        return solicitudService.obtenerPermiso(id)
                .map(s -> {
                    solicitud.setId(id);
                    return ResponseEntity.ok(solicitudService.guardarPermiso(solicitud));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        if (solicitudService.obtenerPermiso(id).isPresent()) {
            solicitudService.eliminarPermiso(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

