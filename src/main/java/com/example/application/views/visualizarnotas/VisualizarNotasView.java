package com.example.application.views.visualizarnotas;

import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Visualizar Notas")
@Route(value = "VisualizarNotas", layout = MainLayout.class)
@Uses(Icon.class)
public class VisualizarNotasView extends Composite<VerticalLayout> {

    public VisualizarNotasView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        TextField textField = new TextField();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Select select = new Select();
        HorizontalLayout layoutRow6 = new HorizontalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        Button buttonPrimary = new Button();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        Grid basicGrid = new Grid(SamplePerson.class);
        getContent().setWidthFull();
        getContent().addClassName(Padding.LARGE);
        getContent().setHeightFull();
        layoutColumn2.setWidthFull();
        layoutColumn2.addClassName(Padding.LARGE);
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutRow.setWidthFull();
        layoutRow.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth(null);
        layoutRow2.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        textField.setLabel("Matricula:");
        layoutRow2.setFlexGrow(1.0, textField);
        layoutRow5.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow3.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow4.setHeightFull();
        layoutRow3.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        select.setLabel("Select");
        layoutRow4.setFlexGrow(1.0, select);
        setSelectSampleData(select);
        layoutRow6.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow6);
        layoutRow6.addClassName(Gap.MEDIUM);
        layoutColumn4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn4);
        buttonPrimary.setText("Buscar");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener(e -> {
            String matricula = textField.getValue();
            String periodo = select.getValue().toString();
            visualizarNotaToDatabase(matricula, periodo);
        });
        layoutColumn5.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn5);
        layoutColumn5.setFlexGrow(1.0, basicGrid);
        setGridSampleData(basicGrid);
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutRow);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(layoutRow2);
        layoutRow2.add(textField);
        layoutRow.add(layoutRow5);
        layoutRow.add(layoutRow3);
        layoutRow3.add(layoutRow4);
        layoutRow4.add(select);
        layoutRow.add(layoutRow6);
        layoutColumn2.add(layoutColumn4);
        layoutColumn4.add(buttonPrimary);
        layoutColumn2.add(layoutColumn5);
        layoutColumn5.add(basicGrid);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setSelectSampleData(Select select) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("Primeiro", "Primeiro", null));
        sampleItems.add(new SampleItem("Segundo", "Segundo", null));
        sampleItems.add(new SampleItem("Terceiro", "Terceiro", null));
        sampleItems.add(new SampleItem("Quarto", "Quarto", null));
        select.setItems(sampleItems);
        select.setItemLabelGenerator(item -> ((SampleItem) item).label());
        select.setItemEnabledProvider(item -> !Boolean.TRUE.equals(((SampleItem) item).disabled()));
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(query -> samplePersonService.list(
                        PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
    }

    @Autowired()
    private SamplePersonService samplePersonService;

    private Connection visualizarNotaToDatabase(String matricula, String periodo){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sistema-escolar\\target\\classes\\bancoEscolar.db");
            Statement statement = connection.createStatement();
            System.out.println("Conexão com o SQLite estabelecida com sucesso.");
            String insertQuery = "SELECT * FROM nota WHERE matricula = ? AND periodo = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, matricula);
            preparedStatement.setString(2, periodo);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
            Notification.show("Nota salva com sucesso");
        } catch (SQLException e) {
            // Handle database error and show an error message
            Notification.show("Erro ao salvar nota");
            e.printStackTrace();
        }
        return connection;
    }}

