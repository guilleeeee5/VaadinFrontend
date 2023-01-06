package org.vaadin.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.googlecode.gentyref.TypeToken;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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


    @RequestMapping()
    public static ArrayList<ZonaBasicaSalud> enviarDatosActualizar(@RequestBody ArrayList<ZonaBasicaSalud> montarJSON) throws URISyntaxException, IOException, InterruptedException {
        Gson g = new Gson();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut request = new HttpPut(urlPrefix);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json");
        String jsonpasado = "[" + montarJSON.get(0).mostrarJson() + "," + montarJSON.get(1).mostrarJson() + "]";
        System.out.println(jsonpasado);
        StringEntity stringEntity = new StringEntity(jsonpasado);
        request.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(request);
        String respuestaActual = new BasicResponseHandler().handleResponse(response);

        montarJSON = g.fromJson(respuestaActual, new TypeToken<ArrayList<ZonaBasicaSalud>>(){}.getType());

        return montarJSON;
    }


}
