package convert;

import com.example.apiRest.dto.DetailsFilmsDTOResponse;
import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.dto.FilmsDTOResponse;
import com.example.apiRest.model.Films;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertFilms {

    private ConvertFilms() {
    }

    public static Films converterFilmsDTOInFilms(FilmsDTO filmsDTO) {
        Films films = new Films();
        films.setId(filmsDTO.getId());
        films.setName(filmsDTO.getName());
        films.setGenre(filmsDTO.getGenre());
        films.setYear(filmsDTO.getYear());
        return films;
    }

    public static FilmsDTOResponse converterFilmsInfilmsDTOResponse(Films films){
        FilmsDTOResponse filmsDTOResponse = new FilmsDTOResponse();
        filmsDTOResponse.setId(films.getId());
        filmsDTOResponse.setName(films.getName());
        filmsDTOResponse.setGenre(films.getGenre());
        filmsDTOResponse.setYear(films.getYear());
        return filmsDTOResponse;
    }

    public static List<DetailsFilmsDTOResponse> converterListOfFilmsInOneListOfFilmsDTO(List<Films> films) {
        return films.stream().map(DetailsFilmsDTOResponse::new).collect(Collectors.toList());
    }

    public static DetailsFilmsDTOResponse converterFilmInFilmDetails(Films film) {
        DetailsFilmsDTOResponse detailsFilmsDTOResponse = new DetailsFilmsDTOResponse();
        detailsFilmsDTOResponse.setId(film.getId());
        detailsFilmsDTOResponse.setAno(film.getYear());
        detailsFilmsDTOResponse.setGenre(film.getGenre());
        detailsFilmsDTOResponse.setName(film.getName());
        return detailsFilmsDTOResponse;
    }

}
