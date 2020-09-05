package com.example.apiRest.controller;

import com.example.apiRest.model.Films;
import com.example.apiRest.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class FilmsController {

    @Autowired
    FilmsRepository filmsRepository;

    @GetMapping("/films")
    public List<Films> getAllFilms(){
        return filmsRepository.findAll();
    }

    @GetMapping("/films/{id}")
    public Films getOneFilms(@PathVariable(value = "id")long id){
        return filmsRepository.findById(id);
    }

    @PostMapping("/films")
    public Films registerOneFilms(@RequestBody Films film ){
        return filmsRepository.save(film);
    }
}
