package com.ceiba.comparendo.servicio;

import com.ceiba.comparendo.modelo.dto.DtoComparendo;
import com.ceiba.comparendo.modelo.dto.DtoPagoComparendo;
import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.comparendo.puerto.dao.DaoComparendo;
import com.ceiba.comparendo.puerto.repositorio.RepositorioComparendo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import java.util.List;

public class ServicioPagarComparendo {

    private static final String EL_COMPARENDO_NO_EXISTE_EN_EL_SITEMA = "El comparendo no existe en el sistema";
    private static final String EL_COMPARENDO_YA_SE_ENCUENTRA_PAGADO = "El comparendo ya ha sido pagado";
    private static final String EL_VALOR_DEL_COMPARENDO_NO_ES_VALIDO = "El valor del comparendo no es valido";

    private final RepositorioComparendo repositorioComparendo;
    private final DaoComparendo daoComparendo;


    public ServicioPagarComparendo(RepositorioComparendo repositorioComparendo, DaoComparendo daoComparendo) {
        this.repositorioComparendo = repositorioComparendo;
        this.daoComparendo = daoComparendo;
    }


    public void ejecutar(List<DtoPagoComparendo> comparendosAPagar){
        this.validarExistenciaPrevia(comparendosAPagar);
        this.eliminarComparendos(comparendosAPagar);
    }

    private void eliminarComparendos(List<DtoPagoComparendo> comparendosAPagar){
        comparendosAPagar.stream().forEach(comparendo -> {
            Comparendo comparendoBD = this.repositorioComparendo.obtenerComparendoPorNumeroComparendo(comparendo.getNumeroComparendo());
            this.validarValorComparendo(comparendo,comparendoBD);
            this.repositorioComparendo.eliminar(comparendoBD);
        });
    }

    private void validarValorComparendo(DtoPagoComparendo comparendoAPagar, Comparendo comparendoBD){
        if(comparendoAPagar.getValorPagado().compareTo(comparendoBD.getValorComparendo())!=0){
            throw  new ExcepcionValorInvalido(EL_VALOR_DEL_COMPARENDO_NO_ES_VALIDO);
        }
    }


    private void validarExistenciaPrevia(List<DtoPagoComparendo> comparendosAPagar) {
        comparendosAPagar.stream().forEach(comparendo -> {
            boolean existe = this.repositorioComparendo.existePorNumeroComparendo(comparendo.getNumeroComparendo());
            if(!existe) {
                throw new ExcepcionSinDatos(EL_COMPARENDO_NO_EXISTE_EN_EL_SITEMA);
            }
        });
    }
}
