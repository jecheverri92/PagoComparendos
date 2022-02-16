package com.ceiba.comparendo.servicio.testdatabuilder;

import com.ceiba.comparendo.comando.ComandoComparendo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ComandoComparendoTestDataBuilder {

    private Long id;
    private String numeroComparendo;
    private Integer tipoInfraccion;
    private String identificacionInfractor;
    private LocalDateTime fechaComparendo;
    private BigDecimal valorComparendo;

    public ComandoComparendoTestDataBuilder(){
        this.numeroComparendo = "9999";
        this.tipoInfraccion = 1;
        this.identificacionInfractor = "123456789";
        this.fechaComparendo = LocalDateTime.now();
    }

    public ComandoComparendoTestDataBuilder conNumeroComparendo(String numeroComparendo){
        this.numeroComparendo = numeroComparendo;
        return this;
    }

    public ComandoComparendo build(){return new ComandoComparendo(id,numeroComparendo,tipoInfraccion,identificacionInfractor,fechaComparendo,valorComparendo);}

    public static ComandoComparendoTestDataBuilder unComandoComparendo(){
        return new ComandoComparendoTestDataBuilder();
    }
}
