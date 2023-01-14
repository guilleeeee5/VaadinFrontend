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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tabla1 extends VerticalLayout {
    ArrayList<ZonaBasicaSalud> listaPacientes = new ArrayList<>();
    ArrayList<ZonaBasicaSalud> listaAuxiliar = new ArrayList<>();
    ArrayList<ZonaBasicaSalud> finalListaPacientes = listaPacientes;
    public Tabla1(){

        ZonaBasicaSalud antiguoDato = new ZonaBasicaSalud();

        Dialog dialog = new Dialog();
        dialog.setHeight("800");
        dialog.setWidth("300");
        dialog.getElement().setAttribute("aria-label", "Mostrar/editar Zonas");

        Dialog dialog2 = new Dialog();
        dialog2.setHeight("800");
        dialog2.setWidth("300");
        dialog2.getElement().setAttribute("aria-label", "Añadir datos a la lista");

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
        horizontalLayout1.setSpacing(true);
        horizontalLayout2.add(etiqueta4, texto4, etiqueta5, texto5, etiqueta6, texto6);
        horizontalLayout2.setAlignItems(Alignment.CENTER);
        horizontalLayout2.setSpacing(true);
        horizontalLayout3.add(etiqueta7, texto7);
        horizontalLayout3.setAlignItems(Alignment.CENTER);
        horizontalLayout3.setSpacing(true);
        horizontalLayout3.setAlignSelf(Alignment.CENTER);
        horizontalLayout3.setWidth("100%");

        horizontalLayout4.add(boton, boton2);
        horizontalLayout4.setAlignItems(Alignment.CENTER);
        horizontalLayout4.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout4.setWidth("100%");
        horizontalLayout4.setSpacing(true);


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
        horizontalLayout5.add(etiqueta9, texto9, etiqueta10, texto10);
        horizontalLayout5.setAlignItems(Alignment.CENTER);
        horizontalLayout5.setSpacing(true);
        horizontalLayout6.add(etiqueta11, texto11, etiqueta12, texto12);
        horizontalLayout6.setAlignItems(Alignment.CENTER);
        horizontalLayout6.setSpacing(true);
        horizontalLayout7.add(etiqueta13, texto13, etiqueta14, texto14);
        horizontalLayout7.setAlignItems(Alignment.CENTER);
        horizontalLayout7.setSpacing(true);
        horizontalLayout7.setAlignSelf(Alignment.CENTER);
        horizontalLayout7.setWidth("100%");

        horizontalLayout8.add(boton3, boton4);
        horizontalLayout8.setAlignItems(Alignment.CENTER);
        horizontalLayout8.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout8.setWidth("100%");
        horizontalLayout8.setSpacing(true);


        verticalLayout.add(horizontalLayout1, horizontalLayout2, horizontalLayout3, horizontalLayout4);
        verticalLayout.setSpacing(true);
        verticalLayout2.add(horizontalLayout5, horizontalLayout6, horizontalLayout7, horizontalLayout8);
        verticalLayout2.setSpacing(true);
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
        } catch (
                URISyntaxException e) {
            throw new RuntimeException(e);
        }

        grid.setItems(listaPacientes);


        boton.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {

                String fecha = texto7.getValue();
                Pattern pattern = Pattern.compile("^(0[1-9]|1\\d|2[0-8]|29(?=-\\d\\d-(?!1[01345789]00|2[1235679]00)\\d\\d(?:[02468][048]|[13579][26]))|30(?!-02)|31(?=-0[13578]|-1[02]))-(0[1-9]|1[0-2])-([12]\\d{3}) ([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)");
                Matcher matcher = pattern.matcher(fecha);

                if(texto2.getValue().equals("")|| texto3.getValue().equals("")|| texto4.getValue().equals("")|| texto5.getValue().equals("")|| texto6.getValue().equals("")|| texto7.getValue().equals("")){
                    Notification notification = new Notification();
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

                    Div text = new Div(new Text("El elemento no se puede actualizar, hay campos vacios."));

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
                else if(!matcher.find()){
                    Notification notification = new Notification();
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

                    Div text = new Div(new Text("No se cumple el formato de la fecha pedida dd-mm-yyyy hh:mm:ss"));

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

                else {
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
                String fecha = texto14.getValue();
                Pattern pattern = Pattern.compile("^(0[1-9]|1\\d|2[0-8]|29(?=-\\d\\d-(?!1[01345789]00|2[1235679]00)\\d\\d(?:[02468][048]|[13579][26]))|30(?!-02)|31(?=-0[13578]|-1[02]))-(0[1-9]|1[0-2])-([12]\\d{3}) ([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)");
                Matcher matcher = pattern.matcher(fecha);
                    if(texto9.getValue().equals("") || texto10.getValue().equals("")|| texto11.getValue().equals("")|| texto12.getValue().equals("")|| texto13.getValue().equals("")|| texto14.getValue().equals("")){
                        Notification notification = new Notification();
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

                        Div text = new Div(new Text("Hay campos vacios dentro del dialogo, no se añaden los datos"));
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
                    else if(!matcher.find()){
                        Notification notification = new Notification();
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

                        Div text = new Div(new Text("No se cumple el formato de la fecha pedida dd-mm-yyyy hh:mm:ss"));

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
        this.setAlignItems(Alignment.CENTER);
        this.setHeightFull();
        this.add(grid, horizontalLayoutAniadir);
    }



}
