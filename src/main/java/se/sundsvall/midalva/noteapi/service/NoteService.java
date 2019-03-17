package se.sundsvall.midalva.noteapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import se.sundsvall.midalva.noteapi.exception.NoteNotFoundException;
import se.sundsvall.midalva.noteapi.mapper.NoteMapper;
import se.sundsvall.midalva.noteapi.model.Note;
import se.sundsvall.midalva.noteapi.model.NoteDTO;
import se.sundsvall.midalva.noteapi.model.NoteHasTag;
import se.sundsvall.midalva.noteapi.model.Tag;
import se.sundsvall.midalva.noteapi.repo.NoteHasTagRepository;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;
import se.sundsvall.midalva.noteapi.repo.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService  {

    private NoteRepository noteRepository;
    private TagRepository tagRepository;
    private NoteHasTagRepository hasTagRepository;

    private static final Logger LOG = LoggerFactory.getLogger(NoteService.class);


    @Autowired
    public NoteService( NoteRepository noteRepository, TagRepository tagRepository, NoteHasTagRepository hasTagRepository) {

        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
        this.hasTagRepository = hasTagRepository;
    }


    public void save(NoteDTO noteDTO){

        Note note = NoteMapper.map(noteDTO);

        noteRepository.save(note);

        noteDTO.getTags().forEach(t->{


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

    public List<NoteDTO> findNotesByTag(String tag) {

        List<NoteDTO> noteDTOs = new ArrayList<>();

        Tag t = tagRepository.findByTag(tag);
        List<NoteHasTag> byTag = hasTagRepository.findByTagTagId(t.getTagId());

        if(byTag.isEmpty()){

            throw  new NoteNotFoundException("Couldn't find any Note tagged with: '"+tag+"'");
        }

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
