package com.ceiba.comparendo.consulta;

import com.ceiba.comparendo.modelo.dto.DtoComparendo;
import com.ceiba.comparendo.puerto.dao.DaoComparendo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListaComparendos {

    private final DaoComparendo daoComparendo;


    public ManejadorListaComparendos(DaoComparendo daoComparendo) {
        this.daoComparendo = daoComparendo;
    }

    public List<DtoComparendo> ejecutar(String identificacionInfractor){
        return daoComparendo.listarPorInfractor(identificacionInfractor);
    }

}
