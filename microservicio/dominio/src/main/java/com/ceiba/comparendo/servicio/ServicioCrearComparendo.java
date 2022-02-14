package com.ceiba.comparendo.servicio;

import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.comparendo.puerto.dao.DaoComparendo;
import com.ceiba.comparendo.puerto.repositorio.RepositorioComparendo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import java.math.BigDecimal;

public class ServicioCrearComparendo {

    private static final String EL_COMPARENDO_YA_EXISTE_EN_EL_SITEMA = "El comparendo ya exite en el sistema";
    private static final String LA_TARIFA_PARA_LA_INFRACCION_NO_CONFIGURADA = "La tarifa para el tipo de infraccion no esta configurada";

    private final RepositorioComparendo repositorioComparendo;
    private final DaoComparendo daoComparendo;

    public ServicioCrearComparendo(RepositorioComparendo repositorioComparendo, DaoComparendo daoComparendo) {
        this.repositorioComparendo = repositorioComparendo;
        this.daoComparendo = daoComparendo;
    }

    public Long ejecutar(Comparendo comparendo){
        this.validarExistenciaPrevia(comparendo);
        this.obtenerValorInfraccion(comparendo);
        return repositorioComparendo.crear(comparendo);
    }

    private void validarExistenciaPrevia(Comparendo comparendo) {
        boolean existe = this.repositorioComparendo.existePorNumeroComparendo(comparendo.getNumeroComparendo());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_COMPARENDO_YA_EXISTE_EN_EL_SITEMA);
        }
    }


    private void obtenerValorInfraccion(Comparendo comparendo){
        BigDecimal valorInfraccion = this.daoComparendo.obtenerTarifainfraccion(comparendo.getTipoInfraccion());
        if(valorInfraccion == null){
            throw new ExcepcionValorInvalido(LA_TARIFA_PARA_LA_INFRACCION_NO_CONFIGURADA);
        }
        comparendo.setValorComparendo(valorInfraccion);
    }

}
