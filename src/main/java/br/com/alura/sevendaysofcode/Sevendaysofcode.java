/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package br.com.alura.sevendaysofcode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.alura.sevendaysofcode.api.ImdbApiClient;
import br.com.alura.sevendaysofcode.api.MarvelApiClient;
import br.com.alura.sevendaysofcode.conteudo.FilmeImdb;
import br.com.alura.sevendaysofcode.conteudo.MarvelSeries;
import br.com.alura.sevendaysofcode.parser.jsonparser.ImdbJsonParser;
import br.com.alura.sevendaysofcode.parser.jsonparser.MarvelJsonParser;

/**
 *
 * @author VantaStrix88
 */
public class Sevendaysofcode {

    public static void main(String[] args) {
        String imdbBody = ImdbApiClient.getInstance().getResponseBody("https://imdb-api.com/en/API/Top250Movies/");
        List<FilmeImdb> filmes = ImdbJsonParser.getInstance().parse(imdbBody);
        try (PrintWriter writer = new PrintWriter("filmesimdb.html", "utf-8")) {
            HtmlGenerator generator = new HtmlGenerator(writer);
            generator.generate(filmes);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Sevendaysofcode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String marvelBody = MarvelApiClient.getInstance().getResponseBody("https://gateway.marvel.com/v1/public/series?");
        List<MarvelSeries> series = MarvelJsonParser.getInstance().parse(marvelBody);
        try (PrintWriter writer = new PrintWriter("marvelseries.html", "utf-8")) {
            HtmlGenerator generator = new HtmlGenerator(writer);
            generator.generate(series);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Sevendaysofcode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
