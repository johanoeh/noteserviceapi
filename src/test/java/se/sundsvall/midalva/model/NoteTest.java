package se.sundsvall.midalva.model;

import org.junit.Assert;
import org.junit.Test;
import se.sundsvall.midalva.noteapi.model.Note;

public class NoteTest {

    private static  final String NAME ="NAME";
    private static final String FORMAT="FORMAT";
    private static final String CONTENT ="CONTENT";
    private static final Long ID =1L;

    @Test
    public void testSetName() {

        Note note = new Note();
        note.setNoteId(ID);
        note.setName(NAME);
        note.setFormat(FORMAT);
        note.setContent(CONTENT);

        Assert.assertEquals(NAME, note.getName());
        Assert.assertEquals(FORMAT,note.getFormat());
        Assert.assertEquals(CONTENT,note.getContent());
        Assert.assertEquals(ID, note.getNoteId());


    }
}
