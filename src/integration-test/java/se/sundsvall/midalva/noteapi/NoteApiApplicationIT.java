package se.sundsvall.midalva.noteapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import se.sundsvall.midalva.noteapi.NoteApiApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes={NoteApiApplication.class})
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
public class NoteApiApplicationIT {

	private static  final Logger LOG = LoggerFactory.getLogger(NoteApiApplicationIT.class);
	@Value(value = "${ttt.xxx}")
	String str;

	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() {

	}

	@Test
	public void testNoteController() throws Exception {
		LOG.info(str);

		mvc.perform(post("/note").content(JSON_REQUEST)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().is2xxSuccessful());
	}

	private  static final String JSON_REQUEST =
			"{\n" +
					"  \"content\": \"string\",\n" +
					"  \"format\": \"string\",\n" +
					"  \"name\": \"string\",\n" +
					"  \"noteId\": 0,\n" +
					"  \"tags\": [\n" +
					"    \"string\"\n" +
					"  ]\n" +
					"}";

}
