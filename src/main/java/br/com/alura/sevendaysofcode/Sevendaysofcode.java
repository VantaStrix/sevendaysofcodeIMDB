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
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_5cpmf1wr"))
                .GET()
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        //System.out.println(response.body());
        
        String body = response.body();
        String teste = response.body().substring(body.indexOf("[") + 1, body.indexOf("]")).replace("},{", "}={");
        //System.out.println(teste);
        String[] obras = teste.split("=");
        List<String> titulos = new ArrayList<>();
        List<String> anos = new ArrayList<>();
        List<String> notas = new ArrayList<>();
        List<String> imagens = new ArrayList<>();
        List<Filme> filmes = new ArrayList<>();
        int i = 0;
        for (String obra : obras) {
            //System.out.println(filme);
            
            /* titulos.add(obra.substring(obra.indexOf("\"title\"") + 9, obra.indexOf(",\"fullTitle\"") - 1));
            anos.add(obra.substring(obra.indexOf("\"year\"") + 8, obra.indexOf(",\"image\"") - 1));
            notas.add(obra.substring(obra.indexOf("\"imDbRating\"") + 14, obra.indexOf(",\"imDbRatingCount\"") - 1));
            imagens.add(obra.substring(obra.indexOf("\"image\"") + 9, obra.indexOf(",\"crew\"") - 1)); */

            String titulo = obra.substring(obra.indexOf("\"title\"") + 9, obra.indexOf(",\"fullTitle\"") - 1);
            String ano = obra.substring(obra.indexOf("\"year\"") + 8, obra.indexOf(",\"image\"") - 1);
            String nota = obra.substring(obra.indexOf("\"imDbRating\"") + 14, obra.indexOf(",\"imDbRatingCount\"") - 1);
            String posterURL = obra.substring(obra.indexOf("\"image\"") + 9, obra.indexOf(",\"crew\"") - 1);
            
            filmes.add(new Filme(titulo, posterURL, nota, ano));
            //System.out.println(obra.substring(obra.indexOf("\"image\"") + 9, obra.indexOf(",\"crew\"") - 1));
            //System.out.println("Título: " + titulos.get(titulos.size() - 1) + " - Ano: " + anos.get(anos.size() - 1) + " - Nota: " + notas.get(notas.size() - 1));
            //System.out.println(filmes.get(filmes.size() - 1).getTitulo());
        }
        
        try (PrintWriter writer = new PrintWriter("new.html", "utf-8")) {
            HTMLGenerator generator = new HTMLGenerator(writer);
            generator.generate(filmes);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(Sevendaysofcode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
