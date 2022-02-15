package com.ceiba.comparendo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.comparendo.puerto.dao.DaoComparendo;
import com.ceiba.comparendo.puerto.repositorio.RepositorioComparendo;
import com.ceiba.comparendo.servicio.testdatabuilder.ComparendoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearComparendoTest {

    @Test
    @DisplayName("Deberia crear el comparendo de manera correcta")
    void deberiaCrearElComparendoDeManeraCorrecta(){
        //arrange
        Comparendo comparendo = ComparendoTestDataBuilder.unComparendo().build();
        RepositorioComparendo repositorioComparendo = Mockito.mock(RepositorioComparendo.class);
        DaoComparendo daoComparendo = Mockito.mock(DaoComparendo.class);
        Mockito.when(repositorioComparendo.existePorNumeroComparendo(Mockito.anyString())).thenReturn(false);
        Mockito.when(daoComparendo.obtenerTarifainfraccion(Mockito.anyInt())).thenReturn(BigDecimal.valueOf(10000));
        Mockito.when(repositorioComparendo.crear(comparendo)).thenReturn(1L);
        ServicioCrearComparendo servicioCrearComparendo = new ServicioCrearComparendo(repositorioComparendo, daoComparendo);
        //act
        Long idComparendo = servicioCrearComparendo.ejecutar(comparendo);
        //assert
        assertEquals(1L,idComparendo);
        Mockito.verify(repositorioComparendo,Mockito.times(1)).crear(comparendo);
    }


    @Test
    @DisplayName("Deberia Lanzar una excepcion cunado el comparendo ya exista")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelComparendo(){
        //arrange
        Comparendo comparendo = ComparendoTestDataBuilder.unComparendo().build();
        RepositorioComparendo repositorioComparendo = Mockito.mock(RepositorioComparendo.class);
        DaoComparendo daoComparendo = Mockito.mock(DaoComparendo.class);
        Mockito.when(repositorioComparendo.existePorNumeroComparendo(Mockito.anyString())).thenReturn(true);
        ServicioCrearComparendo servicioCrearComparendo = new ServicioCrearComparendo(repositorioComparendo, daoComparendo);
        //act- assert
        BasePrueba.assertThrows(() -> servicioCrearComparendo.ejecutar(comparendo), ExcepcionDuplicidad.class,"El comparendo ya exite en el sistema");
    }

    @Test
    @DisplayName("Deberia Lanzar una Excepcion cuando la infraccionTarifa no este configurada")
    void deberiaLanzarUnaExepcionCuandoLaInfraccionTarifaNoEsteConfigurada(){
        //arrange
        Comparendo comparendo = ComparendoTestDataBuilder.unComparendo().build();
        RepositorioComparendo repositorioComparendo = Mockito.mock(RepositorioComparendo.class);
        DaoComparendo daoComparendo = Mockito.mock(DaoComparendo.class);
        Mockito.when(repositorioComparendo.existePorNumeroComparendo(Mockito.anyString())).thenReturn(false);
        Mockito.when(daoComparendo.obtenerTarifainfraccion(Mockito.anyInt())).thenReturn(null);
        ServicioCrearComparendo servicioCrearComparendo = new ServicioCrearComparendo(repositorioComparendo, daoComparendo);
        //act- assert
        BasePrueba.assertThrows(() -> servicioCrearComparendo.ejecutar(comparendo), ExcepcionValorInvalido.class,"La tarifa para el tipo de infraccion no esta configurada");
    }

}
