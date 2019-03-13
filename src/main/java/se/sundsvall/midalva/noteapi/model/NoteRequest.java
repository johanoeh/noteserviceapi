package se.sundsvall.midalva.noteapi.model;

import javax.persistence.*;
import java.util.List;

public class NoteRequest {


    private Long noteId;

    private String format;
    private String name;

    private List<String> tags;
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
        return String.format("Note[ noteId=%s, name=%s, tags=%s, format=%s, content=%s ]", noteId, name, tagStr, format,content);
    }
}
