package se.sundsvall.midalva.noteapi.repo;

import org.springframework.data.repository.CrudRepository;
import se.sundsvall.midalva.noteapi.model.db.NoteHasTagEntity;

import java.util.List;

public interface NoteHasTagRepository extends CrudRepository<NoteHasTagEntity,Long> {

    public List<NoteHasTagEntity> findAllByNoteEntityNoteId(Long noteId);
    public List<NoteHasTagEntity> findAllByTagEntityTagId(Long tagId);
}
