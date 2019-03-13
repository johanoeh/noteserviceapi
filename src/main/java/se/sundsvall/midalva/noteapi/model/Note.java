package se.sundsvall.midalva.noteapi.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Note")
public class Note {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long noteId;

    private String format;
    private String name;


    private String content;

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Note[ noteId=%s, name=%s, format=%s, content=%s ]", noteId, name, format,content);
    }

}
