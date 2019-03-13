package se.sundsvall.midalva.noteapi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.model.Note;
import se.sundsvall.midalva.noteapi.model.NoteHasTag;
import se.sundsvall.midalva.noteapi.model.NoteDTO;
import se.sundsvall.midalva.noteapi.model.Tag;
import se.sundsvall.midalva.noteapi.repo.NoteHasTagRepository;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;
import se.sundsvall.midalva.noteapi.repo.TagRepository;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    NoteHasTagRepository hasTagRepository;

    private  final Logger LOG =  LoggerFactory.getLogger(NoteController.class);

    @PostMapping
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  void addNote(@RequestBody NoteDTO note){
        handleRequest(note);

    }

    private void handleRequest(NoteDTO request){

        Note note = new Note();
        note.setName(request.getName());
        note.setFormat(request.getFormat());
        note.setContent(request.getContent());

        noteRepository.save(note);

        request.getTags().forEach(t->{


            Tag tmpTag = tagRepository.findByTag(t);

            if( tmpTag == null ){
                Tag tag= new Tag();
                tag.setTag(t);
                tagRepository.save(tag);
            }


            tmpTag = tagRepository.findByTag(t);


            NoteHasTag hasTag = new NoteHasTag();
            hasTag.setTag(tmpTag);
            hasTag.setNote(note);
            hasTagRepository.save(hasTag);

        });


        LOG.info(note.toString());


    }

}
