package com.capimonte.gestion_horas_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "backup_planes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BackupPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "titular_id", nullable = false)
    private Usuario titular;

    @ManyToOne
    @JoinColumn(name = "suplente_id", nullable = false)
    private Usuario suplente;
}

