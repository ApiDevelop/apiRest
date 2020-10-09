package com.example.apiRest.dto;


import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class FilmsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Field is string")
    @NotBlank(message = "Field name can not be blank")
    @Length(min = 3, max = 50, message = "The field name must have between 3 and 50 character ")
    private String name;

    @ApiModelProperty(value = "Field is string")
    @NotBlank(message = "Field genre can not be blank")
    private String genre;

    @ApiModelProperty(value = "Field is Int")

    @Column(name = "ano_de_lancamento")
    @NotNull(message = "Field year can not be null")
    @Range(min = 1900, max = 2025, message = "Field year should be between 1900 and 2025")
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
        this.name = name.toLowerCase();
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

    @Override
    public String toString() {
        return "FilmsDTO [id=" + ", nome=" + name + ", genre=" + genre
                + ", year=" + year + "]";
    }

}
