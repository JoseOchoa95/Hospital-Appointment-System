package com.kosmos.consultorio.infrastructure.adpter.persistence.mapper;

import com.kosmos.consultorio.domain.model.Cita;
import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.CitaEntity;
import org.springframework.stereotype.Component;

@Component
public class CitaMapper {

    public Cita toDomain(CitaEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Cita(
                entity.getId(),
                entity.getIdConsultorio(),
                entity.getIdDoctor(),
                entity.getFechaConsulta(),
                entity.getHoraConsulta(),
                entity.getNombrePaciente()
        );
    }
}
