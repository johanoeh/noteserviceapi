package se.sundsvall.midalva.noteapi.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "Note")
public class Note {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long noteId;
    private String format;
    private String name;
    private String content;

}
