package com.example.application.views.inserirnota;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Inserir Nota")
@Route(value = "InserirNota", layout = MainLayout.class)
@Uses(Icon.class)
public class InserirNotaView extends Composite<VerticalLayout> {

    public InserirNotaView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn8 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        H2 h2 = new H2();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        TextField textField = new TextField();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Select select = new Select();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        HorizontalLayout layoutRow6 = new HorizontalLayout();
        TextField textField2 = new TextField();
        HorizontalLayout layoutRow7 = new HorizontalLayout();
        TextField textField3 = new TextField();
        VerticalLayout layoutColumn7 = new VerticalLayout();
        HorizontalLayout layoutRow8 = new HorizontalLayout();
        HorizontalLayout layoutRow9 = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        HorizontalLayout layoutRow10 = new HorizontalLayout();
        VerticalLayout layoutColumn9 = new VerticalLayout();
        getContent().setWidthFull();
        getContent().addClassName(Padding.LARGE);
        layoutColumn2.setWidthFull();
        layoutColumn2.addClassName(Padding.LARGE);
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutRow.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow);
        layoutRow.setFlexGrow(1.0, layoutColumn8);
        layoutColumn8.setWidth(null);
        layoutColumn3.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth(null);
        layoutColumn4.setWidth(null);
        h2.setText("Insira as informações do aluno que deseja inserir a nota:");
        layoutColumn5.setWidthFull();
        layoutRow2.setWidthFull();
        layoutColumn5.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow3.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        textField.setLabel("Matricula:");
        layoutRow3.setFlexGrow(1.0, textField);
        layoutRow4.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        select.setLabel("Período:");
        layoutRow4.setFlexGrow(1.0, select);
        setSelectSampleData(select);
        layoutColumn6.setWidthFull();
        layoutRow5.setWidthFull();
        layoutColumn6.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow6.setHeightFull();
        layoutRow5.setFlexGrow(1.0, layoutRow6);
        layoutRow6.addClassName(Gap.MEDIUM);
        textField2.setLabel("Descrição:");
        layoutRow6.setFlexGrow(1.0, textField2);
        layoutRow7.setHeightFull();
        layoutRow5.setFlexGrow(1.0, layoutRow7);
        layoutRow7.addClassName(Gap.MEDIUM);
        textField3.setLabel("Nota:");
        layoutColumn7.setWidthFull();
        layoutRow8.setWidthFull();
        layoutColumn7.setFlexGrow(1.0, layoutRow8);
        layoutRow8.addClassName(Gap.MEDIUM);
        layoutRow8.setFlexGrow(1.0, layoutRow9);
        layoutRow9.addClassName(Gap.MEDIUM);
        buttonPrimary.setText("Salvar");
        buttonPrimary.addClickListener(e -> {
            String matricula = textField.getValue();
            String periodo = select.getValue().toString();
            String descricao = textField2.getValue();
            String nota = textField3.getValue();

            addNotaToDatabase(matricula, periodo, descricao, nota);
        });
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Voltar");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutRow10.setHeightFull();
        layoutRow8.setFlexGrow(1.0, layoutRow10);
        layoutRow10.addClassName(Gap.MEDIUM);
        layoutRow.setFlexGrow(1.0, layoutColumn9);
        layoutColumn9.setWidth(null);
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutRow);
        layoutRow.add(layoutColumn8);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(layoutColumn4);
        layoutColumn4.add(h2);
        layoutColumn3.add(layoutColumn5);
        layoutColumn5.add(layoutRow2);
        layoutRow2.add(layoutRow3);
        layoutRow3.add(textField);
        layoutRow2.add(layoutRow4);
        layoutRow4.add(select);
        layoutColumn3.add(layoutColumn6);
        layoutColumn6.add(layoutRow5);
        layoutRow5.add(layoutRow6);
        layoutRow6.add(textField2);
        layoutRow5.add(layoutRow7);
        layoutRow7.add(textField3);
        layoutColumn3.add(layoutColumn7);
        layoutColumn7.add(layoutRow8);
        layoutRow8.add(layoutRow9);
        layoutRow9.add(buttonPrimary);
        layoutRow9.add(buttonPrimary2);
        layoutRow8.add(layoutRow10);
        layoutRow.add(layoutColumn9);
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
    private Connection addNotaToDatabase(String matricula, String periodo, String descricao, String nota){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sistema-escolar\\target\\classes\\bancoEscolar.db");
            Statement statement = connection.createStatement();
            System.out.println("Conexão com o SQLite estabelecida com sucesso.");
            String insertQuery = "INSERT INTO nota (Matricula,Nota,Descricao,Periodo) VALUES(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, matricula);
            preparedStatement.setString(2, nota);
            preparedStatement.setString(3, descricao);
            preparedStatement.setString(4, periodo);

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
