package se.sundsvall.midalva.noteapi.model;

import javax.persistence.*;

@Entity
@Table(name = "note_has_tag")
public class NoteHasTag {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name="noteId")
    Note note;

    @ManyToOne
    @JoinColumn(name="tagId")
    Tag tag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
