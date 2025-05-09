package com.kosmos.consultorio.infrastructure.adpter.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@IdClass(CitaId.class)
public class CitaEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_consultorio", referencedColumnName = "id")
    private ConsultorioEntity consultorio;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_doctor", referencedColumnName = "id")
    private DoctorEntity doctor;

    private LocalDateTime horaConsulta;

    private String nombrePaciente;

    public CitaEntity() {}

    public CitaEntity(ConsultorioEntity consultorio, DoctorEntity doctor, LocalDateTime horaConsulta, String nombrePaciente) {
        this.consultorio = consultorio;
        this.doctor = doctor;
        this.horaConsulta = horaConsulta;
        this.nombrePaciente = nombrePaciente;
    }

    public ConsultorioEntity getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(ConsultorioEntity consultorio) {
        this.consultorio = consultorio;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalDateTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
}