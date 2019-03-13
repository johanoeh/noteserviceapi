package se.sundsvall.midalva.noteapi.repo;

import org.springframework.data.repository.CrudRepository;
import se.sundsvall.midalva.noteapi.model.NoteHasTag;

public interface NoteHasTagRepository extends CrudRepository<NoteHasTag,Long> {

}
