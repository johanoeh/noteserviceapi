package se.sundsvall.midalva.noteapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.exception.NoteApiExceptionHandler;
import se.sundsvall.midalva.noteapi.exception.NoteNotFoundException;
import se.sundsvall.midalva.noteapi.mapper.NoteMapper;
import se.sundsvall.midalva.noteapi.model.*;
import se.sundsvall.midalva.noteapi.repo.NoteHasTagRepository;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;
import se.sundsvall.midalva.noteapi.repo.TagRepository;
import se.sundsvall.midalva.noteapi.service.NoteService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GetNotesByTagController {

    @Autowired
    NoteService noteService;


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception e){
        return NoteApiExceptionHandler.handle(e);
    }


    @GetMapping
    @RequestMapping(path="/note/tag/{tag}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<NoteDTO> getNote(@PathVariable("tag") String tag) {
       return noteService.findNotesByTag(tag);
    }


}
