package com.ceiba.comparendo.adaptador.repositorio;

import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.comparendo.puerto.repositorio.RepositorioComparendo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioComparendoMysql implements RepositorioComparendo {


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="comparendo", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="comparendo", value="existePorNumeroComparendo")
    private static String sqlExistePorNroComparendo;

    @SqlStatement(namespace="comparendo", value="comparendoPorNumeroComparendo")
    private static String sqlComparendoPorNumeroComparendo;

    @SqlStatement(namespace="comparendo", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="comparendo", value="eliminar")
    private static String sqlEliminar;

    public RepositorioComparendoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Comparendo comparendo) {
        return this.customNamedParameterJdbcTemplate.crear(comparendo,sqlCrear);
    }

    @Override
    public void actualizar(Comparendo comparendo) {
        this.customNamedParameterJdbcTemplate.actualizar(comparendo, sqlActualizar);
    }

    @Override
    public void eliminar(Comparendo comparendo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idComparendo", comparendo.getId());

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorNumeroComparendo(String numeroComparendo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numeroComparendo", numeroComparendo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorNroComparendo,paramSource,Boolean.class);
    }

    @Override
    public boolean existePorId(Long id) {
        return false;
    };

    @Override
    public Comparendo obtenerComparendoPorNumeroComparendo(String numeroComparendo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numeroComparendo", numeroComparendo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlComparendoPorNumeroComparendo,paramSource,new MapeoComparendo());
    }
}
