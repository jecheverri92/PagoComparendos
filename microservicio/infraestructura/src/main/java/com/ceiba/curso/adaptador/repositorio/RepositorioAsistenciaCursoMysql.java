package com.ceiba.curso.adaptador.repositorio;

import com.ceiba.curso.modelo.entidad.AsistenciaCurso;
import com.ceiba.curso.puerto.repositorio.RepositorioAsistenciaCurso;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioAsistenciaCursoMysql implements RepositorioAsistenciaCurso {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioAsistenciaCursoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @SqlStatement(namespace="curso", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="curso", value="numeroAsistenciasCursoInfractorPorFecha")
    private static String sqlNumeroasistenciasCursoPorFecha;

    @SqlStatement(namespace="curso", value="existePorNumeroComparendo")
    private static String sqlExistePorNumeroComparendo;

    @Override
    public Long crear(AsistenciaCurso asistenciaCurso) {
        return this.customNamedParameterJdbcTemplate.crear(asistenciaCurso,sqlCrear);
    }

    @Override
    public boolean existePorNumeroComparendo(String numeroComparendo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numeroComparendo", numeroComparendo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorNumeroComparendo,paramSource, Boolean.class);
    }


    @Override
    public Integer numeroAsistenciasPorFecha(AsistenciaCurso asistenciaCurso) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fechaAsistencia", asistenciaCurso.getFechaAsistencia());
        paramSource.addValue("identificacionInfractor", asistenciaCurso.getIdentificacionInfractor());
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlNumeroasistenciasCursoPorFecha,paramSource,Integer.class);
    }


}
