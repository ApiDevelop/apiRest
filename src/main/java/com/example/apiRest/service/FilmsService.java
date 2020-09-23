package com.example.apiRest.service;

import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.model.Films;
import com.example.apiRest.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static convert.ConvertFilms.converterFilmsInFilmsDTO;

@Service
public class FilmsService {

    Films films = new Films();

    @Autowired
    private FilmsRepository filmsRepository;

    public List<Films> getAllFilms() {
        return filmsRepository.findAll();

    }

    public Films createOneFilm(FilmsDTO filmsDTO){

        return filmsRepository.save(converterFilmsInFilmsDTO(filmsDTO));
    }



    public Films getFilmByID(long id) {
        return filmsRepository.findById(id);
    }

    public void deleteFilm(Films film) {
        filmsRepository.delete(film);
    }

    public Films updateDataFilm(Films film) {
        return filmsRepository.save(film);
    }
}
