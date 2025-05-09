package com.kosmos.consultorio.infrastructure.adpter.persistence.entity;

import java.io.Serializable;

public class CitaId implements Serializable {

    private Integer consultorio;
    private Integer doctor;

    public CitaId() {}

    public CitaId(Integer idConsultorio, Integer idDoctor) {
        this.consultorio = idConsultorio;
        this.doctor = idDoctor;
    }

    public Integer getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Integer consultorio) {
        this.consultorio = consultorio;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }
}
