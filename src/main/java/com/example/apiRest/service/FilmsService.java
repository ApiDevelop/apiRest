package com.example.apiRest.service;

import com.example.apiRest.dto.DetailsFilmsDTOResponse;
import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.dto.FilmsDTOResponse;
import com.example.apiRest.model.Films;
import com.example.apiRest.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static convert.ConvertFilms.*;

@Service
public class FilmsService {

    @Autowired
    private FilmsRepository filmsRepository;

    public List<DetailsFilmsDTOResponse> getAllFilms() {
        return converterListOfFilmsInOneListOfFilmsDTO(filmsRepository.findAll());
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
