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
import java.util.List;

@RestController
@Api(tags = "note", description = "Manages notes")
public class GetNotesByTagController {

    @Autowired
    NoteService noteService;


    @ApiOperation(value = "get a list of notes",notes = "Gets a list of notes based on the notes tag")

    @ApiResponses({
            @ApiResponse(code = 200, message = "Success",response = Note.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorDetails.class),
            @ApiResponse(code = 404, message = "Not found", response = ErrorDetails.class),
            @ApiResponse(code = 500, message = "Internal error", response = ErrorDetails.class)
    })

    //@CrossOrigin(origins = "http://localhost:8080")
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/note/tag/{tag}", method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public @ResponseBody List<Note> getNote(@ApiParam(value = "tag", example = "UML",required = true) @PathVariable("tag") String tag) {
       return noteService.findNotesByTag(tag);
    }


}
