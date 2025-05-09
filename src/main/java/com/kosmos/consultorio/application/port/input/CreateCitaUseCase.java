package com.kosmos.consultorio.application.port.input;

import com.kosmos.consultorio.domain.model.request.CitaRequest;

public interface CreateCitaUseCase {

    Integer createCita(CitaRequest cita);
}
