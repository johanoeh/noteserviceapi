package se.sundsvall.midalva.noteapi.model.db;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "note")
public class NoteEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long noteId;
    private String format;
    private String name;
    private String content;

}
