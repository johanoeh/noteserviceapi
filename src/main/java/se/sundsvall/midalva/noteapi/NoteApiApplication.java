package se.sundsvall.midalva.noteapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.sundsvall.midalva.noteapi.model.dto.Note;
import se.sundsvall.midalva.noteapi.service.NoteService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class NoteApiApplication implements CommandLineRunner {

	@Autowired
	NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(NoteApiApplication.class, args);
	}


	@Override
	public void run(String... args){

		List<String> tags = new ArrayList<>();
		tags.add("Continuous integration");
		tags.add("Jenkins");

		Note note = new Note(

				"Continuous integration",
				"txt",
				"In software engineering, continuous integration (CI) is the practice of merging all developer ",
						tags
		);

		noteService.save(note);

	}

}
