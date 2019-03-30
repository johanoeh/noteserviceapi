package se.sundsvall.midalva.noteapi.model.db;

import javax.persistence.*;

@Entity
@Table(name = "note_has_tag")
public class NoteHasTagEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name="noteId")
    NoteEntity noteEntity;

    @ManyToOne
    @JoinColumn(name="tagId")
    TagEntity tagEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NoteEntity getNoteEntity() {
        return noteEntity;
    }

    public void setNoteEntity(NoteEntity noteEntity) {
        this.noteEntity = noteEntity;
    }

    public TagEntity getTagEntity() {
        return tagEntity;
    }

    public void setTagEntity(TagEntity tagEntity) {
        this.tagEntity = tagEntity;
    }
}
