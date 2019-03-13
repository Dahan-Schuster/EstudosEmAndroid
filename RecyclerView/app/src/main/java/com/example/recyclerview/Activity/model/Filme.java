package com.example.recyclerview.Activity.model;

public class Filme {

    private String titulo;
    private String genero;
    private String ano;

    public Filme(String titulo, String genero, String ano) {
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getAno() {
        return ano;
    }
}
