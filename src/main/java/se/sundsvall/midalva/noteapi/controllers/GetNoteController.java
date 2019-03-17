package se.sundsvall.midalva.noteapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.model.Note;
import se.sundsvall.midalva.noteapi.model.NoteDTO;
import se.sundsvall.midalva.noteapi.model.NoteHasTag;
import se.sundsvall.midalva.noteapi.repo.NoteHasTagRepository;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;
import se.sundsvall.midalva.noteapi.repo.TagRepository;
import se.sundsvall.midalva.noteapi.mapper.NoteMapper;
import se.sundsvall.midalva.noteapi.service.NoteService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
