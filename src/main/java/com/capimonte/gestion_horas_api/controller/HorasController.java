package com.capimonte.gestion_horas_api.controller;

import com.capimonte.gestion_horas_api.dto.HorasTrabajadasDTO;
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
    public List<HorasTrabajadasDTO> listarHoras() {
        return horasService.listarHoras();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorasTrabajadasDTO> obtenerHora(@PathVariable Long id) {
        return horasService.obtenerHora(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public HorasTrabajadasDTO crearHora(@RequestBody HorasTrabajadasDTO dto) {
        return horasService.guardarHora(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HorasTrabajadasDTO> actualizarHora(
            @PathVariable Long id,
            @RequestBody HorasTrabajadasDTO dto) {
        dto.setId(id);
        return ResponseEntity.ok(horasService.guardarHora(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHora(@PathVariable Long id) {
        horasService.eliminarHora(id);
        return ResponseEntity.noContent().build();
    }
}

