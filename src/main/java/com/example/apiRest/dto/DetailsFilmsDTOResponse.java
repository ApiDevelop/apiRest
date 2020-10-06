package com.example.apiRest.dto;

import com.example.apiRest.model.Films;

public class DetailsFilmsDTOResponse {

    private Long id;
    private String name;
    private String genre;
    private int year;

    public DetailsFilmsDTOResponse(Films film) {
        this.id = film.getId();
        this.name = film.getName();
        this.genre = film.getGenre();
        this.year = film.getYear();
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
