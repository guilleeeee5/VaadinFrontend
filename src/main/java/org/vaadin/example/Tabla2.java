package org.vaadin.example;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class Tabla2 extends VerticalLayout {
    public Tabla2(){

        HorizontalLayout horizontalLayoutAniadir = new HorizontalLayout();
        Button botonAniadir = new Button("Añadir nuevo elemento");
        horizontalLayoutAniadir.add(botonAniadir);

        // Generar la tabla con los campos arriba puestos.
        ArrayList<ZonaBasicaSaludMayores60> listaPacientes2 = new ArrayList<ZonaBasicaSaludMayores60>();
        Grid<ZonaBasicaSaludMayores60> grid2 = new Grid<>(ZonaBasicaSaludMayores60.class, false);
        grid2.addColumn(ZonaBasicaSaludMayores60::getCodigo_geometria).setHeader("Codigo geometria").setSortable(true);
        grid2.addColumn(ZonaBasicaSaludMayores60::getZona_basica_salud).setHeader("Zona basica salud").setSortable(false);
        grid2.addColumn(ZonaBasicaSaludMayores60::getTasa_incidencia_acumulada_P60mas_ultimos_14dias).setHeader("Tasa incidencia 14 dias").setSortable(false);
        grid2.addColumn(ZonaBasicaSaludMayores60::getCasos_confirmados_P60mas_ultimos_14dias).setHeader("Casos 14 dias").setSortable(false);
        grid2.addColumn(ZonaBasicaSaludMayores60::getFecha_bonita).setHeader("Fecha informe").setSortable(true);
        //Añadimos los datos
        try {
            listaPacientes2 = DataService.getTodasPersonas2(listaPacientes2);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        botonAniadir.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                

            }
        });

        // Rellenar los modales con la informacion
        grid2.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid2.setItems(listaPacientes2);
        this.add(grid2, horizontalLayoutAniadir);
    }
}
