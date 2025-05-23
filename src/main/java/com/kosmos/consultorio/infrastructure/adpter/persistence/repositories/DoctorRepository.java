package com.kosmos.consultorio.infrastructure.adpter.persistence.repositories;

import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
}
