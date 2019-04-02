package se.sundsvall.midalva.noteapi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.sundsvall.midalva.noteapi.exception.NoteNotFoundException;
import se.sundsvall.midalva.noteapi.mapper.NoteMapper;
import se.sundsvall.midalva.noteapi.model.db.NoteEntity;
import se.sundsvall.midalva.noteapi.model.dto.Note;
import se.sundsvall.midalva.noteapi.model.db.NoteHasTagEntity;
import se.sundsvall.midalva.noteapi.model.db.TagEntity;
import se.sundsvall.midalva.noteapi.repo.NoteHasTagRepository;
import se.sundsvall.midalva.noteapi.repo.NoteRepository;
import se.sundsvall.midalva.noteapi.repo.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private NoteRepository noteRepository;
    private TagRepository tagRepository;
    private NoteHasTagRepository hasTagRepository;

    private static final Logger LOG = LoggerFactory.getLogger(NoteService.class);


    @Autowired
    public NoteService(NoteRepository noteRepository, TagRepository tagRepository, NoteHasTagRepository hasTagRepository) {

        this.noteRepository = noteRepository;
        this.tagRepository = tagRepository;
        this.hasTagRepository = hasTagRepository;
    }


    public void save(Note note) {

        NoteEntity noteEntity = NoteMapper.map(note);

        noteRepository.save(noteEntity);

        note.getTags().forEach(t -> {


            TagEntity tmpTag = tagRepository.findByTag(t);

            if (tmpTag == null) {
                TagEntity tag = new TagEntity();
                tag.setTag(t);
                tagRepository.save(tag);
            }


            tmpTag = tagRepository.findByTag(t);

            NoteHasTagEntity hasTag = new NoteHasTagEntity();
            hasTag.setTagEntity(tmpTag);
            hasTag.setNoteEntity(noteEntity);
            hasTagRepository.save(hasTag);

        });

        LOG.info(noteEntity.toString());

    }

    public List<Note> findNotesByTag(String tag) {

        List<Note> notes = new ArrayList<>();

        TagEntity t = tagRepository.findByTag(tag);
        List<NoteHasTagEntity> byTag = hasTagRepository.findAllByTagEntityTagId(t.getTagId());

        if (byTag.isEmpty()) {

            throw new NoteNotFoundException("Couldn't find any NoteEntity tagged with: '" + tag + "'");
        }

        byTag.forEach(fTag -> {

            Long noteId = fTag.getNoteEntity().getNoteId();
            List<NoteHasTagEntity> hasTags = hasTagRepository.findAllByNoteEntityNoteId(noteId);
            List<String> tags = new ArrayList<>();

            hasTags.forEach(hasTag -> {
                tags.add(hasTag.getTagEntity().getTag());
            });

            notes.add(NoteMapper.map(fTag.getNoteEntity(), tags));

        });

        return notes;
    }

    public Note getNote(Long id) {

        Optional<NoteEntity> noteOptional = noteRepository.findById(id);
        Note note = null;

        if (!noteOptional.isPresent()) {
            throw new NoteNotFoundException("Couldn't find note with id: " + id);
        }

        if (noteOptional.isPresent()) {

            NoteEntity noteEntity = noteOptional.get();
            List<String> tags = new ArrayList<>();
            List<NoteHasTagEntity> byNoteId = hasTagRepository.findAllByNoteEntityNoteId(noteEntity.getNoteId());
            if (byNoteId != null) {
                byNoteId.forEach(t -> {
                    tags.add(t.getTagEntity().getTag());
                });
            }

            note = NoteMapper.map(noteEntity, tags);

        }
        return note;
    }


}
