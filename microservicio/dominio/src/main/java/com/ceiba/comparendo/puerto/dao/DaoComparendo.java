package com.ceiba.comparendo.puerto.dao;

import com.ceiba.comparendo.modelo.dto.DtoComparendo;

import java.math.BigDecimal;
import java.util.List;

public interface DaoComparendo {
    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoComparendo> listarPorInfractor(String identificacionInfractor);

    /**
     * Permite obtener el valor de una infraccion
     * @return valor Infraccion
     */
    BigDecimal obtenerTarifainfraccion(Integer tipoInfraccion);
}
