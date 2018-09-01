package com.sda.twittermvc.controllers;

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
    MockMvc mockMvc;

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
}
