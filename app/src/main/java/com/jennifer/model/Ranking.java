package com.jennifer.model;

/**
 * Created by Alex on 17/01/2016.
 */
public class Ranking {
    private String titulo;
    private int imagen;

    public Ranking(String titulo, int imagen) {
        this.setTitulo(titulo);
        this.setImagen(imagen);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
