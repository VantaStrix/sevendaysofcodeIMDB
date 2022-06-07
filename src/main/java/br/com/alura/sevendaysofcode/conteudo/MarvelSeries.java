/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.sevendaysofcode.conteudo;

/**
 *
 * @author VantaStrix88
 */
public class MarvelSeries implements Conteudo {

    private final String titulo;
    private final String posterURL;
    private final String ano;
    private final String rating;

    public MarvelSeries(String titulo, String posterURL, String rating, String ano) {
        this.titulo = titulo;
        this.posterURL = posterURL;
        this.ano = ano;
        this.rating = rating;
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

}
