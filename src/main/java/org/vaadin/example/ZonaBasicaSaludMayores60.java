package org.vaadin.example;

public class ZonaBasicaSaludMayores60 {

    private String codigo_geometria;

    private String zona_basica_salud;

    private float tasa_incidencia_acumulada_P60mas_ultimos_14dias;

    private float casos_confirmados_P60mas_ultimos_14dias;

    private String fecha_informe;

    public ZonaBasicaSaludMayores60()
    {
    }
    
    public ZonaBasicaSaludMayores60(String codigo_geometria, String zona_basica_salud, float tasa_incidencia_acumulada_P60mas_ultimos_14dias, float casos_confirmados_P60mas_ultimos_14dias, String fecha_informe) {
        this.codigo_geometria = codigo_geometria;
        this.zona_basica_salud = zona_basica_salud;
        this.tasa_incidencia_acumulada_P60mas_ultimos_14dias = tasa_incidencia_acumulada_P60mas_ultimos_14dias;
        this.casos_confirmados_P60mas_ultimos_14dias = casos_confirmados_P60mas_ultimos_14dias;
        this.fecha_informe = fecha_informe;
    }
}
