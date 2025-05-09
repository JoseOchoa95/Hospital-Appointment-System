package com.kosmos.consultorio.infrastructure.adpter.persistence.repositories;

import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.CitaEntity;
import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.CitaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<CitaEntity, CitaId> {
}
