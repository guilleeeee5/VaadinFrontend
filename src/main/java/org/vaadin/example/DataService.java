package org.vaadin.example;

import com.google.gson.Gson;
import com.googlecode.gentyref.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DataService {
    private static final String urlPrefix = "http://localhost:8080/ZonaBasicaSalud";
    public static ArrayList<ZonaBasicaSalud> getTodasPersonas(ArrayList<ZonaBasicaSalud> listaPacientes) throws URISyntaxException {

        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(urlPrefix)).GET().build();
        Gson gson = new Gson();
        String resultado = null;
        HttpResponse<String> respuesta = null;

        try {
            respuesta = HttpClient.newBuilder().build().send(httpRequest, HttpResponse.BodyHandlers.ofString());
            resultado = respuesta.body();
            listaPacientes = gson.fromJson(resultado, new TypeToken<ArrayList<ZonaBasicaSalud>>(){}.getType());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return listaPacientes;
    }
}
