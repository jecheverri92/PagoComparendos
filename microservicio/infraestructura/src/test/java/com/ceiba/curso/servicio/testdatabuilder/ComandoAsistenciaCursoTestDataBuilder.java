package com.ceiba.curso.servicio.testdatabuilder;

import com.ceiba.comparendo.comando.ComandoComparendo;
import com.ceiba.curso.comando.ComandoAsistenciaCruso;
import com.ceiba.curso.modelo.entidad.AsistenciaCurso;

import java.time.LocalDateTime;

public class ComandoAsistenciaCursoTestDataBuilder {

    private Long id;
    private String numeroComparendo;
    private String identificacionInfractor;
    private LocalDateTime fechaAsistencia;

    public ComandoAsistenciaCursoTestDataBuilder(){
        this.numeroComparendo = "0001";
        this.identificacionInfractor = "123456789";
        this.fechaAsistencia = LocalDateTime.now();
    }

    public ComandoAsistenciaCursoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComandoAsistenciaCursoTestDataBuilder conNumeroComparendo(String numeroComparendo){
        this.numeroComparendo = numeroComparendo;
        return this;
    }

    public ComandoAsistenciaCursoTestDataBuilder conIdentificacionInfractor(String identificacionInfractor){
        this.identificacionInfractor = identificacionInfractor;
        return this;
    }

    public ComandoAsistenciaCursoTestDataBuilder conFechaAsistencia(LocalDateTime fechaAsistencia){
        this.fechaAsistencia = fechaAsistencia;
        return this;
    }

    public ComandoAsistenciaCruso build(){return new ComandoAsistenciaCruso(id,numeroComparendo,identificacionInfractor,fechaAsistencia);}

    public static ComandoAsistenciaCursoTestDataBuilder unaAsistenciaCurso(){
        return new ComandoAsistenciaCursoTestDataBuilder();
    }
}
