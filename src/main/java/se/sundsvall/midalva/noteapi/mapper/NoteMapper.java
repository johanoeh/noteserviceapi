package se.sundsvall.midalva.noteapi.mapper;

import se.sundsvall.midalva.noteapi.model.db.NoteEntity;
import se.sundsvall.midalva.noteapi.model.dto.Note;

import java.util.List;

public class NoteMapper {

    public static Note map(NoteEntity noteEntity, List<String> tags) {

        Note note = new Note();
        note.setNoteId(noteEntity.getNoteId());
        note.setContent(noteEntity.getContent());
        note.setFormat(noteEntity.getFormat());
        note.setName(noteEntity.getName());
        note.getTags().addAll(tags);

        return note;

    }


    public static NoteEntity map(Note note){

        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setName(note.getName());
        noteEntity.setFormat(note.getFormat());
        noteEntity.setContent(note.getContent());
        return noteEntity;
    }


}
