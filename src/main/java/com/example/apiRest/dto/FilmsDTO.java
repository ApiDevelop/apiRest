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
import javax.validation.constraints.Size;
import java.io.Serializable;

public class FilmsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Field is string")
    @NotBlank(message = "Field name can not be blank")
    @Length(min = 3,max = 50,message = "The field name must have between 3 and 50 character ")
    private String nome;

    @ApiModelProperty(value = "Field is string")
    @NotBlank(message = "Field genre can not be blank")
    private String genero;

    @ApiModelProperty(value = "Field is Int")

    @Column(name = "ano_de_lancamento")
    @NotNull(message = "Field year can not be null")
    @Range(min = 1900, max = 2025, message = "Field year should be between 1900 and 2025")
    private int ano;

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
    @Override
    public String toString() {
        return "FilmsDTO [id=" + ", nome=" + nome+ ", genre=" + genero
                + ", year=" + ano +  "]";
    }

}
