package se.sundsvall.midalva.noteapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.sundsvall.midalva.noteapi.model.ErrorDetails;

import java.util.Date;

public class NoteApiExceptionHandler {

    public static final  ResponseEntity<ErrorDetails> handle(Exception e){

        if(e instanceof  NoteNotFoundException){
            return create("Not found",e.getMessage(),HttpStatus.NOT_FOUND);
        }
        return create("Unexpected error",e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

    }

    public static final ResponseEntity<ErrorDetails> create(String result, String message, HttpStatus status){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), result,message);
        ResponseEntity<ErrorDetails> responseEntity = new ResponseEntity<>(errorDetails,status);
        return responseEntity;

    }
}
