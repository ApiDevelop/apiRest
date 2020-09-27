package convert;

import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.dto.FilmsDTOResponse;
import com.example.apiRest.model.Films;

public class ConvertFilms {



    public static Films converterFilmsDTOInFilms(FilmsDTO filmsDTO) {

        Films films = new Films();

        films.setId(filmsDTO.getId());
        films.setName(filmsDTO.getNome());
        films.setGenre(filmsDTO.getGenero());
        films.setYear(filmsDTO.getAno());

        return films;
    }

    public static FilmsDTOResponse converterFilmsInfilmsDTOResponse(Films films){

        FilmsDTOResponse filmsDTOResponse = new FilmsDTOResponse();

        filmsDTOResponse.setId(films.getId());
        filmsDTOResponse.setNome(films.getName());
        filmsDTOResponse.setGenero(films.getGenre());
        filmsDTOResponse.setAno(films.getYear());

        return filmsDTOResponse;

    }


}
