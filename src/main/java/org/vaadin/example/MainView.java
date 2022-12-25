package org.vaadin.example;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Practica 2 Grupo A-6",
        shortName = "Vaadin App",
        description = "Aplicación para leer json y operar mediante un api restful",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout{

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     */
    public MainView() {

        ArrayList<ZonaBasicaSalud> listaPacientes = new ArrayList<>();
        Dialog dialog = new Dialog();
        dialog.setHeight("800");
        dialog.setWidth("300");
        dialog.getElement().setAttribute("aria-label", "Mostrar/editar Zonas");
        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        Label etiqueta1 = new Label("Codigo geometria");
        TextField texto1 = new TextField();
        Label etiqueta2 = new Label("Zona basica salud");
        TextField texto2 = new TextField();
        Label etiqueta3 = new Label("Tasa 14 dias");
        TextField texto3 = new TextField();
        Label etiqueta4 = new Label("Tasa acumulada total");
        TextField texto4 = new TextField();
        Label etiqueta5 = new Label("Casos totales");
        TextField texto5 = new TextField();
        Label etiqueta6 = new Label("Casos 14 dias");
        TextField texto6 = new TextField();
        Label etiqueta7 = new Label("Fecha informe");
        TextField texto7 = new TextField();
        Label etiqueta8 = new Label("Fecha final");
        TextField texto8 = new TextField();

        horizontalLayout1.add(etiqueta1, texto1, etiqueta2, texto2, etiqueta3, texto3, etiqueta4, texto4);
        horizontalLayout1.setAlignItems(Alignment.CENTER);

        horizontalLayout2.add(etiqueta5, texto5, etiqueta6, texto6, etiqueta7, texto7, etiqueta8, texto8);
        horizontalLayout2.setAlignItems(Alignment.CENTER);

        verticalLayout.add(horizontalLayout1, horizontalLayout2);
        dialog.add(verticalLayout);

        Grid<ZonaBasicaSalud> grid = new Grid<>(ZonaBasicaSalud.class, false);
        grid.addColumn(ZonaBasicaSalud::getCodigo_geometria).setHeader("Codigo geometria").setSortable(true);
        grid.addColumn(ZonaBasicaSalud::getZona_basica_salud).setHeader("Zona basica salud").setSortable(true);
        grid.addColumn(ZonaBasicaSalud::getTasa_incidencia_acumulada_ultimos_14dias).setHeader("Tasa incidencia 14 dias").setSortable(true);
        grid.addColumn(ZonaBasicaSalud::getTasa_incidencia_acumulada_total).setHeader("Tasa incidencia total").setSortable(true);
        grid.addColumn(ZonaBasicaSalud::getCasos_confirmados_totales).setHeader("Casos totales").setSortable(true);
        grid.addColumn(ZonaBasicaSalud::getCasos_confirmados_ultimos_14dias).setHeader("Casos 14 dias").setSortable(true);
        grid.addColumn(ZonaBasicaSalud::getFecha_informe).setHeader("Fecha informe").setSortable(true);
        grid.addColumn(ZonaBasicaSalud::getFechaFinal).setHeader("Fecha final").setSortable(true);

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        grid.addItemClickListener(event -> System.out.println(event.getItem().toString()));
        grid.addItemClickListener(event -> texto1.setValue(event.getItem().getCodigo_geometria()));
        grid.addItemClickListener(event -> texto2.setValue(event.getItem().getZona_basica_salud()));
        grid.addItemClickListener(event -> texto3.setValue(String.valueOf(event.getItem().getTasa_incidencia_acumulada_ultimos_14dias())));
        grid.addItemClickListener(event -> texto4.setValue(String.valueOf(event.getItem().getTasa_incidencia_acumulada_total())));
        grid.addItemClickListener(event -> texto5.setValue(String.valueOf(event.getItem().getCasos_confirmados_totales())));
        grid.addItemClickListener(event -> texto6.setValue(String.valueOf(event.getItem().getCasos_confirmados_ultimos_14dias())));
        grid.addItemClickListener(event -> texto7.setValue(event.getItem().getFecha_informe()));
        grid.addItemClickListener(event -> texto8.setValue(String.valueOf(event.getItem().getFechaFinal())));
        grid.addItemClickListener(event -> dialog.open());

        try {
            listaPacientes = DataService.getTodasPersonas(listaPacientes);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        grid.setItems(listaPacientes);


        this.add(grid);
        this.setAlignItems(Alignment.CENTER);
       
    }

}
