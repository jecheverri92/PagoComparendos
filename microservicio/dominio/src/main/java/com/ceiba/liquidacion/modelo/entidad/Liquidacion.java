package com.ceiba.liquidacion.modelo.entidad;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Liquidacion {

    private static final String MENSAJE_NUMERO_COMPARENDO_OBLIGATORIO = "El numero del comparendo es obligatorio";
    private static final String MENSAJE_IDENTIFICACION_INFRACTOR_OBLIGATORIA = "La identificacion del infractor es obligatoria";
    private static final String MENSAJE_TIPO_INFRACCION_OBLIGATORIO = "El tipo de infraccion cometida es obligatorio";
    private static final String MENSAJE_FECHA_COMPARENDO_OBLIGATORIA = "La fecha del comparendo es obligatoria";

    private Long id;
    private String numeroComparendo;
    private Integer tipoInfraccion;
    private BigDecimal valorInfraccion;
    private String identificacionInfractor;
    private LocalDateTime fechaComparendo;
    private String activo;

    public Liquidacion(Long id, String numeroComparendo, Integer tipoInfraccion, String identificacionInfractor, LocalDateTime fechaComparendo, String activo) {
        validarObligatorio(numeroComparendo, MENSAJE_NUMERO_COMPARENDO_OBLIGATORIO);
        validarObligatorio(identificacionInfractor, MENSAJE_IDENTIFICACION_INFRACTOR_OBLIGATORIA);
        validarObligatorio(tipoInfraccion, MENSAJE_TIPO_INFRACCION_OBLIGATORIO);
        validarObligatorio(fechaComparendo, MENSAJE_FECHA_COMPARENDO_OBLIGATORIA);

        this.id = id;
        this.numeroComparendo = numeroComparendo;
        this.tipoInfraccion = tipoInfraccion;
        this.identificacionInfractor = identificacionInfractor;
        this.fechaComparendo = fechaComparendo;
        this.activo = activo;
    }
}
