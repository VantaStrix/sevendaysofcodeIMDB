/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.sevendaysofcode;

import br.com.alura.sevendaysofcode.conteudo.Conteudo;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author VantaStrix88
 */
public class HTMLGenerator {

    private final PrintWriter writer;
    
    public HTMLGenerator (PrintWriter writer) {
        this.writer = writer;
    }
    
    public void generate(List<? extends Conteudo> conteudo) {
        String head =
                """
                <head>
                    <meta charset=\"utf-8\">
                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
                        + "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
                </head>
                """;
        String divTemplate =
                """
                <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
                    <h4 class=\"card-header\">%s</h4>
                    <div class=\"card-body\">
                	<img class=\"card-img\" src=\"%s\" alt=\"%s\">
                	<p class=\"card-text mt-2\">Rating: %s - Ano: %s</p>
                    </div>
                </div>
                """;
        this.writer.println("<html>");
        this.writer.println(head);
        this.writer.println("<body>");
        for (var obra : conteudo) {
            this.writer.println(String.format(divTemplate, obra.getTitulo(),
                    obra.getPosterURL(), obra.getTitulo(), obra.getRating(),
                    obra.getAno()));
        }
        this.writer.println("</body>" + System.lineSeparator() + "</html>");
    }
}
