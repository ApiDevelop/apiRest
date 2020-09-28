package com.example.apiRest.dto;

import com.example.apiRest.model.Films;

public class DetailsFilmsDTOResponse {

    private Long id;
    private String nome;
    private String genero;
    private int ano;

    public DetailsFilmsDTOResponse(Films film) {
        this.id = film.getId();
        this.nome = film.getName();
        this.genero = film.getGenre();
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
