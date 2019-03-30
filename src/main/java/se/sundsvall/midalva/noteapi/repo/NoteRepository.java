package se.sundsvall.midalva.noteapi.repo;

import org.springframework.data.repository.CrudRepository;
import se.sundsvall.midalva.noteapi.model.db.NoteEntity;

public interface NoteRepository extends CrudRepository<NoteEntity,Long> {
}
