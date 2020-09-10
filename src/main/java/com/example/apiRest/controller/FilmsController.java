package com.example.apiRest.controller;

import com.example.apiRest.model.Films;
import com.example.apiRest.repository.FilmsRepository;
import com.example.apiRest.sevice.FilmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@Api(value = "API REST Films")
@CrossOrigin(origins = "*")
public class FilmsController {

    @Autowired
    FilmsRepository filmsRepository;

    @Autowired
    FilmsService filmsService;

    @GetMapping("/films")
    @ApiOperation(value = "Return a list of films")
    public List<Films> list(){
        return filmsService.getAllFilms();
    }

    @GetMapping("/films/{id}")
    @ApiOperation(value = "Return just one film")
    public Films getOneFilms(@PathVariable(value = "id")long id){

        return filmsRepository.findById(id);
    }

    @PostMapping("/films")
    @ApiOperation(value = "Include a new film")
    public Films registerOneFilms(@RequestBody Films film){
        return filmsRepository.save(film);
    }

    @DeleteMapping("/films")
    @ApiOperation(value = "Delete one film")
    public void deleteOneFilms(@RequestBody Films film) {
        this.filmsRepository.delete(film);
    }

    @PutMapping("/films")
    @ApiOperation(value = "Update data of one film")
    public Films updateFilm(@RequestBody Films film) {
        return filmsRepository.save(film);
    }



}
