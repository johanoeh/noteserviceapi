package se.sundsvall.midalva.noteapi.model;

import java.util.ArrayList;
import java.util.List;

public class Note {

    private long id;

    private String format;
    private String name;
    private List<String> tags;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
