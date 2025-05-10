package com.kosmos.consultorio.application.port.input;

import com.kosmos.consultorio.domain.model.response.CitaCompletaResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface GetCitaUseCase {

    List<CitaCompletaResponse> getCita(Integer idDoctor, Integer idConsultorio, LocalDate fecha, LocalTime hora);
}
