package com.kosmos.consultorio.infrastructure.adpter.persistence.repositories;

import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.ConsultorioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultorioRepository extends JpaRepository<ConsultorioEntity, Integer> {
}
