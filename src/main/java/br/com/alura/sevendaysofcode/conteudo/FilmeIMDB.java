/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.sevendaysofcode.conteudo;

import java.util.Objects;

/**
 *
 * @author VantaStrix88
 */
public final class FilmeIMDB implements Conteudo {
    
    private final String titulo;
    private final String posterURL;
    private final String rating;
    private final String ano;

    public FilmeIMDB(String titulo, String posterURL, String rating, String ano) {
        this.titulo = titulo;
        this.posterURL = posterURL;
        this.rating = rating;
        this.ano = ano;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String getPosterURL() {
        return posterURL;
    }

    @Override
    public String getRating() {
        return rating;
    }

    @Override
    public String getAno() {
        return ano;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.titulo);
        hash = 89 * hash + Objects.hashCode(this.posterURL);
        hash = 89 * hash + Objects.hashCode(this.rating);
        hash = 89 * hash + Objects.hashCode(this.ano);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FilmeIMDB other = (FilmeIMDB) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.posterURL, other.posterURL)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        return Objects.equals(this.ano, other.ano);
    }
    
}
