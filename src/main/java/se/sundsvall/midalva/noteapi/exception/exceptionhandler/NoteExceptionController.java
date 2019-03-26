package se.sundsvall.midalva.noteapi.exception.exceptionhandler;

import lombok.EqualsAndHashCode;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import se.sundsvall.midalva.noteapi.exception.NoteNotFoundException;
import se.sundsvall.midalva.noteapi.model.ErrorDetails;
import java.util.Date;



/**
 * Adds centralized controll over exceptions
 * To get and check more
 */
@ControllerAdvice
public class NoteExceptionController {

    @ExceptionHandler(value = NoteNotFoundException.class)
    public ResponseEntity<ErrorDetails> exception(NoteNotFoundException ex){
        return create("Failed",ex.getMessage(), NoteNotFoundException.RESPONSE_CODE);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDetails> exception(Exception ex){
        return create("Failed", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public static final ResponseEntity<ErrorDetails> create(String result, String message, HttpStatus status){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), result,message);
        ResponseEntity<ErrorDetails> responseEntity = new ResponseEntity<>(errorDetails,status);
        return responseEntity;
    }
}
