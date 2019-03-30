package se.sundsvall.midalva.model;

import org.junit.Assert;
import org.junit.Test;
import se.sundsvall.midalva.noteapi.model.db.NoteEntity;

public class NoteTest {

    private static  final String NAME ="NAME";
    private static final String FORMAT="FORMAT";
    private static final String CONTENT ="CONTENT";
    private static final Long ID =1L;

    @Test
    public void testSetName() {

        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setNoteId(ID);
        noteEntity.setName(NAME);
        noteEntity.setFormat(FORMAT);
        noteEntity.setContent(CONTENT);

        Assert.assertEquals(NAME, noteEntity.getName());
        Assert.assertEquals(FORMAT, noteEntity.getFormat());
        Assert.assertEquals(CONTENT, noteEntity.getContent());
        Assert.assertEquals(ID, noteEntity.getNoteId());

    }
}
