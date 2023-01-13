package org.vaadin.example;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.ItemDoubleClickEvent;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

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


        Tabla1 tabla1 = new Tabla1();

        //Tab
        Tab zonaBasica = new Tab("Zona Basica");
        zonaBasica.setId("ZonaBasica");
        Tab zonaBasica60 = new Tab("Zona Basica Mayores de 60");
        zonaBasica60.setId("ZonaBasica60");
        Tabs paginas = new Tabs(zonaBasica,zonaBasica60);


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

        // Rellenar los modales con la informacion
        grid2.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid2.setItems(listaPacientes2);

        tabla1.setVisible(true);
        grid2.setVisible(false);
        paginas.setSelectedTab(zonaBasica);
        paginas.addSelectedChangeListener(new ComponentEventListener<Tabs.SelectedChangeEvent>() {
            @Override
            public void onComponentEvent(Tabs.SelectedChangeEvent event) {
                if(event.getSelectedTab().getId().toString().equals("Optional[ZonaBasica]")){
                    tabla1.setVisible(true);
                    grid2.setVisible(false);
                }
                else{
                    tabla1.setVisible(false);
                    grid2.setVisible(true);
                }
            }
        });

        this.add(paginas, tabla1, grid2);
        this.setAlignItems(Alignment.CENTER);
       
    }







}
