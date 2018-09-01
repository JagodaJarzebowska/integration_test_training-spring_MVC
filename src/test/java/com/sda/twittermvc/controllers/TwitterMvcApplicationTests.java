package com.sda.twittermvc.controllers;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest  // tylko testy widoku,
public class TwitterMvcApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldRejectAccessToSecuredEndpointWhenNoCredentialsArePasser() throws Exception {
        String endpoint = "/message";

        mockMvc.perform(MockMvcRequestBuilders.get(endpoint))
                //then
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    public void shouldReturnOkStatusWhenGetMessageEndpoint() throws Exception {
        //given
        String endpoint = "/message";
        //when
        mockMvc.perform(MockMvcRequestBuilders.get(endpoint))
                //then
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldCreateMessageWhenPostMessageEndpoint() throws Exception {
        //given
        String endpoint = "/message";
        //when
        mockMvc.perform(MockMvcRequestBuilders.post(endpoint).param("content","msg content"))
                //then
                .andExpect(MockMvcResultMatchers.status()
                        .isOk())
                // zwraca nazwe widoku
                .andExpect(MockMvcResultMatchers.model()
                        .attribute("message", Matchers
                                .hasProperty("content", Matchers.is("msg content"))))
        .andExpect(MockMvcResultMatchers.view().name("show-message"));
    }

    @Test
    public void shouldCreateEmptyMessageWhenGetMessageEndpoint() throws Exception {
        //given
        String endpoint = "/message";
        //when
        mockMvc.perform(MockMvcRequestBuilders.post(endpoint))
                //then
                .andExpect(MockMvcResultMatchers.model().attributeExists("message"));
    }






    @Test
    public void shouldReturnMessageView() throws Exception {

        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/message"))
                //then
                // zwraca status widoku
                .andExpect(MockMvcResultMatchers.status().isOk())
                // zwraca nazwe widoku
                .andExpect(MockMvcResultMatchers.view().name("showMessage"));
    }

    @Test
    public void shouldCreateMessageWithParam() throws Exception {
        //when
        mockMvc.perform(MockMvcRequestBuilders.post("/message"))
                //then
                // zwraca status widoku
                .andExpect(MockMvcResultMatchers.status().isOk())
                // zwraca nazwe widoku
                .andExpect(MockMvcResultMatchers.model().attribute("message",
                        Matchers.hasProperty("content",
                                Matchers.is("wiadomosc"))));
    }
}
