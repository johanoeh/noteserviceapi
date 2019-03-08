package se.sundsvall.midalva.noteapi.model;

import java.util.ArrayList;
import java.util.List;

public class Note {

    private long id;
    private String content;
    private String name;
    private List<String> tags;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public List<String> getTags() {
        if (tags == null)
            tags = new ArrayList<>();
        return tags;
    }

    public void setName(String name) {
        this.name = name;
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
        return String.format("Note[ id=%s, name=%s, tags=%s, content=%s ]", id, name, tagStr, content);
    }
}
