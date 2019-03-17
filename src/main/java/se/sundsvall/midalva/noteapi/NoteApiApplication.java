package se.sundsvall.midalva.noteapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;

import java.util.stream.IntStream;

@SpringBootApplication
public class NoteApiApplication implements CommandLineRunner {

	@Autowired
	NoteRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(NoteApiApplication.class, args);
	}


	/**
	 *
	 */
	//@Profile("local")
	@Override
	public void run(String... args){

		IntStream.range(0,100).forEach(i -> System.out.println("Hello SpringBoot"));

	}

}
