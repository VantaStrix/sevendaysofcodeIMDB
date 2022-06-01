/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.sevendaysofcode;

import java.util.List;
import br.com.alura.sevendaysofcode.Filme;
import java.util.ArrayList;

/**
 *
 * @author VantaStrix88
 */
public class IMDBJsonParser {
    
    public static List<Filme> parse (String json) {
        System.out.println(json);
        String[] obras = json.replace("},{", "=").split("=");
        List<Filme> filmes = new ArrayList<>();
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
        System.out.println(filmes.size());
        return filmes;
    }
    
}
