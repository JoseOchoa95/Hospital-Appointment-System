package com.kosmos.consultorio.infrastructure.adpter.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ConsultorioEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer numeroConsultorio;

    private Integer piso;

    @OneToMany(mappedBy = "consultorio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CitaEntity> citas = new ArrayList<>();

    public ConsultorioEntity() {
    }

    public ConsultorioEntity(Integer numeroConsultorio, Integer piso) {
        this.numeroConsultorio = numeroConsultorio;
        this.piso = piso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(Integer numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public List<CitaEntity> getCitas() {
        return citas;
    }

    public void setCitas(List<CitaEntity> citas) {
        this.citas = citas;
    }
}
