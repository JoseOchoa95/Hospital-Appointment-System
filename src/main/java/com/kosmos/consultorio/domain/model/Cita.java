package com.kosmos.consultorio.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {

    private Integer id;
    private Integer idConsultorio;
    private Integer idDoctor;
    private LocalDate fechaConsulta;
    private LocalTime horaConsulta;
    private String nombrePaciente;

    public Cita() {
    }

    public Cita(Integer id, Integer idConsultorio, Integer idDoctor, LocalDate fechaConsulta, LocalTime horaConsulta, String nombrePaciente) {
        this.id = id;
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
