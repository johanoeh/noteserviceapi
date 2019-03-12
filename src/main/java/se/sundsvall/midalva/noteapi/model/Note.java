package se.sundsvall.midalva.noteapi.model;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "Note")
public class Note {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String format;
    private String name;

    @ElementCollection
    private List<String> tags;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
         String tagStr="";
        if (tags != null) {
            sb.append("[");
            tags.forEach(tag -> sb.append(tag).append(","));
            tagStr = sb.substring(0,sb.lastIndexOf(","))+"]";
        }
        return String.format("Note[ id=%s, name=%s, tags=%s, format=%s, content=%s ]", id, name, tagStr, format,content);
    }

}
