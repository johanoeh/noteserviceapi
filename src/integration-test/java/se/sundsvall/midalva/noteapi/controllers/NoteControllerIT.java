package se.sundsvall.midalva.noteapi.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import se.sundsvall.midalva.noteapi.controllers.NoteController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@ComponentScan("se.sundsvall.midalva.noteapi")
@SpringBootTest(classes={NoteController.class})
@AutoConfigureMockMvc
public class NoteControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNoteRequest() throws Exception {

        this.mockMvc.perform(post("/note")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSON_REQUEST)).andDo(print())
                .andExpect(status().isAccepted());

    }

    public static final String JSON_REQUEST =
            "{\n" +
                "  \"name\": \"how_to_use_bamboo\",\n" +
                "  \"format\":\"txt\",\n" +
                "  \"tags\": [\n" +
                "    \"continuous integration\",\n" +
                "    \"bamboo\",\n" +
                "    \"maven\"\n" +
                "  ],\n" +
                "  \"content\": \"First you have to install Bamboo continuous integration plattform\"\n" +
            "}";
}
