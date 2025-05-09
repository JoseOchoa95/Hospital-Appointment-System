package com.kosmos.consultorio.domain.model.request;

import java.time.LocalDate;
import java.time.LocalTime;

public record CitaRequest(

        Integer idConsultorio,

        Integer idDoctor,

        LocalDate fechaConsulta,

        LocalTime horaConsulta,

        String nombrePaciente
) {
}
