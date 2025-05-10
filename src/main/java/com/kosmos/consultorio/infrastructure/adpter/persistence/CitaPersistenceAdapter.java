package com.kosmos.consultorio.infrastructure.adpter.persistence;

import com.kosmos.consultorio.application.port.output.CitaOutputPort;
import com.kosmos.consultorio.domain.error.exceptions.NotFoundException;
import com.kosmos.consultorio.domain.model.Cita;
import com.kosmos.consultorio.domain.model.request.CitaRequest;
import com.kosmos.consultorio.infrastructure.adpter.persistence.entity.CitaEntity;
import com.kosmos.consultorio.infrastructure.adpter.persistence.mapper.CitaMapper;
import com.kosmos.consultorio.infrastructure.adpter.persistence.repositories.CitaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Component
public class CitaPersistenceAdapter implements CitaOutputPort {

    private final CitaRepository citaRepository;
    private final CitaMapper citaMapper;

    public CitaPersistenceAdapter(CitaRepository citaRepository, CitaMapper citaMapper) {
        this.citaRepository = citaRepository;
        this.citaMapper = citaMapper;
    }

    @Override
    public Integer addCita(CitaRequest cita){
        return citaRepository.save(
                new CitaEntity(
                        cita.idConsultorio(),
                        cita.idDoctor(),
                        cita.fechaConsulta(),
                        cita.horaConsulta(),
                        cita.nombrePaciente()
                )
        ).getId();
    }

    @Override
    public void updateCita(Integer idCita, CitaRequest actualizacion){

        CitaEntity cita = citaRepository
                .findById(idCita)
                .orElseThrow(() -> new NotFoundException("Cita no encontrada"));

        cita.setIdConsultorio(actualizacion.idConsultorio());
        cita.setIdDoctor(actualizacion.idDoctor());
        cita.setNombrePaciente(actualizacion.nombrePaciente());
        cita.setHoraConsulta(actualizacion.horaConsulta());

        citaRepository.save(
                cita
        );
    }

    @Override
    public void deleteCita(Integer idCita){
        citaRepository.deleteById(idCita);
    }

    @Override
    public Boolean isConsultorioAvailable(Integer idConsultorio, LocalDate fecha, LocalTime horario){
        Optional<CitaEntity> cita = citaRepository.findByIdConsultorioAndFechaConsultaAndHoraConsulta(idConsultorio, fecha, horario);
        return cita.isEmpty();
    }

    @Override
    public Boolean isDoctorAvailable(Integer idDoctor, LocalDate fecha, LocalTime horario){
        Optional<CitaEntity> cita = citaRepository.findByIdDoctorAndFechaConsultaAndHoraConsulta(idDoctor, fecha, horario);
        return cita.isEmpty();
    }

    @Override
    public Cita findLastCitaPaciente(String nombrePaciente){
        return citaMapper.toDomain(
               citaRepository.findFirstByNombrePacienteOrderByFechaConsultaDescHoraConsultaDesc(nombrePaciente)
                       .orElse(null)
        );
    }

    @Override
    public Cita findSecondLastCitaPaciente(String nombrePaciente) {

        Pageable limit = PageRequest.of(0, 2);
        List<CitaEntity> citas = citaRepository.findByNombrePacienteOrderByFechaConsultaDescHoraConsultaDesc(
                nombrePaciente,
                limit
        );

        if (citas.size() >= 2) {
            return citaMapper.toDomain(citas.get(1));
        }

        return null;
    }
}
