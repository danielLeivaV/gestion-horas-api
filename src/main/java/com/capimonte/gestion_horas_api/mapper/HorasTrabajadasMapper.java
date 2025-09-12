package com.capimonte.gestion_horas_api.mapper;

import com.capimonte.gestion_horas_api.dto.HorasTrabajadasDTO;
import com.capimonte.gestion_horas_api.model.HorasTrabajadas;
import com.capimonte.gestion_horas_api.model.Usuario;
import com.capimonte.gestion_horas_api.model.Proyecto;
import org.springframework.stereotype.Component;

@Component
public class HorasTrabajadasMapper {

    public HorasTrabajadas toEntity(HorasTrabajadasDTO dto, Usuario usuario, Proyecto proyecto) {
        return HorasTrabajadas.builder()
                .id(dto.getId())
                .usuario(usuario)
                .proyecto(proyecto)
                .fecha(dto.getFecha())
                .horas(dto.getHoras())
                .descripcion(dto.getDescripcion())
                .build();
    }

    public HorasTrabajadasDTO toDTO(HorasTrabajadas entity) {
        return HorasTrabajadasDTO.builder()
                .id(entity.getId())
                .usuarioId(entity.getUsuario().getId())
                .proyectoId(entity.getProyecto().getId())
                .fecha(entity.getFecha())
                .horas(entity.getHoras())
                .descripcion(entity.getDescripcion())
                .build();
    }
}
