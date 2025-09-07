package com.capimonte.gestion_horas_api.service;

import com.capimonte.gestion_horas_api.model.BackupPlan;
import com.capimonte.gestion_horas_api.repository.BackupPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BackupPlanService {

    private final BackupPlanRepository backupPlanRepository;

    public BackupPlanService(BackupPlanRepository backupPlanRepository) {
        this.backupPlanRepository = backupPlanRepository;
    }

    public List<BackupPlan> listarBackups() {
        return backupPlanRepository.findAll();
    }

    public Optional<BackupPlan> obtenerBackup(Long id) {
        return backupPlanRepository.findById(id);
    }

    public BackupPlan guardarBackup(BackupPlan backupPlan) {
        return backupPlanRepository.save(backupPlan);
    }

    public void eliminarBackup(Long id) {
        backupPlanRepository.deleteById(id);
    }
}

