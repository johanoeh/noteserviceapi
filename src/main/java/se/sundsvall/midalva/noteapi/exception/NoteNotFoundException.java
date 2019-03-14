package se.sundsvall.midalva.noteapi.exception;

public class NoteNotFoundException extends NoteApiException {

    public NoteNotFoundException(String msg) {
        super(msg);
    }
}
