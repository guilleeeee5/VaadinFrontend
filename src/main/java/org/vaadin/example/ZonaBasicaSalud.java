package org.vaadin.example;

import java.text.ParseException;
import java.util.Date;

public class ZonaBasicaSalud {
    private String codigo_geometria;
    private String zona_basica_salud;
    private float tasa_incidencia_acumulada_ultimos_14dias;
    private float tasa_incidencia_acumulada_total;
    private int casos_confirmados_totales;
    private int casos_confirmados_ultimos_14dias;
    private String fecha_informe;
    private Date fechaFinal;

    public ZonaBasicaSalud(String codigo_geometria, String zona_basica_salud, float tasa_incidencia_acumulada_ultimos_14dias, float tasa_incidencia_acumulada_total, int casos_confirmados_totales, int casos_confirmados_ultimos_14dias, String fecha_informe) throws ParseException {
        this.codigo_geometria = codigo_geometria;
        this.zona_basica_salud = zona_basica_salud;
        this.tasa_incidencia_acumulada_ultimos_14dias = tasa_incidencia_acumulada_ultimos_14dias;
        this.tasa_incidencia_acumulada_total = tasa_incidencia_acumulada_total;
        this.casos_confirmados_totales = casos_confirmados_totales;
        this.fecha_informe = fecha_informe;
        this.casos_confirmados_ultimos_14dias = casos_confirmados_ultimos_14dias;
    }

    public ZonaBasicaSalud()
    {
    }

}
