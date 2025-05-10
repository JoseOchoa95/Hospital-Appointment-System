package com.kosmos.consultorio.domain.service;

import com.kosmos.consultorio.application.port.input.CreateCitaUseCase;
import com.kosmos.consultorio.application.port.input.DeleteCitaUseCase;
import com.kosmos.consultorio.application.port.input.GetCitaUseCase;
import com.kosmos.consultorio.application.port.input.UpdateCitaUseCase;
import com.kosmos.consultorio.application.port.output.CitaOutputPort;
import com.kosmos.consultorio.domain.error.exceptions.PreconditionFailedException;
import com.kosmos.consultorio.domain.model.Cita;
import com.kosmos.consultorio.domain.model.request.CitaRequest;
import com.kosmos.consultorio.domain.model.response.CitaCompletaResponse;
import com.kosmos.consultorio.domain.model.response.CitaResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CitaService implements
        CreateCitaUseCase,
        UpdateCitaUseCase,
        DeleteCitaUseCase,
        GetCitaUseCase
{
    private final CitaOutputPort citaOutputPort;

    public CitaService(CitaOutputPort citaOutputPort) {
        this.citaOutputPort = citaOutputPort;
    }

    @Override
    public Integer createCita(CitaRequest cita) {

        checkCitaSchedulable(null, cita);
        return citaOutputPort.addCita(cita);
    }

    @Override
    public void updateCita(Integer idCita, CitaRequest cita){

        checkCitaSchedulable(idCita, cita);
        citaOutputPort.updateCita(idCita, cita);
    }

    @Override
    public void deleteCita(Integer idCita){
        citaOutputPort.deleteCita(idCita);
    }

    @Override
    public List<CitaCompletaResponse> getCita(Integer idDoctor, Integer idConsultorio, LocalDate fecha, LocalTime hora){

        List<CitaResponse> list = citaOutputPort.findCitaByFechaAndConsultorioAndDoctor(idDoctor, idConsultorio, fecha, hora);

        return new ArrayList<>();
    }

    private void checkCitaSchedulable(Integer idCita, CitaRequest cita){

        if(!citaOutputPort.isConsultorioAvailable(cita.idConsultorio(), cita.fechaConsulta(), cita.horaConsulta())){
            throw new PreconditionFailedException("El consultorio ya se encuentra reservado.");
        }

        if(!citaOutputPort.isDoctorAvailable(cita.idConsultorio(), cita.fechaConsulta(), cita.horaConsulta())){
            throw new PreconditionFailedException("El doctor ya cuenta con una cita en ese horario.");
        }

        if(!isPacienteSchedulable(idCita, cita.nombrePaciente(), cita.fechaConsulta(), cita.horaConsulta())){
            throw new PreconditionFailedException("El paciente no puede ser agendado, debe esperar para poder re-agender.");
        }
    }

    private Boolean isPacienteSchedulable(Integer idCita, String nombrePaciente, LocalDate fechaConsulta, LocalTime horaConsulta){

        Cita lastCita;
        if(idCita == null){
            lastCita = citaOutputPort.findLastCitaPaciente(nombrePaciente);
        }else{
            lastCita = citaOutputPort.findSecondLastCitaPaciente(nombrePaciente);

            if(lastCita == null){
                return true;
            }
        }

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
