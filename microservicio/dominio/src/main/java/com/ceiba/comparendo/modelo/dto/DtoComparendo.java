package com.ceiba.comparendo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoComparendo {
    private Long id;
    private String numeroComparendo;
    private Integer tipoInfraccion;
    private String identificacionInfractor;
    private Date fechaComparendo;
    private BigDecimal valorComparendo;
}
