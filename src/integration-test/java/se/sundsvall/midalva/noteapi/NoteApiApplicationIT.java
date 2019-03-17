package se.sundsvall.midalva.noteapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.sundsvall.midalva.noteapi.NoteApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={NoteApiApplication.class})
public class NoteApiApplicationIT {

	@Test
	public void contextLoads() {
	}

}
