/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.alura.sevendaysofcode.parser.jsonparser;

import java.util.List;

import br.com.alura.sevendaysofcode.conteudo.Conteudo;

/**
 *
 * @author VantaStrix88
 */
public interface JsonParser {
    List<? extends Conteudo> parse(String json);
}
