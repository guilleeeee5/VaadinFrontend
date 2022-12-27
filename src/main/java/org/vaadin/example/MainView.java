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
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

        ArrayList<ZonaBasicaSalud> listaPacientes = new ArrayList<>();
        ArrayList<ZonaBasicaSalud> finalListaPacientes = listaPacientes;
        ZonaBasicaSalud antiguoDato = new ZonaBasicaSalud();

        Dialog dialog = new Dialog();
        dialog.setHeight("800");
        dialog.setWidth("300");
        dialog.getElement().setAttribute("aria-label", "Mostrar/editar Zonas");


        String fechaCorrecta ="";


        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        HorizontalLayout horizontalLayout3 = new HorizontalLayout();
        HorizontalLayout horizontalLayout4 = new HorizontalLayout();

        HorizontalLayout horizontalLayoutAniadir = new HorizontalLayout();
        TextField textomostrar = new TextField();
        textomostrar.setValue("Añadir nuevo elemento ");
        textomostrar.setEnabled(false);

        Button botonAniadir = new Button("Añadir nuevo elemento");
        horizontalLayoutAniadir.add(botonAniadir);

        Label etiqueta1 = new Label("Codigo geometria");
        TextField texto1 = new TextField();
        texto1.setEnabled(false);
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


        Button boton = new Button("Actualizar");
        Button boton2 = new Button("Cancelar");
        boton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton2.addThemeVariants(ButtonVariant.LUMO_ERROR);

        horizontalLayout1.add(etiqueta1, texto1, etiqueta2, texto2, etiqueta3, texto3);
        horizontalLayout1.setAlignItems(Alignment.CENTER);

        horizontalLayout2.add(etiqueta4, texto4, etiqueta5, texto5, etiqueta6, texto6);
        horizontalLayout2.setAlignItems(Alignment.CENTER);
        horizontalLayout3.add(etiqueta7, texto7);
        horizontalLayout3.setAlignItems(Alignment.CENTER);
        horizontalLayout3.setSpacing(false);
        horizontalLayout3.setAlignSelf(Alignment.CENTER);
        horizontalLayout3.setWidth("100%");


        horizontalLayout4.add(boton, boton2);
        horizontalLayout4.setAlignItems(Alignment.CENTER);
        horizontalLayout4.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout4.setWidth("100%");
        horizontalLayout4.setSpacing(false);

        verticalLayout.add(horizontalLayout1, horizontalLayout2, horizontalLayout3, horizontalLayout4);
        dialog.add(verticalLayout);


        // Generar la tabla con los campos arriba puestos.
        Grid<ZonaBasicaSalud> grid = new Grid<>(ZonaBasicaSalud.class, false);
        grid.addColumn(ZonaBasicaSalud::getCodigo_geometria).setHeader("Codigo geometria").setSortable(true);
        grid.addColumn(ZonaBasicaSalud::getZona_basica_salud).setHeader("Zona basica salud").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getTasa_incidencia_acumulada_ultimos_14dias).setHeader("Tasa incidencia 14 dias").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getTasa_incidencia_acumulada_total).setHeader("Tasa incidencia total").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getCasos_confirmados_totales).setHeader("Casos totales").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getCasos_confirmados_ultimos_14dias).setHeader("Casos 14 dias").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getFecha_informe).setHeader("Fecha informe").setSortable(true);

        // Rellenar los modales con la informacion
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addItemDoubleClickListener(event -> texto1.setValue(event.getItem().getCodigo_geometria()));
        grid.addItemDoubleClickListener(event -> texto2.setValue(event.getItem().getZona_basica_salud()));
        grid.addItemDoubleClickListener(event -> texto3.setValue(String.valueOf(event.getItem().getTasa_incidencia_acumulada_ultimos_14dias())));
        grid.addItemDoubleClickListener(event -> texto4.setValue(String.valueOf(event.getItem().getTasa_incidencia_acumulada_total())));
        grid.addItemDoubleClickListener(event -> texto5.setValue(String.valueOf(event.getItem().getCasos_confirmados_totales())));
        grid.addItemDoubleClickListener(event -> texto6.setValue(String.valueOf(event.getItem().getCasos_confirmados_ultimos_14dias())));
        grid.addItemDoubleClickListener(event -> {
            try {
                texto7.setValue(String.valueOf(event.getItem().setFechaFinal(event.getItem().getFecha_informe())));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });
        grid.addItemDoubleClickListener(new ComponentEventListener<ItemDoubleClickEvent<ZonaBasicaSalud>>() {
            @Override
            public void onComponentEvent(ItemDoubleClickEvent<ZonaBasicaSalud> event) {
                antiguoDato.setCodigo_geometria(event.getItem().getCodigo_geometria());
                antiguoDato.setZona_basica_salud(event.getItem().getZona_basica_salud());
                antiguoDato.setTasa_incidencia_acumulada_ultimos_14dias(event.getItem().getTasa_incidencia_acumulada_ultimos_14dias());
                antiguoDato.setTasa_incidencia_acumulada_total(event.getItem().getTasa_incidencia_acumulada_total());
                antiguoDato.setCasos_confirmados_totales(event.getItem().getCasos_confirmados_totales());
                antiguoDato.setCasos_confirmados_ultimos_14dias(event.getItem().getCasos_confirmados_ultimos_14dias());
                antiguoDato.setFecha_informe(String.valueOf(event.getItem().getFecha_informe()));

                System.out.println(antiguoDato.toString());
            }
        });
        grid.addItemDoubleClickListener(event -> dialog.open());


        // Rellenno el arrayilst, con los datos recibidos
        try {
            listaPacientes = DataService.getTodasPersonas(listaPacientes);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        grid.setItems(listaPacientes);


        boton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                ZonaBasicaSalud nuevodato;
                try {
                     nuevodato = new ZonaBasicaSalud(texto1.getValue(), texto2.getValue(), Float.valueOf(texto3.getValue()), Float.valueOf(texto4.getValue()), Integer.valueOf(texto5.getValue()), Integer.valueOf(texto6.getValue()),  texto7.getValue());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                if(antiguoDato.toString().equals(nuevodato.toString())){

                    Notification notification = new Notification();
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

                    Div text = new Div(new Text("El elemento no se puede actualizar, es el mismo."));

                    Button closeButton = new Button(new Icon("lumo", "cross"));
                    closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
                    closeButton.getElement().setAttribute("aria-label", "Close");
                    closeButton.addClickListener(event2 -> {
                        notification.close();
                    });

                    HorizontalLayout layout = new HorizontalLayout(text, closeButton);
                    layout.setAlignItems(Alignment.CENTER);

                    notification.add(layout);
                    notification.open();
                }
                else{
                    DataService.enviarDatosActualizar(nuevodato.getCodigo_geometria(), antiguoDato, nuevodato, finalListaPacientes);
                    Notification notification = Notification.show("Elemento cambiado con exito");
                    notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                    dialog.close();
                }

            }
        });





        boton2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                dialog.close();
            }
        });

        this.add(horizontalLayoutAniadir, grid);
        this.setAlignItems(Alignment.CENTER);
       
    }





}
