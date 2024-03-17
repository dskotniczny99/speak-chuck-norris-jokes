package org.example.speakjokes.controller;


import org.example.speakjokes.api.ChuckNorrisJokesApiResponse;
import org.example.speakjokes.service.ChuckNorrisJokesService;
import org.example.speakjokes.service.VoiceRssService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

@WebMvcTest(ChuckNorrisJokesController.class)
public class ChuckNorrisJokesControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChuckNorrisJokesService jokesService;

    @MockBean
    private VoiceRssService voiceRssService;

    @BeforeEach
    public void setUp() {
        ChuckNorrisJokesApiResponse mockApiResponse = new ChuckNorrisJokesApiResponse();
        mockApiResponse.setValue("Mock joke");
        Mockito.when(jokesService.randomJoke()).thenReturn(mockApiResponse);
    }

    @Test
    public void jokeView_should_return_JokesPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/jokes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("jokes"));
    }

    @Test
    public void joke_should_return_jokes_page_with_joke_attribute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/jokes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("jokes"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("joke"))
                .andExpect(MockMvcResultMatchers.model().attribute("joke", "Mock joke"));

        Mockito.verify(voiceRssService, times(1)).speakJoke(anyString());
    }
}