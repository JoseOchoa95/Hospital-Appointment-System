package com.kosmos.consultorio.application.port.output;

import com.kosmos.consultorio.domain.model.Cita;
import com.kosmos.consultorio.domain.model.request.CitaRequest;
import com.kosmos.consultorio.domain.model.response.CitaResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CitaOutputPort {

    Integer addCita(CitaRequest cita);

    void updateCita(Integer idCita, CitaRequest actualizacion);

    void deleteCita(Integer idCita);

    Boolean isConsultorioAvailable(Integer idConsultorio, LocalDate fecha, LocalTime horario);

    Boolean isDoctorAvailable(Integer idDoctor, LocalDate fecha, LocalTime horario);

    Cita findLastCitaPaciente(String nombrePaciente);

    Cita findSecondLastCitaPaciente(String nombrePaciente);

    List<CitaResponse> findCitaByFechaAndConsultorioAndDoctor(Integer idDoctor, Integer idConsultorio, LocalDate fecha, LocalTime hora, String nombrePaciente);
}
