package se.sundsvall.midalva.noteapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.model.Note;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RestController
public class GetNoteController {

    @Autowired
    private NoteRepository repo;

    @GetMapping
    @RequestMapping(path="/note/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Note getNote(@PathVariable("id") Long id) {

        Optional<Note> note = repo.findById(id);

        if (note.isPresent()){
            return note.get();
        }
        return null;
    }
}
