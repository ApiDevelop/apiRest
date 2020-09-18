package com.example.apiRest.service;

import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.model.Films;
import com.example.apiRest.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FilmsService {

    @Autowired
    private FilmsRepository filmsRepository;

    public List<Films> getAllFilms() {
        return filmsRepository.findAll();

    }

    public Films saveFilms(FilmsDTO filmsDTO){
        Films films = new Films();
        films.setId(filmsDTO.getId());
        films.setNome(filmsDTO.getNome());
        films.setGenero(filmsDTO.getGenero());
        films.setAno(filmsDTO.getAno());

        return filmsRepository.save(films);
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
