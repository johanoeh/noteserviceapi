package se.sundsvall.midalva.noteapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.model.NoteDTO;
import se.sundsvall.midalva.noteapi.service.NoteService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
public class GetNoteController {


    @Autowired
    NoteService noteService;

    @GetMapping
    @RequestMapping(path = "/note/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public NoteDTO getNote(@PathVariable("id") Long id) {
        return noteService.getNote(id);
    }

}
