package se.sundsvall.midalva.noteapi.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.model.dto.ErrorDetails;
import se.sundsvall.midalva.noteapi.model.dto.Note;
import se.sundsvall.midalva.noteapi.service.NoteService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
@RequestMapping("/note")
@Api(tags = "note", description = "Manages notes")
public class NoteController {

    public static final String notes ="Add a note to the collection of notes";


    @Autowired
    NoteService noteService;

    private  final Logger LOG =  LoggerFactory.getLogger(NoteController.class);

    @ApiOperation(value = "add a note",notes = notes)

    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",response = Note.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetails.class),
            @ApiResponse(code = 500, message = "Internal error", response = ErrorDetails.class)
    })

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  void addNote(@RequestBody Note note){
        noteService.save(note);
        LOG.info(note.toString());

    }

}
