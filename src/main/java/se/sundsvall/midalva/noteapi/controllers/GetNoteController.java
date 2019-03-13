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

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GetNoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    TagRepository tagRepository;
    @Autowired
    NoteHasTagRepository hasTagRepository;

    @GetMapping
    @RequestMapping(path = "/note/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public NoteDTO getNote(@PathVariable("id") Long id) {

        Optional<Note> noteOptional = noteRepository.findById(id);
        NoteDTO noteDTO = null;

        if (noteOptional.isPresent()) {

            Note note = noteOptional.get();
            List<String> tags = new ArrayList<>();
            List<NoteHasTag> byNoteId = hasTagRepository.findByNoteNoteId(note.getNoteId());
            byNoteId.forEach(t -> {
                tags.add(t.getTag().getTag());
            });

            noteDTO = NoteMapper.map(note,tags);



        }
        return noteDTO;
    }


}
