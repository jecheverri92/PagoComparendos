package com.ceiba.curso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.comparendo.puerto.repositorio.RepositorioComparendo;
import com.ceiba.comparendo.servicio.testdatabuilder.ComparendoTestDataBuilder;
import com.ceiba.curso.modelo.entidad.AsistenciaCurso;
import com.ceiba.curso.puerto.repositorio.RepositorioAsistenciaCurso;
import com.ceiba.curso.servicio.testdatabuilder.AsistenciaCursoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearAsistenciaCurso {

    @Test
    @DisplayName("Deberia crear la AsistenciaCurso de manera correcta con descuento")
    void deberiaCrearLaAsistenciaCursoDeManeraCorrectaConDescuento(){
        //arrange
        LocalDateTime fechaAsistenciaCurso = LocalDateTime.now();
        LocalDateTime fechaComparendo = fechaAsistenciaCurso.minusDays(15);
        AsistenciaCurso asistenciaCurso = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().conFechaAsistencia(fechaAsistenciaCurso).build();
        Comparendo comparendo = ComparendoTestDataBuilder.unComparendo().conFechaComparendo(fechaComparendo).conValorComparendo(BigDecimal.valueOf(100)).build();

        RepositorioComparendo repositorioComparendo = Mockito.mock(RepositorioComparendo.class);
        RepositorioAsistenciaCurso repositorioAsistenciaCurso = Mockito.mock(RepositorioAsistenciaCurso.class);

        Mockito.when(repositorioComparendo.obtenerComparendoPorNumeroComparendo(Mockito.anyString())).thenReturn(comparendo);
        Mockito.when(repositorioAsistenciaCurso.existePorNumeroComparendo(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioAsistenciaCurso.numeroAsistenciasPorFecha(Mockito.any())).thenReturn(1);
        Mockito.when(repositorioAsistenciaCurso.crear(asistenciaCurso)).thenReturn(1L);

        ServicioRegistrarAsistenciaCurso servicioRegistrarAsistenciaCurso = new ServicioRegistrarAsistenciaCurso(repositorioComparendo,repositorioAsistenciaCurso);

        //act
        Long idAsistenciaCurso = servicioRegistrarAsistenciaCurso.ejecutar(asistenciaCurso);
        //asert
        assertEquals(1L,idAsistenciaCurso);
        assertEquals(BigDecimal.valueOf(75).setScale(2),comparendo.getValorComparendo().setScale(2));
        Mockito.verify(repositorioAsistenciaCurso,Mockito.times(1)).crear(asistenciaCurso);
    }

    @Test
    @DisplayName("Deberia crear la AsistenciaCurso de manera correcta con mejor descuento")
    void deberiaCrearLaAsistenciaCursoDeManeraCorrectaConMejorDescuento(){
        //arrange
        LocalDateTime fechaAsistenciaCurso = LocalDateTime.now();
        LocalDateTime fechaComparendo = fechaAsistenciaCurso.minusDays(5);
        AsistenciaCurso asistenciaCurso = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().conFechaAsistencia(fechaAsistenciaCurso).build();
        Comparendo comparendo = ComparendoTestDataBuilder.unComparendo().conFechaComparendo(fechaComparendo).conValorComparendo(BigDecimal.valueOf(100)).build();

        RepositorioComparendo repositorioComparendo = Mockito.mock(RepositorioComparendo.class);
        RepositorioAsistenciaCurso repositorioAsistenciaCurso = Mockito.mock(RepositorioAsistenciaCurso.class);

        Mockito.when(repositorioComparendo.obtenerComparendoPorNumeroComparendo(Mockito.anyString())).thenReturn(comparendo);
        Mockito.when(repositorioAsistenciaCurso.existePorNumeroComparendo(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioAsistenciaCurso.numeroAsistenciasPorFecha(Mockito.any())).thenReturn(1);
        Mockito.when(repositorioAsistenciaCurso.crear(asistenciaCurso)).thenReturn(1L);

        ServicioRegistrarAsistenciaCurso servicioRegistrarAsistenciaCurso = new ServicioRegistrarAsistenciaCurso(repositorioComparendo,repositorioAsistenciaCurso);

        //act
        Long idAsistenciaCurso = servicioRegistrarAsistenciaCurso.ejecutar(asistenciaCurso);
        //asert
        assertEquals(1L,idAsistenciaCurso);
        assertEquals(BigDecimal.valueOf(50).setScale(2),comparendo.getValorComparendo().setScale(2));
        Mockito.verify(repositorioAsistenciaCurso,Mockito.times(1)).crear(asistenciaCurso);
    }

    @Test
    @DisplayName("Deberia lanzar una Excepcion cuando el comparendo no exista")
    void deberiaLanzarUnaExcepcionCuandoElComparendoNoExista(){
        //arrange
        AsistenciaCurso asistenciaCurso = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().build();
        RepositorioComparendo repositorioComparendo = Mockito.mock(RepositorioComparendo.class);
        RepositorioAsistenciaCurso repositorioAsistenciaCurso = Mockito.mock(RepositorioAsistenciaCurso.class);

        Mockito.when(repositorioComparendo.obtenerComparendoPorNumeroComparendo(Mockito.anyString())).thenReturn(null);
        ServicioRegistrarAsistenciaCurso servicioRegistrarAsistenciaCurso = new ServicioRegistrarAsistenciaCurso(repositorioComparendo,repositorioAsistenciaCurso);

        //act- assert
        BasePrueba.assertThrows(() -> servicioRegistrarAsistenciaCurso.ejecutar(asistenciaCurso), ExcepcionValorInvalido.class,"El comparendo no existe");

    }


    @Test
    @DisplayName("Deberia lanzar una excepcion dias habiles para asistencia al curso superados")
    void deberiaLanzarUnaExcepcionDiasHabilesParaAsistenciaCursoSuperados(){
        //arrange
        LocalDateTime fechaAsistenciaCurso = LocalDateTime.now();
        LocalDateTime fechaComparendo = fechaAsistenciaCurso.minusDays(100);
        AsistenciaCurso asistenciaCurso = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().conFechaAsistencia(fechaAsistenciaCurso).build();
        Comparendo comparendo = ComparendoTestDataBuilder.unComparendo().conFechaComparendo(fechaComparendo).conValorComparendo(BigDecimal.valueOf(100)).build();

        RepositorioComparendo repositorioComparendo = Mockito.mock(RepositorioComparendo.class);
        RepositorioAsistenciaCurso repositorioAsistenciaCurso = Mockito.mock(RepositorioAsistenciaCurso.class);

        Mockito.when(repositorioComparendo.obtenerComparendoPorNumeroComparendo(Mockito.anyString())).thenReturn(comparendo);
        Mockito.when(repositorioAsistenciaCurso.existePorNumeroComparendo(Mockito.anyString())).thenReturn(false);

        ServicioRegistrarAsistenciaCurso servicioRegistrarAsistenciaCurso = new ServicioRegistrarAsistenciaCurso(repositorioComparendo,repositorioAsistenciaCurso);

        //act- assert
        BasePrueba.assertThrows(() -> servicioRegistrarAsistenciaCurso.ejecutar(asistenciaCurso), ExcepcionValorInvalido.class,"Ha excedido la fecha limite para la asistencia al curso");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion el infractor ya ha asistido al maximo de cursos permitidos al dia")
    void deberiaLanzarUnaExcepcionAsistenciaCursosAlDiaSuperados(){
        //arrange
        AsistenciaCurso asistenciaCurso = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().build();
        Comparendo comparendo = ComparendoTestDataBuilder.unComparendo().build();

        RepositorioComparendo repositorioComparendo = Mockito.mock(RepositorioComparendo.class);
        RepositorioAsistenciaCurso repositorioAsistenciaCurso = Mockito.mock(RepositorioAsistenciaCurso.class);

        Mockito.when(repositorioComparendo.obtenerComparendoPorNumeroComparendo(Mockito.anyString())).thenReturn(comparendo);
        Mockito.when(repositorioAsistenciaCurso.existePorNumeroComparendo(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioAsistenciaCurso.numeroAsistenciasPorFecha(asistenciaCurso)).thenReturn(4);

        ServicioRegistrarAsistenciaCurso servicioRegistrarAsistenciaCurso = new ServicioRegistrarAsistenciaCurso(repositorioComparendo,repositorioAsistenciaCurso);

        //act- assert
        BasePrueba.assertThrows(() -> servicioRegistrarAsistenciaCurso.ejecutar(asistenciaCurso), ExcepcionValorInvalido.class,"El infractor ha superado el maximo de asistencias por fecha");
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion el infractor ya asistio al curso por el comparendo asociado")
    void deberiaLanzarUnaExcepcionAsistenciaCursosElInfractorYaAsisitoAlCurso(){
        //arrange
        AsistenciaCurso asistenciaCurso = AsistenciaCursoTestDataBuilder.unaAsistenciaCurso().build();
        Comparendo comparendo = ComparendoTestDataBuilder.unComparendo().build();

        RepositorioComparendo repositorioComparendo = Mockito.mock(RepositorioComparendo.class);
        RepositorioAsistenciaCurso repositorioAsistenciaCurso = Mockito.mock(RepositorioAsistenciaCurso.class);

        Mockito.when(repositorioComparendo.obtenerComparendoPorNumeroComparendo(Mockito.anyString())).thenReturn(comparendo);
        Mockito.when(repositorioAsistenciaCurso.existePorNumeroComparendo(Mockito.anyString())).thenReturn(true);

        ServicioRegistrarAsistenciaCurso servicioRegistrarAsistenciaCurso = new ServicioRegistrarAsistenciaCurso(repositorioComparendo,repositorioAsistenciaCurso);

        //act- assert
        BasePrueba.assertThrows(() -> servicioRegistrarAsistenciaCurso.ejecutar(asistenciaCurso), ExcepcionValorInvalido.class,"El infractor ya asistio al curso");
    }

}
