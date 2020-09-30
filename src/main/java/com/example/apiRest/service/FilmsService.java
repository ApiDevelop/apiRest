package com.example.apiRest.service;

import com.example.apiRest.dto.DetailsFilmsDTOResponse;
import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.dto.FilmsDTOResponse;
import com.example.apiRest.model.Films;
import com.example.apiRest.repository.FilmsRepository;
import com.example.apiRest.service.exceptions.FilmsDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static convert.ConvertFilms.*;
import static convert.ConvertFilms.converterListOfFilmsInOneListOfFilmsDTO;

@Service
public class FilmsService {

    @Autowired
    private FilmsRepository filmsRepository;

    public List<DetailsFilmsDTOResponse> getAllFilms() {
        List<Films> films = filmsRepository.findAll();
        if (films.isEmpty()) {
            throw new FilmsDoesNotExistException("The list is empty. There are no films registered");
        }
        return converterListOfFilmsInOneListOfFilmsDTO(films);
    }

    public List<DetailsFilmsDTOResponse> getFilmByName(String nameFilm) {
        List<Films> films = (filmsRepository.findByName(nameFilm));
        if (films.isEmpty()) {
            throw new FilmsDoesNotExistException("There are no films that meet this search");
        }
        return converterListOfFilmsInOneListOfFilmsDTO(films);
    }

    public DetailsFilmsDTOResponse getFilmByID(long id) {
        return converterFilmInFilmDetails(filmsRepository.findById(id));
    }

    public FilmsDTOResponse createOneFilm(FilmsDTO filmsDTO){
        return converterFilmsInfilmsDTOResponse(filmsRepository.save(converterFilmsDTOInFilms(filmsDTO)));
    }

    public void deleteFilm(Films film) {
        filmsRepository.delete(film);
    }

    public Films updateDataFilm(Films film) {
        return filmsRepository.save(film);
    }

}
