package com.capimonte.gestion_horas_api.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HorasTrabajadasDTO {
    private Long id;
    private Long usuarioId;
    private Long proyectoId;
    private LocalDate fecha;
    private int horas;
    private String descripcion;
}

