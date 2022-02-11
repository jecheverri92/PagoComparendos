package com.ceiba.curso.servicio;

import com.ceiba.comparendo.puerto.repositorio.RepositorioComparendo;
import com.ceiba.curso.modelo.entidad.AsistenciaCurso;
import com.ceiba.curso.puerto.repositorio.RepositorioAsistenciaCurso;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioRegistrarAsistenciaCurso {

    private static final Integer MAXIMA_ASISTENCIA_POR_DIA = 3;
    private static final Integer MAXIMOS_DIAS_HABILES_DESDE_COMPARENDO = 15;

    private static final String EL_INFRACTOR_YA_ASISTIO_AL_CURSO = "El infractor ya asistio al curso";
    private static final String SE_HA_EXEDIDO_EL_TIEMPO_LIMITE_PARA_ASISTIR_AL_CURSO = "Ha excedido la fecha limite para la asistencia al curso";
    private static final String SE_EXEDE_EL_NUMERO_DE_ASISTENCIAS_MAXIMAS = "El infractor ha superado el maximo de asistencias por fecha";

    private final RepositorioComparendo repositorioComparendo;
    private final RepositorioAsistenciaCurso repositorioAsistenciaCurso;

    public ServicioRegistrarAsistenciaCurso(RepositorioComparendo repositorioComparendo, RepositorioAsistenciaCurso repositorioAsistenciaCurso) {
        this.repositorioComparendo = repositorioComparendo;
        this.repositorioAsistenciaCurso = repositorioAsistenciaCurso;
    }

    public Long ejecutar(AsistenciaCurso asistenciaCurso){
        validaExistenciaPrevia(asistenciaCurso);
        validaFechaAsistencia(asistenciaCurso);
        validaMaximasAsistenciasPorFecha(asistenciaCurso);
        return repositorioAsistenciaCurso.crear(asistenciaCurso);
    }

    private void validaExistenciaPrevia(AsistenciaCurso asistenciaCurso){
        boolean existe = repositorioAsistenciaCurso.existePorIdComparendo(asistenciaCurso.getComparendo().getId());
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

    private Integer validaFechaAsistencia(AsistenciaCurso asistenciaCurso){
        Integer diasHabiles = repositorioAsistenciaCurso.diasHabilesDesdeFechaComparendo(asistenciaCurso);
        if(diasHabiles>MAXIMOS_DIAS_HABILES_DESDE_COMPARENDO){
            throw new ExcepcionValorInvalido(SE_HA_EXEDIDO_EL_TIEMPO_LIMITE_PARA_ASISTIR_AL_CURSO);
        }
        return diasHabiles;
    }
}
