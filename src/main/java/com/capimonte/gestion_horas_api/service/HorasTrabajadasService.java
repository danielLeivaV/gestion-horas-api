package com.capimonte.gestion_horas_api.service;

import com.capimonte.gestion_horas_api.dto.HorasTrabajadasDTO;
import com.capimonte.gestion_horas_api.mapper.HorasTrabajadasMapper;
import com.capimonte.gestion_horas_api.model.HorasTrabajadas;
import com.capimonte.gestion_horas_api.model.Usuario;
import com.capimonte.gestion_horas_api.model.Proyecto;
import com.capimonte.gestion_horas_api.repository.HorasTrabajadasRepository;
import com.capimonte.gestion_horas_api.repository.UsuarioRepository;
import com.capimonte.gestion_horas_api.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HorasTrabajadasService {

    private final HorasTrabajadasRepository horasRepo;
    private final UsuarioRepository usuarioRepo;
    private final ProyectoRepository proyectoRepo;
    private final HorasTrabajadasMapper mapper;

    public HorasTrabajadasService(HorasTrabajadasRepository horasRepo,
                                  UsuarioRepository usuarioRepo,
                                  ProyectoRepository proyectoRepo,
                                  HorasTrabajadasMapper mapper) {
        this.horasRepo = horasRepo;
        this.usuarioRepo = usuarioRepo;
        this.proyectoRepo = proyectoRepo;
        this.mapper = mapper;
    }

    public List<HorasTrabajadasDTO> listarHoras() {
        return horasRepo.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<HorasTrabajadasDTO> obtenerHora(Long id) {
        return horasRepo.findById(id).map(mapper::toDTO);
    }

    public HorasTrabajadasDTO guardarHora(HorasTrabajadasDTO dto) {
        Usuario usuario = usuarioRepo.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Proyecto proyecto = proyectoRepo.findById(dto.getProyectoId())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        HorasTrabajadas entity = mapper.toEntity(dto, usuario, proyecto);
        return mapper.toDTO(horasRepo.save(entity));
    }

    public void eliminarHora(Long id) {
        horasRepo.deleteById(id);
    }
}