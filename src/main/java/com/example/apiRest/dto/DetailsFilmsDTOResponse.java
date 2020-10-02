package com.example.apiRest.dto;

import com.example.apiRest.model.Films;

public class DetailsFilmsDTOResponse {

    private Long id;
    private String name;
    private String genre;
    private int ano;

    public DetailsFilmsDTOResponse(Films film) {
        this.id = film.getId();
        this.name = film.getName();
        this.genre = film.getGenre();
        this.ano = film.getYear();
    }

    public DetailsFilmsDTOResponse() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
