package se.sundsvall.midalva.noteapi.mapper;

import se.sundsvall.midalva.noteapi.model.Note;
import se.sundsvall.midalva.noteapi.model.NoteDTO;

import java.util.List;

public class NoteMapper {

    public static NoteDTO map(Note note, List<String> tags) {

        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setNoteId(note.getNoteId());
        noteDTO.setContent(note.getContent());
        noteDTO.setFormat(note.getFormat());
        noteDTO.setName(note.getName());
        noteDTO.getTags().addAll(tags);

        return noteDTO;

    }
}