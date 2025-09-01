package com.capimonte.gestion_horas_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String rol;

    @OneToMany(mappedBy = "usuario")
    private List<HorasTrabajadas> horasTrabajadas;

    @OneToMany(mappedBy = "usuario")
    private List<SolicitudPermiso> solicitudesPermiso;

    @OneToMany(mappedBy = "titular")
    private List<BackupPlan> planesTitular;

    @OneToMany(mappedBy = "suplente")
    private List<BackupPlan> planesSuplente;
}
