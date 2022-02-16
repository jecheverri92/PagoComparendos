package com.ceiba.comparendo.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.comparendo.comando.ComandoComparendo;
import com.ceiba.comparendo.servicio.testdatabuilder.ComandoComparendoTestDataBuilder;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.controlador.ComandoControladorUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoUsuarioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorComparendoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un comparendo")
    void deberiaCrearUnComparendo() throws Exception{
        // arrange
        ComandoComparendo comparendo = ComandoComparendoTestDataBuilder.unComandoComparendo().build();
        // act - assert
        mocMvc.perform(post("/comparendos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comparendo)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

}
