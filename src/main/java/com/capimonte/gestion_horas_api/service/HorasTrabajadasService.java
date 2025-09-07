package com.capimonte.gestion_horas_api.service;

import com.capimonte.gestion_horas_api.model.HorasTrabajadas;
import com.capimonte.gestion_horas_api.repository.HorasTrabajadasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorasTrabajadasService {

    private final HorasTrabajadasRepository horasTrabajadasRepository;

    public HorasTrabajadasService(HorasTrabajadasRepository horasTrabajadasRepository) {
        this.horasTrabajadasRepository = horasTrabajadasRepository;
    }

    public List<HorasTrabajadas> listarHoras() {
        return horasTrabajadasRepository.findAll();
    }

    public Optional<HorasTrabajadas> obtenerHora(Long id) {
        return horasTrabajadasRepository.findById(id);
    }

    public HorasTrabajadas guardarHora(HorasTrabajadas hora) {
        return horasTrabajadasRepository.save(hora);
    }

    public void eliminarHora(Long id) {
        horasTrabajadasRepository.deleteById(id);
    }
}

