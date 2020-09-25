package convert;

import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.dto.FilmsDTOResponse;
import com.example.apiRest.model.Films;

public class ConvertFilms {



    public static Films converterFilmsDTOInFilms(FilmsDTO filmsDTO) {

        Films films = new Films();

        films.setId(filmsDTO.getId());
        films.setNome(filmsDTO.getNome());
        films.setGenero(filmsDTO.getGenero());
        films.setAno(filmsDTO.getAno());

        return films;
    }

    public static FilmsDTOResponse converterFilmsInfilmsDTOResponse(Films films){

        FilmsDTOResponse filmsDTOResponse = new FilmsDTOResponse();

        filmsDTOResponse.setId(films.getId());
        filmsDTOResponse.setNome(films.getNome());
        filmsDTOResponse.setGenero(films.getGenero());
        filmsDTOResponse.setAno(films.getAno());

        return filmsDTOResponse;

    }


}
