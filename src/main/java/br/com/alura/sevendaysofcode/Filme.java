/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.sevendaysofcode;

import java.util.Objects;

/**
 *
 * @author VantaStrix88
 */
public final class Filme {
    
    private final String titulo;
    private final String posterURL;
    private final String nota;
    private final String ano;

    public Filme(String titulo, String posterURL, String nota, String ano) {
        this.titulo = titulo;
        this.posterURL = posterURL;
        this.nota = nota;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public String getNota() {
        return nota;
    }

    public String getAno() {
        return ano;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.titulo);
        hash = 89 * hash + Objects.hashCode(this.posterURL);
        hash = 89 * hash + Objects.hashCode(this.nota);
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
        final Filme other = (Filme) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.posterURL, other.posterURL)) {
            return false;
        }
        if (!Objects.equals(this.nota, other.nota)) {
            return false;
        }
        return Objects.equals(this.ano, other.ano);
    }
    
}
