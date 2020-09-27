package com.example.apiRest.controller;

import com.example.apiRest.dto.DetailsFilmsDTOResponse;
import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.dto.FilmsDTOResponse;
import com.example.apiRest.model.Films;
import com.example.apiRest.response.Response;
import com.example.apiRest.service.FilmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "API REST Films")
@CrossOrigin(origins = "*")
public class FilmsController {

    @Autowired
    FilmsService filmsService;

    @GetMapping("/films")
    @ApiOperation(value = "Return a list of films")
    @ResponseStatus(HttpStatus.OK)
    public List<DetailsFilmsDTOResponse> list(){
        return filmsService.getAllFilms();
    }

    @GetMapping("/films/{id}")
    @ApiOperation(value = "Return just one film")
    @ResponseStatus(HttpStatus.OK)
    public DetailsFilmsDTOResponse getOneFilms(@PathVariable(value = "id")long id){
        return filmsService.getFilmByID(id);
    }

    @PostMapping("/films")
    @ApiOperation(value = "Include a new film")
    public ResponseEntity<Response<FilmsDTOResponse>> registerOneFilms(@RequestBody @Valid FilmsDTO filmsDTO, BindingResult result){

        Response <FilmsDTOResponse> response = new Response <FilmsDTOResponse>();
        FilmsDTOResponse filmsDTOResponse;

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);

        }

        filmsDTOResponse = filmsService.createOneFilm(filmsDTO);
        response.setData(filmsDTOResponse);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filmsDTOResponse.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);

    }

    @DeleteMapping("/films")
    @ApiOperation(value = "Delete one film")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOneFilms(@RequestBody Films film) {
        this.filmsService.deleteFilm(film);
    }

    @PutMapping("/films")
    @ApiOperation(value = "Update data of one film")
    @ResponseStatus(HttpStatus.CREATED)
    public Films updateFilm(@RequestBody Films film) {
        return filmsService.updateDataFilm(film);
    }
}
