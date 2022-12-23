package org.vaadin.example;

import com.google.gson.Gson;
import com.googlecode.gentyref.TypeToken;
import org.apache.catalina.connector.OutputBuffer;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
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


    @PutMapping("/envio")
    public static void enviarDatosActualizar(ZonaBasicaSalud zonaBasicaSalud) {
        try {
            URL url = new URL("http://localhost:8080/");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            String dataAPasar = String.format("http://localhost:8080/codigo_geometria=%s&zona_basica_salud=%s&tasa_incidencia_acumulada_ultimos_14dias=%s&tasa_incidencia_acumulada_total=%s&casos_confirmados_totales=%s&casos_confirmados_ultimos_14dias=%s&fecha_informe=?", zonaBasicaSalud.getCodigo_geometria(), zonaBasicaSalud.getZona_basica_salud(), zonaBasicaSalud.getTasa_incidencia_acumulada_ultimos_14dias(), zonaBasicaSalud.getTasa_incidencia_acumulada_total(), zonaBasicaSalud.getCasos_confirmados_totales(), zonaBasicaSalud.getCasos_confirmados_ultimos_14dias(), zonaBasicaSalud.getFecha_informe());
            System.out.println(dataAPasar);
            try (OutputStream os = http.getOutputStream()) {
                os.write(dataAPasar.getBytes(StandardCharsets.UTF_8));
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    }
}
