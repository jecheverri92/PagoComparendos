package com.ceiba.comparendo.adaptador.dao;

import com.ceiba.comparendo.modelo.dto.DtoComparendo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeoComparendo implements RowMapper<DtoComparendo>, MapperResult {
    @Override
    public DtoComparendo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id_comparendo");
        String numeroComparendo = rs.getString("numero_comparendo");
        Integer tipoInfraccion = rs.getInt("tipo_infraccion");
        String identificacionInfractor = rs.getString("identificacion_infractor");
        Date fechaComparendo = rs.getDate("fecha_comparendo");
        BigDecimal valorComparendo = rs.getBigDecimal("valor_comparendo");
        return new DtoComparendo(id,numeroComparendo,tipoInfraccion,identificacionInfractor,fechaComparendo,valorComparendo);
    }
}
