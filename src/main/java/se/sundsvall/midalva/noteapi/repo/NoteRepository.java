package se.sundsvall.midalva.noteapi.repo;

import org.springframework.data.repository.CrudRepository;
import se.sundsvall.midalva.noteapi.model.Note;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note,Long> {
}
