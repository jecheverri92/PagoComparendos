package com.ceiba.comparendo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.comparendo.servicio.testdatabuilder.ComparendoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparendoTest {

    @Test
    @DisplayName("Deberia crear el comparendo correctamente")
    void deberiaCrearElComparendoCOrrectamente(){
        //arrange
        LocalDateTime fechaComparendo = LocalDateTime.now();
        // act
        Comparendo comparendo = new ComparendoTestDataBuilder().conFechaComparendo(fechaComparendo).conId(1L).build();
        //assert
        assertEquals(1L, comparendo.getId());
        assertEquals("0001", comparendo.getNumeroComparendo());
        assertEquals(1, comparendo.getTipoInfraccion());
        assertEquals("123456789", comparendo.getNumeroComparendo());
        assertEquals(fechaComparendo,comparendo.getFechaComparendo());
        assertEquals(null, comparendo.getValorComparendo());
    }

    @Test
    @DisplayName("Deberia fallar la creacion sin numeroComparendo")
    void deberiaFallarSinNumeroComparendo(){
        //Arrange
        ComparendoTestDataBuilder comparendoTestDataBuilder = new ComparendoTestDataBuilder().conNumeroComparendo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()-> {
            comparendoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "El numero del comparendo es obligatorio");
    }

    @Test
    @DisplayName("Deberia falalr la creacion sin tipoInfraccion")
    void deberiaFallarSinTipoInfraccion(){
        //Arrange
        ComparendoTestDataBuilder comparendoTestDataBuilder = new ComparendoTestDataBuilder().conTipoInfraccion(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()-> {
            comparendoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "El tipo de infraccion cometida es obligatorio");
    }

    @Test
    @DisplayName("Deberia falalr la creacion sin tipoInfraccion")
    void deberiaFallarSinIdentificacionInfractor(){
        //Arrange
        ComparendoTestDataBuilder comparendoTestDataBuilder = new ComparendoTestDataBuilder().conIdentificacionInfractor(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()-> {
            comparendoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "La identificacion del infractor es obligatoria");
    }

    @Test
    @DisplayName("Deberia falalr la creacion sin tipoInfraccion")
    void deberiaFallarSinFechaComparendo(){
        //Arrange
        ComparendoTestDataBuilder comparendoTestDataBuilder = new ComparendoTestDataBuilder().conFechaComparendo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(()-> {
            comparendoTestDataBuilder.build();
        }, ExcepcionValorObligatorio.class, "La fecha del comparendo es obligatoria");
    }
}
