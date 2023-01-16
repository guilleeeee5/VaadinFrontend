package org.vaadin.example;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tabla2 extends VerticalLayout {
    ArrayList<ZonaBasicaSaludMayores60> listaAuxiliar2 = new ArrayList<>();
    ArrayList<ZonaBasicaSaludMayores60> listaPacientes2 = new ArrayList<ZonaBasicaSaludMayores60>();
    public Tabla2(){
        ZonaBasicaSaludMayores60 antiguoDato = new ZonaBasicaSaludMayores60();
        HorizontalLayout horizontalLayoutAniadir = new HorizontalLayout();
        Button botonAniadir2 = new Button("Añadir nuevo elemento");
        horizontalLayoutAniadir.add(botonAniadir2);
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

        TextField textomostrar = new TextField();
        textomostrar.setValue("Añadir nuevo elemento ");
        textomostrar.setEnabled(false);

        Label etiqueta1 = new Label("Codigo geometria");
        TextField texto1 = new TextField();
        texto1.setEnabled(false);
        Label etiqueta2 = new Label("Zona basica salud");
        TextField texto2 = new TextField();
        Label etiqueta3 = new Label("Tasa 14 dias");
        TextField texto3 = new TextField();
        Label etiqueta4 = new Label("Casos confirmados");
        TextField texto4 = new TextField();
        Label etiqueta5 = new Label("Fecha informe");
        TextField texto5 = new TextField();

        Button boton5 = new Button("Actualizar");
        Button boton2 = new Button("Cancelar");
        Button boton3 = new Button("Añadir datos");
        Button boton4 = new Button("Reiniciar datos");
        boton5.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton2.addThemeVariants(ButtonVariant.LUMO_ERROR);
        boton3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        boton4.addThemeVariants(ButtonVariant.LUMO_ERROR);


        horizontalLayout1.add(etiqueta1, texto1, etiqueta2, texto2);
        horizontalLayout1.setAlignItems(Alignment.CENTER);

        horizontalLayout2.add(etiqueta3, texto3, etiqueta4, texto4);
        horizontalLayout2.setAlignItems(Alignment.CENTER);
        horizontalLayout3.add(etiqueta5, texto5);
        horizontalLayout3.setAlignItems(Alignment.CENTER);
        horizontalLayout3.setSpacing(false);
        horizontalLayout3.setAlignSelf(Alignment.CENTER);
        horizontalLayout3.setWidth("100%");

        horizontalLayout4.add(boton5, boton2);
        horizontalLayout4.setAlignItems(Alignment.CENTER);
        horizontalLayout4.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout4.setWidth("100%");
        horizontalLayout4.setSpacing(false);

        horizontalLayout5.add(boton3, boton4);
        horizontalLayout5.setAlignItems(Alignment.CENTER);
        horizontalLayout5.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout5.setWidth("100%");
        horizontalLayout5.setSpacing(false);

        Label etiqueta7 = new Label("Zona basica salud");
        TextField texto7 = new TextField();
        Label etiqueta8 = new Label("Tasa 14 dias");
        TextField texto8 = new TextField();
        Label etiqueta9 = new Label("Casos confirmados");
        TextField texto9 = new TextField();
        Label etiqueta10 = new Label("Fecha informe");
        TextField texto10 = new TextField();

        horizontalLayout5.add(etiqueta7, texto7, etiqueta8, texto8);
        horizontalLayout5.setAlignItems(Alignment.CENTER);
        horizontalLayout6.add(etiqueta9, texto9, etiqueta10, texto10);
        horizontalLayout6.setAlignItems(Alignment.CENTER);
        horizontalLayout7.add();
        horizontalLayout7.setAlignItems(Alignment.CENTER);
        horizontalLayout7.setSpacing(false);
        horizontalLayout7.setAlignSelf(Alignment.CENTER);
        horizontalLayout7.setWidth("100%");

        horizontalLayout8.add(boton3, boton4);
        horizontalLayout8.setAlignItems(Alignment.CENTER);
        horizontalLayout8.setVerticalComponentAlignment(Alignment.CENTER);
        horizontalLayout8.setWidth("100%");
        horizontalLayout8.setSpacing(false);

        verticalLayout.add(horizontalLayout1, horizontalLayout2, horizontalLayout3, horizontalLayout4);
        verticalLayout.setSpacing(true);
        verticalLayout.setAlignItems(Alignment.CENTER);
        verticalLayout2.add(horizontalLayout5, horizontalLayout6, horizontalLayout7, horizontalLayout8);
        verticalLayout.setSpacing(true);
        verticalLayout.setAlignItems(Alignment.CENTER);
        dialog.add(verticalLayout);
        dialog2.add(verticalLayout2);

        // Generar la tabla con los campos arriba puestos.

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

        grid2.addItemDoubleClickListener(new ComponentEventListener<ItemDoubleClickEvent<ZonaBasicaSaludMayores60>>() {
            @Override
            public void onComponentEvent(ItemDoubleClickEvent<ZonaBasicaSaludMayores60> event) {
                antiguoDato.setCodigo_geometria(event.getItem().getCodigo_geometria());
                antiguoDato.setZona_basica_salud(event.getItem().getZona_basica_salud());
                antiguoDato.setTasa_incidencia_acumulada_P60mas_ultimos_14dias(event.getItem().getTasa_incidencia_acumulada_P60mas_ultimos_14dias());
                antiguoDato.setCasos_confirmados_P60mas_ultimos_14dias(event.getItem().getCasos_confirmados_P60mas_ultimos_14dias());
                antiguoDato.setFecha_informe(String.valueOf(event.getItem().getFecha_informe()));
            }
        });

        grid2.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid2.addItemDoubleClickListener(event -> texto1.setValue(event.getItem().getCodigo_geometria()));
        grid2.addItemDoubleClickListener(event -> texto2.setValue(event.getItem().getZona_basica_salud()));
        grid2.addItemDoubleClickListener(event -> texto3.setValue(String.valueOf(event.getItem().getTasa_incidencia_acumulada_P60mas_ultimos_14dias())));
        grid2.addItemDoubleClickListener(event -> texto4.setValue(String.valueOf(event.getItem().getCasos_confirmados_P60mas_ultimos_14dias())));

        grid2.addItemDoubleClickListener(event -> {
            try {
                texto5.setValue(String.valueOf(event.getItem().setFecha_bonita(event.getItem().getFecha_informe())));

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        grid2.addItemDoubleClickListener(event -> dialog.open());
        botonAniadir2.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                texto7.setValue("");
                texto8.setValue("");
                texto9.setValue("");
                texto10.setValue("");
                dialog2.open();
            }
        });

        boton5.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                String fecha = texto5.getValue();
                Pattern pattern = Pattern.compile("^(0[1-9]|1\\d|2[0-9]|29(?=-\\d\\d-(?!1[01345789]00|2[1235679]00)\\d\\d(?:[02468][048]|[13579][26]))|30(?!-02)|31(?=-0[13578]|-1[02]))-(0[1-9]|1[0-2])-([12]\\d{3}) ([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)");
                Matcher matcher = pattern.matcher(fecha);
                ZonaBasicaSaludMayores60 nuevodato = null;


                if(texto1.getValue().equals("") || texto2.getValue().equals("") || texto3.getValue().equals("") || texto4.getValue().equals("") || texto5.getValue().equals("")){
                    Notification notification = Notification.show("No se puede actualizar el elemento, campos vacios");
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                }
                else if (!matcher.find()){
                    Notification notification = Notification.show("La fecha no esta escrita en el formato correcto.");
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                }
                else{
                    try {
                        nuevodato = new ZonaBasicaSaludMayores60(texto1.getValue(), texto2.getValue(), Float.valueOf(texto3.getValue()), Float.valueOf(texto4.getValue()),ZonaBasicaSaludMayores60.invertirFecha(texto5.getValue()));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    if(antiguoDato.toString().equals(nuevodato.toString())){
                        Notification notification = Notification.show("El elemento es el mismo");
                        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    }
                    else{
                        try {
                            listaAuxiliar2 = new ArrayList<>();
                            listaAuxiliar2.add(antiguoDato);
                            listaAuxiliar2.add(nuevodato);
                            listaPacientes2 = DataService.enviarDatosActualizar60(listaAuxiliar2);
                        } catch (URISyntaxException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Notification notification = Notification.show("Elemento cambiado con exito");
                        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

                        grid2.setItems(listaPacientes2);
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

        // Rellenar los modales con la informacion
        grid2.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid2.setItems(listaPacientes2);

        this.add(grid2, horizontalLayoutAniadir);
        this.setAlignItems(Alignment.CENTER);
        this.setHeightFull();

        boton3.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                String fecha = texto10.getValue();
                Pattern pattern = Pattern.compile("^(0[1-9]|1\\d|2[0-9]|29(?=-\\d\\d-(?!1[01345789]00|2[1235679]00)\\d\\d(?:[02468][048]|[13579][26]))|30(?!-02)|31(?=-0[13578]|-1[02]))-(0[1-9]|1[0-2])-([12]\\d{3}) ([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)");
                Matcher matcher = pattern.matcher(fecha);
                ZonaBasicaSaludMayores60 zonaBasicaSalud60 = null;
                if(texto7.getValue().equals("")|| texto8.getValue().equals("")|| texto9.getValue().equals("")|| texto10.getValue().equals("")) {
                    Notification notification = Notification.show("Hay campos vacios en el dialogo");
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                }
                else if(!matcher.find()){
                    Notification notification = Notification.show("La fecha no esta escrita en el formato correcto.");
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                }
                else{
                    try {
                        zonaBasicaSalud60 = new ZonaBasicaSaludMayores60("", texto7.getValue(), Float.valueOf(texto8.getValue()), Float.valueOf(texto9.getValue()), ZonaBasicaSalud.invertirFecha(texto10.getValue()));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    Notification notification = Notification.show("Elemento añadido con exito");
                    notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                    listaPacientes2 = DataService.aniadirDatosLista60(zonaBasicaSalud60, listaPacientes2);
                    grid2.setItems(listaPacientes2);
                    dialog2.close();
                }

            }
        });

        boton4.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> event) {
                texto7.setValue("");
                texto8.setValue("");
                texto9.setValue("");
                texto10.setValue("");
            }
        });
    }
}
