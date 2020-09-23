package convert;

import com.example.apiRest.dto.FilmsDTO;
import com.example.apiRest.model.Films;

public class ConvertFilms {



    public static Films converterFilmsInFilmsDTO(FilmsDTO filmsDTO) {
        Films films = new Films();

        films.setId(filmsDTO.getId());
        films.setNome(filmsDTO.getNome());
        films.setGenero(filmsDTO.getGenero());
        films.setAno(filmsDTO.getAno());
        return films;
    }


}
