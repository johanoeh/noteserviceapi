package se.sundsvall.midalva.noteapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.model.*;
import se.sundsvall.midalva.noteapi.service.NoteService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
public class GetNotesByTagController {

    @Autowired
    NoteService noteService;

    @GetMapping
    @RequestMapping(path="/note/tag/{tag}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<NoteDTO> getNote(@PathVariable("tag") String tag) {
       return noteService.findNotesByTag(tag);
    }


}
