package com.capimonte.gestion_horas_api.controller;

import com.capimonte.gestion_horas_api.model.HorasTrabajadas;
import com.capimonte.gestion_horas_api.service.HorasTrabajadasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horas")
public class HorasController {

    private final HorasTrabajadasService horasService;

    public HorasController(HorasTrabajadasService horasService) {
        this.horasService = horasService;
    }

    @GetMapping
    public List<HorasTrabajadas> listarHoras() {
        return horasService.listarHoras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorasTrabajadas> obtenerHora(@PathVariable Long id) {
        return horasService.obtenerHora(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HorasTrabajadas crearHora(@RequestBody HorasTrabajadas hora) {
        return horasService.guardarHora(hora);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorasTrabajadas> actualizarHora(@PathVariable Long id, @RequestBody HorasTrabajadas hora) {
        return horasService.obtenerHora(id)
                .map(h -> {
                    hora.setId(id);
                    return ResponseEntity.ok(horasService.guardarHora(hora));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHora(@PathVariable Long id) {
        if (horasService.obtenerHora(id).isPresent()) {
            horasService.eliminarHora(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
