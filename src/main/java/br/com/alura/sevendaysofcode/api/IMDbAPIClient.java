/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.sevendaysofcode.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VantaStrix88
 */
public class IMDbAPIClient implements APIClient {
    
    private static IMDbAPIClient instance;
    
    private IMDbAPIClient() {}
    
    public static IMDbAPIClient getInstance() {
        if (IMDbAPIClient.instance == null) {
            IMDbAPIClient.instance = new IMDbAPIClient();
        }
        return IMDbAPIClient.instance;
    }
    
    public String getResponseBody (String URL) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "k_5cpmf1wr"))
                .GET()
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(IMDbAPIClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.body();
    }
}
