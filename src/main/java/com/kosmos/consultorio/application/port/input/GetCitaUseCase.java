package com.kosmos.consultorio.application.port.input;

import com.kosmos.consultorio.domain.model.response.CitaCompletaResponse;
import com.kosmos.consultorio.domain.model.response.CitaResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface GetCitaUseCase {

    List<CitaResponse> getCita(Integer idDoctor, Integer idConsultorio, LocalDate fecha, LocalTime hora, String nombrePaciente);
}
