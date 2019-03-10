package se.sundsvall.midalva.noteapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.model.Note;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController

@RequestMapping("/note")
public class NoteController {

    private  final Logger LOG =  LoggerFactory.getLogger(NoteController.class);

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  void addNote(@RequestBody Note note){
        LOG.debug(note.toString());
    }
}
