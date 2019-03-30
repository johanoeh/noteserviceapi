package se.sundsvall.midalva.noteapi.model.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel
public class Note {

    private static final String CONTENT_EXAMPLE =

            "# Linux commands\n" +
            "\n" +
            "LIst  TCP connections with portnumbers\n" +
            "\n" +
            "```bash\n" +
            "$ sudo lsof -i -n -P | grep TCP | more\n" +
            "```";


    @ApiModelProperty(example = "2399")
    private Long noteId;
    @ApiModelProperty(example = "Linux how to list tcp connections")
    private String name;
    @ApiModelProperty(example = "md")
    private String format;
    @ApiModelProperty(example = CONTENT_EXAMPLE)
    private String content;
    @ApiModelProperty(example = "[\"Linux\", \"port\", \"connection\"]")
    private List<String> tags;

    public Note(String name, String format, String content, List<String> tags) {
        this.name = name;
        this.format = format;
        this.content = content;
        this.tags = tags;
    }

    public List<String> getTags() {
        if(tags == null) tags= new ArrayList<>();
        return tags;
    }

}
