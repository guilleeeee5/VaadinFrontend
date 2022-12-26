package org.vaadin.example;

import com.google.gson.Gson;
import com.googlecode.gentyref.TypeToken;
import org.apache.catalina.connector.OutputBuffer;
import org.apache.catalina.connector.Response;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
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


    @PutMapping(path = "/{codigo_geometria}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public static ResponseEntity<ZonaBasicaSalud> enviarDatosActualizar(@PathVariable String codigo_geometria, ZonaBasicaSalud zonaBasicaSaludAntiguo, @RequestBody ZonaBasicaSalud zonaBasicaSaludNuevo, ArrayList<ZonaBasicaSalud> listaPacientes) {

        return new ResponseEntity<>(zonaBasicaSaludNuevo, HttpStatus.OK);
    }
}
