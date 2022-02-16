package com.ceiba.comparendo.adaptador.repositorio;

import com.ceiba.comparendo.modelo.dto.DtoComparendo;
import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MapeoComparendo implements RowMapper<Comparendo>, MapperResult {
    @Override
    public Comparendo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String numeroComparendo = rs.getString("numero_comparendo");
        Integer tipoInfraccion = rs.getInt("tipo_infraccion");
        String identificacionInfractor = rs.getString("identificacion_infractor");
        LocalDateTime fechaComparendo = this.extraerLocalDateTime(rs,"fecha_comparendo");
        BigDecimal valorComparendo = rs.getBigDecimal("valor_comparendo");
        return new Comparendo(id,numeroComparendo,tipoInfraccion,identificacionInfractor,fechaComparendo,valorComparendo);
    }
}
