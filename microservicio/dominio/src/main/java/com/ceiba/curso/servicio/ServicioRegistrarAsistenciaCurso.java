package com.ceiba.curso.servicio;

import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.comparendo.puerto.repositorio.RepositorioComparendo;
import com.ceiba.curso.modelo.entidad.AsistenciaCurso;
import com.ceiba.curso.puerto.repositorio.RepositorioAsistenciaCurso;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class ServicioRegistrarAsistenciaCurso {

    private static final Integer NUMERO_DE_DIAS_HABILES_MEJOR_DESCUENTO = 5;
    private static final Integer NUMERO_DE_DIAS_HABILES_DESCUENTO = 15;

    private static final Integer MAXIMA_ASISTENCIA_POR_DIA = 3;
    private static final Integer MAXIMOS_DIAS_HABILES_DESDE_COMPARENDO = 15;

    private static final String EL_INFRACTOR_YA_ASISTIO_AL_CURSO = "El infractor ya asistio al curso";
    private static final String SE_HA_EXEDIDO_EL_TIEMPO_LIMITE_PARA_ASISTIR_AL_CURSO = "Ha excedido la fecha limite para la asistencia al curso";
    private static final String SE_EXEDE_EL_NUMERO_DE_ASISTENCIAS_MAXIMAS = "El infractor ha superado el maximo de asistencias por fecha";
    private static final String EL_COMPARENDO_NO_EXISTE = "El comparendo no existe";

    private final RepositorioComparendo repositorioComparendo;
    private final RepositorioAsistenciaCurso repositorioAsistenciaCurso;

    public ServicioRegistrarAsistenciaCurso(RepositorioComparendo repositorioComparendo, RepositorioAsistenciaCurso repositorioAsistenciaCurso) {
        this.repositorioComparendo = repositorioComparendo;
        this.repositorioAsistenciaCurso = repositorioAsistenciaCurso;
    }

    public Long ejecutar(AsistenciaCurso asistenciaCurso){
        Comparendo comparendo = validaExisteComparendo(asistenciaCurso);
        validaExistenciaPrevia(asistenciaCurso);
        Integer diasHabilesDesdeComparendo = validaFechaAsistencia(comparendo,asistenciaCurso);
        validaMaximasAsistenciasPorFecha(asistenciaCurso);
        //Se acttaliza valor comparendos
        aplicarDescuento(comparendo,diasHabilesDesdeComparendo);
        repositorioComparendo.actualizar(comparendo);
        return repositorioAsistenciaCurso.crear(asistenciaCurso);
    }

    private Comparendo validaExisteComparendo(AsistenciaCurso asistenciaCurso){
        Comparendo comparendo = this.repositorioComparendo.obtenerComparendoPorNumeroComparendo(asistenciaCurso.getNumeroComparendo());
        if(comparendo == null){
            throw new ExcepcionValorInvalido(EL_COMPARENDO_NO_EXISTE);
        }
        return comparendo;
    }

    private void validaExistenciaPrevia(AsistenciaCurso asistenciaCurso){
        boolean existe = this.repositorioAsistenciaCurso.existePorNumeroComparendo(asistenciaCurso.getNumeroComparendo());
        if(existe){
            throw new ExcepcionDuplicidad(EL_INFRACTOR_YA_ASISTIO_AL_CURSO);
        }
    }

    private void validaMaximasAsistenciasPorFecha(AsistenciaCurso asistenciaCurso){
        Integer numeroAsistencia = repositorioAsistenciaCurso.numeroAsistenciasPorFecha(asistenciaCurso);
        if(numeroAsistencia>=MAXIMA_ASISTENCIA_POR_DIA){
            throw new ExcepcionValorInvalido(SE_EXEDE_EL_NUMERO_DE_ASISTENCIAS_MAXIMAS);
        }
    }

    private Integer validaFechaAsistencia(Comparendo comparendo, AsistenciaCurso asistenciaCurso){

        int cantidadDiasHabiles = 0;
        LocalDateTime fechaComparendo = comparendo.getFechaComparendo();
        while(fechaComparendo.isBefore(asistenciaCurso.getFechaAsistencia())){
            fechaComparendo = fechaComparendo.plusDays(1);
            if(!(fechaComparendo.getDayOfWeek() == DayOfWeek.SATURDAY || fechaComparendo.getDayOfWeek() == DayOfWeek.SUNDAY)){
                ++cantidadDiasHabiles;
            }
            if(cantidadDiasHabiles>MAXIMOS_DIAS_HABILES_DESDE_COMPARENDO){
                throw new ExcepcionValorInvalido(SE_HA_EXEDIDO_EL_TIEMPO_LIMITE_PARA_ASISTIR_AL_CURSO);
            }
        }

        return cantidadDiasHabiles;
    }

    private void aplicarDescuento(Comparendo comparendo, Integer diasHabilesDesdeComparendo){
        if(diasHabilesDesdeComparendo<=NUMERO_DE_DIAS_HABILES_MEJOR_DESCUENTO){
            comparendo.setValorComparendo(comparendo.getValorComparendo().multiply(BigDecimal.valueOf(0.5)));
        }else if(diasHabilesDesdeComparendo<=NUMERO_DE_DIAS_HABILES_DESCUENTO){
            comparendo.setValorComparendo(comparendo.getValorComparendo().multiply(BigDecimal.valueOf(0.75)));
        }
    };



}
