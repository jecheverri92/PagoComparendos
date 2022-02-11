package com.ceiba.curso.puerto.repositorio;

import com.ceiba.curso.modelo.entidad.AsistenciaCurso;

import java.time.LocalDateTime;

public interface RepositorioAsistenciaCurso {

    /**
     * Permite registrar una asistencia a un curso
     * @param asistenciaCurso
     * @return el id generado
     */
    Long crear(AsistenciaCurso asistenciaCurso);

    /**
     * Permite validar si existe un curso registrado con el id comparendo
     * @param id
     * @return si existe o no
     */
    boolean existePorIdComparendo(Long id);

    /**
     * Permite validar si el infractor ha asistido a cursos en la misma fehca
     * @param asistenciaCurso
     * @return el numero de asistencias en el dia
     */
    Integer numeroAsistenciasPorFecha(AsistenciaCurso asistenciaCurso);

    /**
     * Permite retornar el numero de dias habiles que han pasado desde el comparendo
     * @param asistenciaCurso
     * @return el numero de dias habiles desde el comparendo
     */
    Integer diasHabilesDesdeFechaComparendo(AsistenciaCurso asistenciaCurso);
}
