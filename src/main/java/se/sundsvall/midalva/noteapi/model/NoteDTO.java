package se.sundsvall.midalva.noteapi.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class NoteDTO {


    private Long noteId;
    private String name;
    private String format;
    private String content;
    private List<String> tags;

    public NoteDTO(String name, String format, String content, List<String> tags) {
        this.name = name;
        this.format = format;
        this.content = content;
        this.tags = tags;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();
        String tagStr = "";
        if (tags != null) {
            sb.append("[");
            tags.forEach(tag -> sb.append(tag).append(","));
            tagStr = sb.substring(0, sb.lastIndexOf(",")) + "]";
        }
        return String.format("Note[ noteId=%s, name=%s, tags=%s, format=%s, content=%s ]", noteId, name, tagStr, format, content);
    }
}
