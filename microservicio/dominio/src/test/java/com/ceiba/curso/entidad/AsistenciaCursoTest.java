package com.ceiba.curso.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.curso.modelo.entidad.AsistenciaCurso;
import com.ceiba.curso.servicio.testdatabuilder.AsistenciaCursoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsistenciaCursoTest {

    @Test
    @DisplayName("Deberia creal la asistencia correctamente")
    void deberiaCrearLaAsostenciaCursoCorrectamente(){
        //arrange
        LocalDateTime fechaAsistencia = LocalDateTime.now();
        //act
        AsistenciaCurso asistenciaCurso = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().conFechaAsistencia(fechaAsistencia).conId(1L).build();
        //assert
        assertEquals(1L, asistenciaCurso.getId());
        assertEquals("0001", asistenciaCurso.getNumeroComparendo());
        assertEquals("123456789", asistenciaCurso.getIdentificacionInfractor());
        assertEquals(fechaAsistencia, asistenciaCurso.getFechaAsistencia());
    }

    @Test
    @DisplayName("Deberia fallar sin numeroComparendo")
    void deberiaFallarSinNumeroComparendo(){
        //Arrange
        AsistenciaCursoTestDataBuilder asistenciaCursoTestDataBuilder = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().conNumeroComparendo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()-> {
            asistenciaCursoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "El numeroComparendo es obligatorio");
    }


    @Test
    @DisplayName("Deberia fallar sin identificacionInfractor")
    void deberiaFallarSinIdentificacionInfractor(){
        //Arrange
        AsistenciaCursoTestDataBuilder asistenciaCursoTestDataBuilder = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().conIdenrificacionInfractor(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()-> {
            asistenciaCursoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "La identificacionInfractor es obligatoria");
    }

    @Test
    @DisplayName("Deberia fallar sin fechaAsistencia")
    void deberiaFallarSinFechaAsistencia(){
        //Arrange
        AsistenciaCursoTestDataBuilder asistenciaCursoTestDataBuilder = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().conFechaAsistencia(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()-> {
            asistenciaCursoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "La fechaAsistencia es obligatoria");
    }

}
