package com.ceiba.comparendo.adaptador.dao;

import com.ceiba.comparendo.modelo.dto.DtoComparendo;
import com.ceiba.comparendo.puerto.dao.DaoComparendo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DaoComparendoMysql implements DaoComparendo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoComparendoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace="comparendo", value="listarPorInfractor")
    private static String sqlListarPorInfractor;

    @SqlStatement(namespace="comparendo", value="obtenerValorInfraccion")
    private static String sqlObtenerValorInfraccion;

    @Override
    public List<DtoComparendo> listarPorInfractor(String identificacionInfractor) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("identificacionInfractor", identificacionInfractor);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorInfractor,mapSqlParameterSource, new MapeoComparendo());
    }

    @Override
    public BigDecimal obtenerTarifainfraccion(Integer tipoInfraccion) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("tipoInfraccion", tipoInfraccion);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerValorInfraccion,mapSqlParameterSource, BigDecimal.class);
    }


}
