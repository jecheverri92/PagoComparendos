package com.ceiba.comparendo.servicio.testdatabuilder;

import com.ceiba.comparendo.modelo.entidad.Comparendo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ComparendoTestDataBuilder {

    private Long id;
    private String numeroComparendo;
    private Integer tipoInfraccion;
    private String identificacionInfractor;
    private LocalDateTime fechaComparendo;
    private BigDecimal valorComparendo;

    public ComparendoTestDataBuilder(){
        numeroComparendo = "0001";
        tipoInfraccion = 1;
        identificacionInfractor="123456789";
        fechaComparendo = LocalDateTime.now();
        valorComparendo = null;
    }

    public ComparendoTestDataBuilder conNumeroComparendo(String numeroComparendo){
        this.numeroComparendo = numeroComparendo;
        return this;
    }

    public ComparendoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public ComparendoTestDataBuilder conTipoInfraccion(Integer tipoInfraccion){
        this.tipoInfraccion = tipoInfraccion;
        return this;
    }

    public ComparendoTestDataBuilder conIdentificacionInfractor(String identificacionInfractor){
        this.identificacionInfractor = identificacionInfractor;
        return this;
    }

    public ComparendoTestDataBuilder conFechaComparendo(LocalDateTime fechaComparendo){
        this.fechaComparendo = fechaComparendo;
        return this;
    }

    public ComparendoTestDataBuilder conValorComparendo(BigDecimal valorComparendo){
        this.valorComparendo = valorComparendo;
        return this;
    }

    public Comparendo build() { return  new Comparendo(id,numeroComparendo,tipoInfraccion,identificacionInfractor,fechaComparendo,valorComparendo);}

    public static ComparendoTestDataBuilder unComparendo(){
        return new ComparendoTestDataBuilder();
    }
}
