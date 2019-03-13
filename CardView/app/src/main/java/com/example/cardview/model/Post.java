package com.example.cardview.model;

import android.media.Image;

public class Post {

    private String usuario;
    private String tempo;
    private int imagem;
    private String legenda;

    public Post(String usuario, String tempo, int imagem, String legenda) {
        this.usuario = usuario;
        this.tempo = tempo;
        this.imagem = imagem;
        this.legenda = legenda;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getTempo() {
        return tempo;
    }

    public int getImagem() { return imagem; }

    public String getLegenda() {
        return legenda;
    }
}
