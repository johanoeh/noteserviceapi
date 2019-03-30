package se.sundsvall.midalva.noteapi.model.db;

import javax.persistence.*;

@Entity
@Table(name = "tagEntity")
public class TagEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long tagId;

    @Column(name="tagEntity", unique=true)
    private String tag;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
