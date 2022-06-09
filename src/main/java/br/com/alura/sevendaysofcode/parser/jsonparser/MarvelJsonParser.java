/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package br.com.alura.sevendaysofcode.parser.jsonparser;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.sevendaysofcode.conteudo.MarvelSeries;

/**
 *
 * @author VantaStrix88
 */
public class MarvelJsonParser implements JsonParser {

    private static MarvelJsonParser instance;

    private MarvelJsonParser() {}

    public static MarvelJsonParser getInstance() {
        if (MarvelJsonParser.instance == null) {
            MarvelJsonParser.instance = new MarvelJsonParser();
        }
        return MarvelJsonParser.instance;
    }

    @Override
    public List<MarvelSeries> parse(String json) {
        System.out.println(json);
        String[] obras = json.replace("},{\"id\"", "}={\"id\"").split("\\}=\\{");
        System.out.println(obras.length);
        List<MarvelSeries> series = new ArrayList<>();
        for (String obra : obras) {
            //System.out.println(obra);
            String titulo = obra.substring(obra.indexOf("\"title\"") + 9, obra.indexOf(",\"description\"") - 1);
            String ano = obra.substring(obra.indexOf("\"startYear\"") + 12, obra.indexOf(",\"endYear\""));
            String nota = obra.substring(obra.indexOf("\"rating\"") + 10, obra.indexOf(",\"type\"") - 1);
            String posterURL = obra.substring(obra.indexOf("\"thumbnail\":{\"path\"") + 21, obra.indexOf(",\"extension\"") - 1)
                    + "." 
                    + obra.substring(obra.indexOf("\"extension\"") + 13, obra.indexOf("},\"creators\"") - 1);

            series.add(new MarvelSeries(titulo, posterURL, !nota.equals("") ? nota : "N/A", ano));
            //System.out.println(nota);
            //System.out.println(!nota.equals("") ? nota : "N/A");
        }
        return series;
    }

}
