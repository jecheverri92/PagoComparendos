package com.ceiba.curso.servicio.testdatabuilder;

import com.ceiba.comparendo.servicio.testdatabuilder.ComparendoTestDataBuilder;
import com.ceiba.curso.modelo.entidad.AsistenciaCurso;

import java.time.LocalDateTime;

public class AsistenciaCursoTestDataBuilder {

    private Long id;
    private String numeroComparendo;
    private String identificacionInfractor;
    private LocalDateTime fechaAsistencia;

    public AsistenciaCursoTestDataBuilder(){
        numeroComparendo = "0001";
        identificacionInfractor= "123456789";
        fechaAsistencia = LocalDateTime.now();
    }

    public AsistenciaCursoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public AsistenciaCursoTestDataBuilder conNumeroComparendo(String numeroComparendo){
        this.numeroComparendo = numeroComparendo;
        return this;
    }

    public AsistenciaCursoTestDataBuilder conIdenrificacionInfractor(String identificacionInfractor){
        this.identificacionInfractor = identificacionInfractor;
        return this;
    }

    public AsistenciaCursoTestDataBuilder conFechaAsistencia(LocalDateTime fechaAsistencia){
        this.fechaAsistencia = fechaAsistencia;
        return this;
    }

    public AsistenciaCurso build(){ return  new AsistenciaCurso(id,numeroComparendo,identificacionInfractor,fechaAsistencia);}

    public static AsistenciaCursoTestDataBuilder unaAsistenciaCurso(){
        return  new AsistenciaCursoTestDataBuilder();
    }
}
