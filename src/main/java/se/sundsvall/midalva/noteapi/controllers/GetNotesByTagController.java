package se.sundsvall.midalva.noteapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.mapper.NoteMapper;
import se.sundsvall.midalva.noteapi.model.Note;
import se.sundsvall.midalva.noteapi.model.NoteDTO;
import se.sundsvall.midalva.noteapi.model.NoteHasTag;
import se.sundsvall.midalva.noteapi.model.Tag;
import se.sundsvall.midalva.noteapi.repo.NoteHasTagRepository;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;
import se.sundsvall.midalva.noteapi.repo.TagRepository;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GetNotesByTagController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    TagRepository tagRepository;
    @Autowired
    NoteHasTagRepository hasTagRepository;

    @GetMapping
    @RequestMapping(path="/note/tag/{tag}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<NoteDTO> getNote(@PathVariable("tag") String tag) {

        List<NoteDTO> noteDTOs = new ArrayList<>();

        List<Long> ids = new ArrayList<>();

        Tag t = tagRepository.findByTag(tag);
        List<NoteHasTag> byTag = hasTagRepository.findByTagTagId(t.getTagId());

        byTag.forEach(fTag->{

            Long noteId = fTag.getNote().getNoteId();
            List<NoteHasTag> hasTags = hasTagRepository.findByNoteNoteId(noteId);
            List<String> tags = new ArrayList<>();

            hasTags.forEach(hasTag->{
                tags.add(hasTag.getTag().getTag());
            });

           noteDTOs.add(NoteMapper.map(fTag.getNote(),tags));

        });




        return noteDTOs;
    }

}
