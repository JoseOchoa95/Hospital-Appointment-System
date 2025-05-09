package com.kosmos.consultorio.domain.model.response;

import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.CitaEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public record CitaResponse(
        Integer id,
        LocalDate fechaConsulta,
        LocalTime horaConsulta,
        String nombrePaciente
) {

    public static CitaResponse toResponse(CitaEntity entity){
        return new CitaResponse(
                entity.getId(),
                entity.getFechaConsulta(),
                entity.getHoraConsulta(),
                entity.getNombrePaciente()
        );
    }
}
