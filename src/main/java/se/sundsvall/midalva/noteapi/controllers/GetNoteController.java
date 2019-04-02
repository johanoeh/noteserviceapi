package se.sundsvall.midalva.noteapi.controllers;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import se.sundsvall.midalva.noteapi.model.dto.ErrorDetails;
import se.sundsvall.midalva.noteapi.model.dto.Note;
import se.sundsvall.midalva.noteapi.service.NoteService;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RestController
@Api(tags = "note", description = "Manages notes")
public class GetNoteController {


    @Autowired
    NoteService noteService;

    @ApiOperation(value = "get a note by note id", notes = "get a note by it's id")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Note.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetails.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDetails.class),
            @ApiResponse(code = 500, message = "Internal error", response = ErrorDetails.class)
    })

    @CrossOrigin(origins = "http://localhost:8089")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/note/{id}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody
    Note getNote(@ApiParam(value = "id", example = "1000", required = true) @PathVariable("id") Long id) {
        return noteService.getNote(id);
    }

}
