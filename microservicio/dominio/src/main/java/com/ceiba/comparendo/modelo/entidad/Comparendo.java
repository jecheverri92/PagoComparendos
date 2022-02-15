package com.ceiba.comparendo.modelo.entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Comparendo {

    private static final String MENSAJE_NUMERO_COMPARENDO_OBLIGATORIO = "El numero del comparendo es obligatorio";
    private static final String MENSAJE_IDENTIFICACION_INFRACTOR_OBLIGATORIA = "La identificacion del infractor es obligatoria";
    private static final String MENSAJE_TIPO_INFRACCION_OBLIGATORIO = "El tipo de infraccion cometida es obligatorio";
    private static final String MENSAJE_FECHA_COMPARENDO_OBLIGATORIA = "La fecha del comparendo es obligatoria";

    private Long id;
    private String numeroComparendo;
    private Integer tipoInfraccion;
    private String identificacionInfractor;
    private LocalDateTime fechaComparendo;
    @Setter
    private BigDecimal valorComparendo;


    public Comparendo(Long id, String numeroComparendo, Integer tipoInfraccion, String identificacionInfractor, LocalDateTime fechaComparendo, BigDecimal valorComparendo) {
        validarObligatorio(numeroComparendo, MENSAJE_NUMERO_COMPARENDO_OBLIGATORIO);
        validarObligatorio(identificacionInfractor, MENSAJE_IDENTIFICACION_INFRACTOR_OBLIGATORIA);
        validarObligatorio(tipoInfraccion, MENSAJE_TIPO_INFRACCION_OBLIGATORIO);
        validarObligatorio(fechaComparendo, MENSAJE_FECHA_COMPARENDO_OBLIGATORIA);

        this.id = id;
        this.numeroComparendo = numeroComparendo;
        this.tipoInfraccion = tipoInfraccion;
        this.identificacionInfractor = identificacionInfractor;
        this.fechaComparendo = fechaComparendo;
        this.valorComparendo = valorComparendo;
    }
}
