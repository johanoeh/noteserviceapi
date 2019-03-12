package se.sundsvall.midalva.noteapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.model.Note;
import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;
import sun.rmi.runtime.Log;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Optional;


@RestController

@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteRepository repo;

    private  final Logger LOG =  LoggerFactory.getLogger(NoteController.class);

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  void addNote(@RequestBody Note note){
        repo.save(note);
        Iterable<Note> all = repo.findAll();
        if(!all.iterator().hasNext()){
            LOG.info("no result");
        }
        all.forEach(n-> LOG.info(n.toString()));
        LOG.info(note.toString());
    }

}
