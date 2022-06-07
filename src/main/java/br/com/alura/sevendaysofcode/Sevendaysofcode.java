/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package br.com.alura.sevendaysofcode;

/**
 *
 * @author VantaStrix88
 */
import br.com.alura.sevendaysofcode.api.IMDbAPIClient;
import br.com.alura.sevendaysofcode.api.MarvelAPIClient;
import java.util.List;
import br.com.alura.sevendaysofcode.conteudo.Conteudo;
import br.com.alura.sevendaysofcode.conteudo.FilmeIMDB;
import br.com.alura.sevendaysofcode.conteudo.MarvelSeries;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sevendaysofcode {

    public static void main(String[] args) {
        String imdbBody = IMDbAPIClient.getInstance().getResponseBody("https://imdb-api.com/en/API/Top250Movies/");
        List<FilmeIMDB> filmes = IMDbJsonParser.getInstance().parse(imdbBody);
        try (PrintWriter writer = new PrintWriter("filmesimdb.html", "utf-8")) {
            HTMLGenerator generator = new HTMLGenerator(writer);
            generator.generate(filmes);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Sevendaysofcode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String marvelBody = MarvelAPIClient.getInstance().getResponseBody("https://gateway.marvel.com/v1/public/series?");
        List<MarvelSeries> series = MarvelJsonParser.getInstance().parse(marvelBody);
        try (PrintWriter writer = new PrintWriter("marvelseries.html", "utf-8")) {
            HTMLGenerator generator = new HTMLGenerator(writer);
            generator.generate(series);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Sevendaysofcode.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
