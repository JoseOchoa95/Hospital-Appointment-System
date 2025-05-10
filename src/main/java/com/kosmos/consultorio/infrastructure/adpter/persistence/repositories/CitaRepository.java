package com.kosmos.consultorio.infrastructure.adpter.persistence.repositories;

import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.CitaEntity;
import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.DoctorEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<CitaEntity, Integer> {

    Optional<CitaEntity> findByIdConsultorioAndFechaConsultaAndHoraConsulta(
            Integer idConsultorio,
            LocalDate fechaConsulta,
            LocalTime horaConsulta
    );

    Optional<CitaEntity> findByIdDoctorAndFechaConsultaAndHoraConsulta(
            Integer idDoctor,
            LocalDate fechaConsulta,
            LocalTime horaConsulta
    );

    Optional<CitaEntity> findFirstByNombrePacienteOrderByFechaConsultaDescHoraConsultaDesc(String nombrePaciente);

    List<CitaEntity> findByNombrePacienteOrderByFechaConsultaDescHoraConsultaDesc(
            String nombrePaciente,
            Pageable pageable
    );
}
