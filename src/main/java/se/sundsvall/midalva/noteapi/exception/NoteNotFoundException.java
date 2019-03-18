package se.sundsvall.midalva.noteapi.exception;


import org.springframework.http.HttpStatus;

public class NoteNotFoundException extends NoteApiException {

    public static final HttpStatus  RESPONSE_CODE = HttpStatus.BAD_REQUEST;

    public NoteNotFoundException(String msg) {
        super(msg);
    }
}
