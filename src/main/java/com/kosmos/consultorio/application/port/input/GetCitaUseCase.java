package com.kosmos.consultorio.application.port.input;

import com.kosmos.consultorio.domain.model.response.CitaCompletaResponse;

import java.time.LocalDate;
import java.util.List;

public interface GetCitaUseCase {

    List<CitaCompletaResponse> getCita(LocalDate fecha, Integer numeroConsultorio, String nombreDoctor);
}
