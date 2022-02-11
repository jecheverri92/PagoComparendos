package com.ceiba.comparendo.puerto.repositorio;

import com.ceiba.comparendo.modelo.entidad.Comparendo;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioComparendo {

    /**
     * Permite crear un comparendo
     * @param comparendo
     * @return el id generado
     */
    Long crear(Comparendo comparendo);

    /**
     * Permite actualizar un comparendo
     * @param comparendo
     */
    void actualizar(Usuario comparendo);


    /**
     * Permite validar si existe un comparendo con el numero de comparendo
     * @return si existe o no
     */
    boolean existePorNumeroComparendo(String numeroComparendo);

    /**
     * Permite validar si existe un comparendo con el id
     * @return si existe o no
     */
    boolean existePorId(Long id);
}
