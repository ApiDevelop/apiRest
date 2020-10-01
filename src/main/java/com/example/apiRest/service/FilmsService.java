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


@Service
public class FilmsService {

    @Autowired
    private FilmsRepository filmsRepository;

    private List<Films> films;

    public List<DetailsFilmsDTOResponse> getAllFilms() {
        films = filmsRepository.findAll();
        if (films.isEmpty()) {
            throw new FilmsDoesNotExistException("The list is empty. There are no films registered");
        }
        return converterListOfFilmsInOneListOfFilmsDTO(films);
    }

    public List<DetailsFilmsDTOResponse> getFilmByName(String nameFilm) {
        films = filmsRepository.findByName(nameFilm);
        if (films.isEmpty()) {
            throw new FilmsDoesNotExistException("There are no films that meet this search");
        }
        return converterListOfFilmsInOneListOfFilmsDTO(films);
    }

    public DetailsFilmsDTOResponse getFilmByID(long id) {
        Films film = filmsRepository.findById(id);
        if (film == null){
            throw new NullPointerException("There are no films registered with this ID");
        }
        return converterFilmInFilmDetails(film);
    }

    public FilmsDTOResponse createOneFilm(FilmsDTO filmsDTO) {
        List<Films> films = filmsRepository.findByName(filmsDTO.getNome());
        for (Films film : films) {
            if (!film.getName().isEmpty()) {
                throw new NullPointerException("There");
            } else {
                filmsDTO.getNome().equalsIgnoreCase(film.getName());
            }
            //System.out.println(film.getName());
        }
        return converterFilmsInfilmsDTOResponse(filmsRepository.save(converterFilmsDTOInFilms(filmsDTO)));

    }


    public void deleteFilm(Films film) {
        filmsRepository.delete(film);
    }

    public Films updateDataFilm(Films film) {
        return filmsRepository.save(film);
    }

}
