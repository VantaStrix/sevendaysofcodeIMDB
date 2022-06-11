/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.alura.sevendaysofcode.api;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VantaStrix88
 */
public class MarvelApiClient implements ApiClient {

    private static MarvelApiClient instance;
    
    private MarvelApiClient() {}
    
    public static MarvelApiClient getInstance() {
        if (MarvelApiClient.instance == null) {
            MarvelApiClient.instance = new MarvelApiClient();
        }
        return MarvelApiClient.instance;
    }
    
    @Override
    public String getResponseBody(String URL) {
        String ts = "1";
        String publicKey = "64627e0633c2f636ce09acabbc8b6d39";
        String privateKey = "ac03453e6e64671f8f89c0bb5e79c9f472791224";
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("md5");
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
        String toHash = ts + privateKey + publicKey;
        byte[] hashByte = md.digest(toHash.getBytes());
        BigInteger bigInt = new BigInteger(1, hashByte);
        String hashString = bigInt.toString(16);
        //System.out.println(hashString);
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "&ts=" + ts + "&apikey=" + publicKey + "&hash=" + hashString))
                .GET()
                .build();
        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ImdbApiClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response.body();
    }
    
}
