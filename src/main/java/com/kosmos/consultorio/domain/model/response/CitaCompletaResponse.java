package com.kosmos.consultorio.domain.model.response;

public record CitaCompletaResponse(

        CitaResponse cita,
        ConsultorioResponse consultorio,
        DoctorResponse doctor
) {

    public static CitaCompletaResponse toResponse(CitaResponse cita, ConsultorioResponse consultorio, DoctorResponse doctor){
        return new CitaCompletaResponse(
                cita,
                consultorio,
                doctor
        );
    }
}
