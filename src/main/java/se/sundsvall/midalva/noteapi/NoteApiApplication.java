package se.sundsvall.midalva.noteapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import se.sundsvall.midalva.noteapi.model.Note;
import se.sundsvall.midalva.noteapi.model.NoteDTO;
import se.sundsvall.midalva.noteapi.model.Tag;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;
import se.sundsvall.midalva.noteapi.service.NoteService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

		NoteDTO note = new NoteDTO(

				"Continuous integration",
				"txt",
				"In software engineering, continuous integration (CI) is the practice of merging all developer ",
						tags
		);

		noteService.save(note);

	}

}
