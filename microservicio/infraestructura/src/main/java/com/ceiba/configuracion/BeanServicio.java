package com.ceiba.configuracion;

import com.ceiba.comparendo.puerto.dao.DaoComparendo;
import com.ceiba.comparendo.puerto.repositorio.RepositorioComparendo;
import com.ceiba.comparendo.servicio.ServicioCrearComparendo;
import com.ceiba.comparendo.servicio.ServicioPagarComparendo;
import com.ceiba.curso.puerto.repositorio.RepositorioAsistenciaCurso;
import com.ceiba.curso.servicio.ServicioRegistrarAsistenciaCurso;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearComparendo servicioCrearComparendo(RepositorioComparendo repositorioComparendo, DaoComparendo daoComparendo) {
        return new ServicioCrearComparendo(repositorioComparendo, daoComparendo);
    }

    @Bean
    public ServicioRegistrarAsistenciaCurso servicioRegistrarAsistenciaCursoAsistenciaCurso(RepositorioComparendo repositorioComparendo, RepositorioAsistenciaCurso repositorioAsistenciaCurso){
        return new ServicioRegistrarAsistenciaCurso(repositorioComparendo,repositorioAsistenciaCurso);
    }

    @Bean
    public ServicioPagarComparendo servicioPagarComparendo(RepositorioComparendo repositorioComparendo, DaoComparendo daoComparendo){
        return new ServicioPagarComparendo(repositorioComparendo,daoComparendo);
    }
}
