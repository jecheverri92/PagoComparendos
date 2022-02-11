package com.ceiba.liquidacion.servicio;

import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.comparendo.puerto.repositorio.RepositorioComparendo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearComparendo {

    private static final String EL_COMPARENDO_YA_EXISTE_EN_EL_SITEMA = "El comparendo ya exite en el sistema";

    private final RepositorioComparendo repositorioComparendo;

    public ServicioCrearComparendo(RepositorioComparendo repositorioComparendo) {
        this.repositorioComparendo = repositorioComparendo;
    }

    public Long ejecutar(Comparendo comparendo){
        this.validarExistenciaPrevia(comparendo);
        return repositorioComparendo.crear(comparendo);
    }

    private void validarExistenciaPrevia(Comparendo comparendo) {
        boolean existe = this.repositorioComparendo.existePorNumeroComparendo(comparendo.getNumeroComparendo());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_COMPARENDO_YA_EXISTE_EN_EL_SITEMA);
        }
    }

}
