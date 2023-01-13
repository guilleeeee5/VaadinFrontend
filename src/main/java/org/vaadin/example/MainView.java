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
    ArrayList<ZonaBasicaSalud> listaPacientes = new ArrayList<>();
    ArrayList<ZonaBasicaSalud> listaAuxiliar = new ArrayList<>();
    ArrayList<ZonaBasicaSalud> finalListaPacientes = listaPacientes;
    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     */
    public MainView() {

        ZonaBasicaSalud antiguoDato = new ZonaBasicaSalud();

        Dialog dialog = new Dialog();
        dialog.setHeight("800");
        dialog.setWidth("300");
        dialog.getElement().setAttribute("aria-label", "Mostrar/editar Zonas");

        Dialog dialog2 = new Dialog();
        dialog2.setHeight("800");
        dialog2.setWidth("300");
        dialog2.getElement().setAttribute("aria-label", "Añadir datos a la lista");




        //Tab
        Tab zonaBasica = new Tab("Zona Basica");
        zonaBasica.setId("ZonaBasica");
        Tab zonaBasica60 = new Tab("Zona Basica Mayores de 60");
        zonaBasica60.setId("ZonaBasica60");
        Tabs paginas = new Tabs(zonaBasica,zonaBasica60);


        VerticalLayout verticalLayout = new VerticalLayout();
        VerticalLayout verticalLayout2 = new VerticalLayout();
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        HorizontalLayout horizontalLayout2 = new HorizontalLayout();
        HorizontalLayout horizontalLayout3 = new HorizontalLayout();
        HorizontalLayout horizontalLayout4 = new HorizontalLayout();
        HorizontalLayout horizontalLayout5 = new HorizontalLayout();
        HorizontalLayout horizontalLayout6 = new HorizontalLayout();
        HorizontalLayout horizontalLayout7 = new HorizontalLayout();
        HorizontalLayout horizontalLayout8 = new HorizontalLayout();

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
        Button boton3 = new Button("Añadir datos");
        Button boton4 = new Button("Reiniciar datos");
        boton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton2.addThemeVariants(ButtonVariant.LUMO_ERROR);
        boton3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton4.addThemeVariants(ButtonVariant.LUMO_ERROR);


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

        horizontalLayout5.add(boton3, boton4);
        horizontalLayout5.setAlignItems(Alignment.CENTER);
        horizontalLayout5.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout5.setWidth("100%");
        horizontalLayout5.setSpacing(false);

        Label etiqueta8 = new Label("Codigo geometria");
        TextField texto8 = new TextField();
        texto8.setEnabled(false);
        Label etiqueta9 = new Label("Zona basica salud");
        TextField texto9 = new TextField();
        Label etiqueta10 = new Label("Tasa 14 dias");
        TextField texto10 = new TextField();
        Label etiqueta11 = new Label("Tasa acumulada total");
        TextField texto11 = new TextField();
        Label etiqueta12 = new Label("Casos totales");
        TextField texto12 = new TextField();
        Label etiqueta13 = new Label("Casos 14 dias");
        TextField texto13 = new TextField();
        Label etiqueta14 = new Label("Fecha informe");
        TextField texto14 = new TextField();
        horizontalLayout5.add(etiqueta8, texto8, etiqueta9, texto9, etiqueta10, texto10);
        horizontalLayout5.setAlignItems(Alignment.CENTER);

        horizontalLayout6.add(etiqueta11, texto11, etiqueta12, texto12, etiqueta13, texto13);
        horizontalLayout6.setAlignItems(Alignment.CENTER);
        horizontalLayout7.add(etiqueta14, texto14);
        horizontalLayout7.setAlignItems(Alignment.CENTER);
        horizontalLayout7.setSpacing(false);
        horizontalLayout7.setAlignSelf(Alignment.CENTER);
        horizontalLayout7.setWidth("100%");

        horizontalLayout8.add(boton3, boton4);
        horizontalLayout8.setAlignItems(Alignment.CENTER);
        horizontalLayout8.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout8.setWidth("100%");
        horizontalLayout8.setSpacing(false);
        verticalLayout2.add(horizontalLayout5, horizontalLayout6, horizontalLayout7, horizontalLayout8);


        verticalLayout.add(horizontalLayout1, horizontalLayout2, horizontalLayout3, horizontalLayout4);
        verticalLayout2.add(horizontalLayout5, horizontalLayout6, horizontalLayout7, horizontalLayout8);
        dialog.add(verticalLayout);
        dialog2.add(verticalLayout2);


        // Generar la tabla con los campos arriba puestos.
        Grid<ZonaBasicaSalud> grid = new Grid<>(ZonaBasicaSalud.class, false);
        grid.addColumn(ZonaBasicaSalud::getCodigo_geometria).setHeader("Codigo geometria").setSortable(true);
        grid.addColumn(ZonaBasicaSalud::getZona_basica_salud).setHeader("Zona basica salud").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getTasa_incidencia_acumulada_ultimos_14dias).setHeader("Tasa incidencia 14 dias").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getTasa_incidencia_acumulada_total).setHeader("Tasa incidencia total").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getCasos_confirmados_totales).setHeader("Casos totales").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getCasos_confirmados_ultimos_14dias).setHeader("Casos 14 dias").setSortable(false);
        grid.addColumn(ZonaBasicaSalud::getFecha_bonita).setHeader("Fecha informe").setSortable(true);

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
                texto7.setValue(String.valueOf(event.getItem().setFecha_bonita(event.getItem().getFecha_informe())));

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
                ZonaBasicaSalud nuevodato = null;
                try {
                     nuevodato = new ZonaBasicaSalud(texto1.getValue(), texto2.getValue(), Float.valueOf(texto3.getValue()), Float.valueOf(texto4.getValue()), Integer.valueOf(texto5.getValue()), Integer.valueOf(texto6.getValue()), ZonaBasicaSalud.invertirFecha(texto7.getValue()));
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
                    try {
                        listaAuxiliar = new ArrayList<>();
                        listaAuxiliar.add(antiguoDato);
                        listaAuxiliar.add(nuevodato);
                        listaPacientes = DataService.enviarDatosActualizar(listaAuxiliar);
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Notification notification = Notification.show("Elemento cambiado con exito");
                    notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

                    grid.setItems(listaPacientes);
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

        botonAniadir.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                texto1.setValue("");
                texto2.setValue("");
                texto3.setValue("");
                texto4.setValue("");
                texto5.setValue("");
                texto6.setValue("");
                texto7.setValue("");
                dialog2.open();

            }
        });

        boton3.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                ZonaBasicaSalud zonaBasicaSalud;
                try {
                    zonaBasicaSalud = new ZonaBasicaSalud("", texto9.getValue(), Float.valueOf(texto10.getValue()), Float.valueOf(texto11.getValue()), Integer.valueOf(texto12.getValue()), Integer.valueOf(texto13.getValue()), ZonaBasicaSalud.invertirFecha(texto14.getValue()));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                listaPacientes = DataService.aniadirDatosLista(zonaBasicaSalud, listaPacientes);
                grid.setItems(listaPacientes);
                dialog2.close();
            }
        });

        boton4.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                texto1.setValue("");
                texto2.setValue("");
                texto3.setValue("");
                texto4.setValue("");
                texto5.setValue("");
                texto6.setValue("");
                texto7.setValue("");
            }
        });


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

        grid.setVisible(true);
        grid2.setVisible(false);
        paginas.setSelectedTab(zonaBasica);
        paginas.addSelectedChangeListener(new ComponentEventListener<Tabs.SelectedChangeEvent>() {
            @Override
            public void onComponentEvent(Tabs.SelectedChangeEvent event) {
                if(event.getSelectedTab().getId().toString().equals("Optional[ZonaBasica]")){
                    grid.setVisible(true);
                    grid2.setVisible(false);
                }
                else{
                    grid.setVisible(false);
                    grid2.setVisible(true);
                }
            }
        });




        this.add(paginas, grid, grid2, horizontalLayoutAniadir);
        this.setAlignItems(Alignment.CENTER);
       
    }







}
