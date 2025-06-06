package org.example.model;

public abstract class Livro {
    protected String titulo;
    protected String autor;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String toString() {
        return getClass().getSimpleName() + " - Título: " + titulo + ", Autor: " + autor;
    }
}