package com.ceiba.comparendo.puerto.repositorio;

import com.ceiba.comparendo.modelo.entidad.Comparendo;

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
    void actualizar(Comparendo comparendo);

    /**
     * Permite eliminar un comparendo
     * @param comparendo
     */
    void eliminar(Comparendo comparendo);


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

    /**
     * Permite retornar la fehca del comparendo
     * @param numeroComparendo
     * @return fecha del comparendo
     */
    Comparendo obtenerComparendoPorNumeroComparendo(String numeroComparendo);
}
