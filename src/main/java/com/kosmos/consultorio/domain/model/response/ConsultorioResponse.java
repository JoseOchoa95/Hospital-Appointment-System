package com.kosmos.consultorio.domain.model.response;

import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.ConsultorioEntity;

public record ConsultorioResponse(
        Integer id,
        Integer numeroConsultorio,
        Integer piso
) {

    public static ConsultorioResponse toResponse(ConsultorioEntity entity){
        return new ConsultorioResponse(
                entity.getId(),
                entity.getNumeroConsultorio(),
                entity.getPiso()
        );
    }
}
