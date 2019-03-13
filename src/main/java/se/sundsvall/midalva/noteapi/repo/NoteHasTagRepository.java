package se.sundsvall.midalva.noteapi.repo;

import org.springframework.data.repository.CrudRepository;
import se.sundsvall.midalva.noteapi.model.NoteHasTag;

import java.util.List;

public interface NoteHasTagRepository extends CrudRepository<NoteHasTag,Long> {

    public List<NoteHasTag> findByNoteNoteId(Long noteId);
    public List<NoteHasTag> findByTagTagId(Long tagId);
}
