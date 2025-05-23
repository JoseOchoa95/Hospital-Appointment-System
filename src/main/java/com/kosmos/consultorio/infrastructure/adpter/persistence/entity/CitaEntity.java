package com.kosmos.consultorio.infrastructure.adpter.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class CitaEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer idConsultorio;

    private Integer idDoctor;

    private LocalDate fechaConsulta;

    private LocalTime horaConsulta;

    private String nombrePaciente;

    public CitaEntity() {}

    public CitaEntity(Integer idConsultorio, Integer idDoctor, LocalDate fechaConsulta, LocalTime horaConsulta, String nombrePaciente) {
        this.idConsultorio = idConsultorio;
        this.idDoctor = idDoctor;
        this.fechaConsulta = fechaConsulta;
        this.horaConsulta = horaConsulta;
        this.nombrePaciente = nombrePaciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public LocalTime getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(LocalTime horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }
}