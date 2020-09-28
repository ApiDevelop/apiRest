package convert;

import com.example.apiRest.dto.DetailsFilmsDTOResponse;
import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.dto.FilmsDTOResponse;
import com.example.apiRest.model.Films;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<DetailsFilmsDTOResponse> converterListOfFilmsInOneListOfFilmsDTO(List<Films> films) {
        return films.stream().map(DetailsFilmsDTOResponse::new).collect(Collectors.toList());
    }

    public static DetailsFilmsDTOResponse converterFilmInFilmDetails(Films film) {
        DetailsFilmsDTOResponse detailsFilmsDTOResponse = new DetailsFilmsDTOResponse();
        detailsFilmsDTOResponse.setId(film.getId());
        detailsFilmsDTOResponse.setAno(film.getYear());
        detailsFilmsDTOResponse.setGenero(film.getGenre());
        detailsFilmsDTOResponse.setNome(film.getName());
        return detailsFilmsDTOResponse;
    }

}
