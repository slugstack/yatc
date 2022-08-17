package org.slugstack.yatc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slugstack.yatc.request.RedirectCreationRequest;
import org.slugstack.yatc.service.RedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RedirectController.class)
public class RedirectControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private RedirectService redirectService;

    @Test
    public void createAliasSuccess() throws Exception {
        var request = new RedirectCreationRequest("abc123", "http://localhost:8080");
        var body = mapper.writeValueAsString(request);
        mockMvc.perform(post("/")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void createAliasWithoutURLProtocol() throws Exception {
        var request = new RedirectCreationRequest("abc123", "localhost:8080");
        var body = mapper.writeValueAsString(request);
        mockMvc.perform(post("/")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
