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
public class NoteApiApplication {

	@Autowired
	NoteService noteService;

	public static void main(String[] args) {
		SpringApplication.run(NoteApiApplication.class, args);
	}


}
