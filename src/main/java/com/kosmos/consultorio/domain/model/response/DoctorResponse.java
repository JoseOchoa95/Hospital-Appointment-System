package com.kosmos.consultorio.domain.model.response;

import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.DoctorEntity;

public record DoctorResponse(
        Integer id,
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String especialidad
) {

    public static DoctorResponse toResponse(DoctorEntity entity){
        return new DoctorResponse(
                entity.getId(),
                entity.getNombre(),
                entity.getApellidoPaterno(),
                entity.getApellidoMaterno(),
                entity.getEspecialidad()
        );
    }
}
