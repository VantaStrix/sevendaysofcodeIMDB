/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package br.com.alura.sevendaysofcode;

/**
 *
 * @author VantaStrix88
 */

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;
import java.util.List;
import br.com.alura.sevendaysofcode.Filme;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

public class Sevendaysofcode {

    public static void main(String[] args) {
        //System.out.println(response.body());
        
        //String body = response.body();
        String body = IMDBApiClient.getResponse("https://imdb-api.com/en/API/Top250Movies/k_5cpmf1wr");
        List<Filme> filmes = IMDBJsonParser.parse(body);
        
        try (PrintWriter writer = new PrintWriter("filmes.html", "utf-8")) {
            HTMLGenerator generator = new HTMLGenerator(writer);
            generator.generate(filmes);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Sevendaysofcode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
