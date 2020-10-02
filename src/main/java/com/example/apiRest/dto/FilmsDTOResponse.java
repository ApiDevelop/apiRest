package com.example.apiRest.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


public class FilmsDTOResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    @Column(name = "ano_de_lancamento")
    private int year;


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
