package org.vaadin.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ZonaBasicaSaludMayores60 {

    private String codigo_geometria;

    private String zona_basica_salud;

    private float tasa_incidencia_acumulada_P60mas_ultimos_14dias;

    private float casos_confirmados_P60mas_ultimos_14dias;

    private String fecha_informe;

    private String fecha_bonita;

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

    public void setCodigo_geometria(String codigo_geometria) {
        this.codigo_geometria = codigo_geometria;
    }

    public void setZona_basica_salud(String zona_basica_salud) {
        this.zona_basica_salud = zona_basica_salud;
    }

    public void setTasa_incidencia_acumulada_P60mas_ultimos_14dias(float tasa_incidencia_acumulada_P60mas_ultimos_14dias) {
        this.tasa_incidencia_acumulada_P60mas_ultimos_14dias = tasa_incidencia_acumulada_P60mas_ultimos_14dias;
    }

    public void setCasos_confirmados_P60mas_ultimos_14dias(float casos_confirmados_P60mas_ultimos_14dias) {
        this.casos_confirmados_P60mas_ultimos_14dias = casos_confirmados_P60mas_ultimos_14dias;
    }

    public void setFecha_informe(String fecha_informe) {
        this.fecha_informe = fecha_informe;
    }

    public String getCodigo_geometria() {
        return codigo_geometria;
    }

    public String getZona_basica_salud() {
        return zona_basica_salud;
    }

    public float getTasa_incidencia_acumulada_P60mas_ultimos_14dias() {
        return tasa_incidencia_acumulada_P60mas_ultimos_14dias;
    }

    public float getCasos_confirmados_P60mas_ultimos_14dias() {
        return casos_confirmados_P60mas_ultimos_14dias;
    }

    public String getFecha_informe() {
        return fecha_informe;
    }

    public String getFecha_bonita(){
        try {
            fecha_bonita = setFecha_bonita(this.fecha_informe);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return fecha_bonita;
    }

    public String setFecha_bonita(String fecha_final1) throws ParseException {
        Date fecha_final;
        fecha_final1 = fecha_final1.replace("/", "-");
        SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = Formato.parse(fecha_final1);
        Formato.applyPattern("dd-MM-yyyy HH:mm:ss");
        fecha_final1 = Formato.format(d);
        fecha_final = Formato.parse(fecha_final1);
        String fechaSacar = Formato.format(fecha_final);
        return fechaSacar;
    }

    public static String invertirFecha(String fecha_final1) throws ParseException {
        Date fecha_final;
        fecha_final1 = fecha_final1.replace("-", "/");
        SimpleDateFormat Formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = Formato.parse(fecha_final1);
        Formato.applyPattern("yyyy/MM/dd HH:mm:ss");
        fecha_final1 = Formato.format(d);
        fecha_final = Formato.parse(fecha_final1);
        String fechaSacar = Formato.format(fecha_final);
        return fechaSacar;
    }

    public String mostrarJson() {
        return "{\n" +
                "\"codigo_geometria\": " + "\"" + codigo_geometria + "\"," + "\n" +
                "\"zona_basica_salud\": " + "\"" + zona_basica_salud  + "\"," + "\n" +
                "\"tasa_incidencia_acumulada_ultimos_14dias\": " + tasa_incidencia_acumulada_P60mas_ultimos_14dias  +  ",\n" +
                "\"tasa_incidencia_acumulada_total\": " + casos_confirmados_P60mas_ultimos_14dias + ",\n" +
                "\"fecha_informe\": " + "\"" + fecha_informe + "\"" + "\n" +
                "}";
    }

}
