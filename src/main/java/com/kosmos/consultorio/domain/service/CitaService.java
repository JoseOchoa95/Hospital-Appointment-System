package com.kosmos.consultorio.domain.service;

import com.kosmos.consultorio.application.port.input.CreateCitaUseCase;
import com.kosmos.consultorio.application.port.input.UpdateCitaUseCase;
import com.kosmos.consultorio.application.port.output.CitaOutputPort;
import com.kosmos.consultorio.domain.error.exceptions.PreconditionFailedException;
import com.kosmos.consultorio.domain.model.Cita;
import com.kosmos.consultorio.domain.model.request.CitaRequest;
import com.kosmos.consultorio.domain.model.response.CitaCompletaResponse;
import com.kosmos.consultorio.domain.model.response.CitaResponse;
import org.springframework.stereotype.Service;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class CitaService implements
        CreateCitaUseCase,
        UpdateCitaUseCase
{
    private final CitaOutputPort citaOutputPort;

    public CitaService(CitaOutputPort citaOutputPort) {
        this.citaOutputPort = citaOutputPort;
    }

    @Override
    public Integer createCita(CitaRequest cita) {

        checkCitaSchedulable(cita);
        return citaOutputPort.addCita(cita);
    }

    @Override
    public void updateCita(Integer idCita, CitaRequest cita){

        checkCitaSchedulable(cita);
        citaOutputPort.updateCita(idCita, cita);
    }

    @Override
    public List<CitaCompletaResponse> getCita(LocalDate fecha, Integer numeroConsultorio, String nombreDoctor){
    }

    private void checkCitaSchedulable(CitaRequest cita){

        if(!citaOutputPort.isConsultorioAvailable(cita.idConsultorio(), cita.fechaConsulta(), cita.horaConsulta())){
            throw new PreconditionFailedException("El consultorio ya se encuentra reservado.");
        }

        if(!citaOutputPort.isDoctorAvailable(cita.idConsultorio(), cita.fechaConsulta(), cita.horaConsulta())){
            throw new PreconditionFailedException("El doctor ya cuenta con una cita en ese horario.");
        }

        if(!isPacienteSchedulable(cita.nombrePaciente(), cita.fechaConsulta(), cita.horaConsulta())){
            throw new PreconditionFailedException("El paciente no puede ser agendado, debe esperar para poder re-agender.");
        }
    }

    private Boolean isPacienteSchedulable(String nombrePaciente, LocalDate fechaConsulta, LocalTime horaConsulta){

        Cita lastCita = citaOutputPort.findLastCitaPaciente(nombrePaciente);

        if(lastCita != null &&
           lastCita.getFechaConsulta().equals(fechaConsulta) &&
           (
                   horaConsulta.isBefore(lastCita.getHoraConsulta().plusHours(2)) ||
                   horaConsulta.equals(lastCita.getHoraConsulta())
           )
        ){

            return false;
        }

        return true;
    }
}
