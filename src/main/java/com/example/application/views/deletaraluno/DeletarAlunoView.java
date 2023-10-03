package com.example.application.views.deletaraluno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("DeletarAluno")
@Route(value = "DeletarAluno", layout = MainLayout.class)
@Uses(Icon.class)
public class DeletarAlunoView extends Composite<VerticalLayout> {

    public DeletarAlunoView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        HorizontalLayout layoutRow11 = new HorizontalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        H1 h1 = new H1();
        HorizontalLayout layoutRow12 = new HorizontalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        HorizontalLayout layoutRow13 = new HorizontalLayout();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        HorizontalLayout layoutRow14 = new HorizontalLayout();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        HorizontalLayout layoutRow5 = new HorizontalLayout();
        HorizontalLayout layoutRow15 = new HorizontalLayout();
        HorizontalLayout layoutRow6 = new HorizontalLayout();
        EmailField emailField = new EmailField();
        HorizontalLayout layoutRow7 = new HorizontalLayout();
        TextField textField3 = new TextField();
        HorizontalLayout layoutRow16 = new HorizontalLayout();
        HorizontalLayout layoutRow8 = new HorizontalLayout();
        HorizontalLayout layoutRow17 = new HorizontalLayout();
        HorizontalLayout layoutRow9 = new HorizontalLayout();
        TextField textField4 = new TextField();
        HorizontalLayout layoutRow18 = new HorizontalLayout();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        HorizontalLayout layoutRow10 = new HorizontalLayout();
        HorizontalLayout layoutRow19 = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        HorizontalLayout layoutRow20 = new HorizontalLayout();
        getContent().setWidthFull();
        getContent().addClassName(Padding.LARGE);
        layoutColumn2.setWidthFull();
        layoutColumn2.addClassName(Padding.LARGE);
        layoutColumn3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn3);
        layoutRow.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow11.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow11);
        layoutRow11.addClassName(Gap.MEDIUM);
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        h1.setText("Insira as informações do aluno para realizar alteração:");
        layoutRow12.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow12);
        layoutRow12.addClassName(Gap.MEDIUM);
        layoutColumn4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn4);
        layoutRow3.setWidthFull();
        layoutColumn4.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow13.setHeightFull();
        layoutRow3.setFlexGrow(1.0, layoutRow13);
        layoutRow13.addClassName(Gap.MEDIUM);
        layoutRow4.setHeightFull();
        layoutRow3.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        textField.setLabel("Matricula:");
        textField2.setLabel("Nome Completo:");
        layoutRow4.setFlexGrow(1.0, textField2);
        layoutRow14.setHeightFull();
        layoutRow14.addClassName(Gap.MEDIUM);
        layoutRow3.setFlexGrow(1.0, layoutRow14);
        layoutColumn5.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn5);
        layoutRow5.setWidthFull();
        layoutColumn5.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow15.setHeightFull();
        layoutRow15.addClassName(Gap.MEDIUM);
        layoutRow5.setFlexGrow(1.0, layoutRow15);
        layoutRow6.setHeightFull();
        layoutRow5.setFlexGrow(1.0, layoutRow6);
        layoutRow6.addClassName(Gap.MEDIUM);
        emailField.setLabel("Email");
        layoutRow6.setFlexGrow(1.0, emailField);
        layoutRow7.setHeightFull();
        layoutRow5.setFlexGrow(1.0, layoutRow7);
        layoutRow7.addClassName(Gap.MEDIUM);
        textField3.setLabel("Telefone:");
        layoutRow16.setHeightFull();
        layoutRow16.addClassName(Gap.MEDIUM);
        layoutRow8.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow8);
        layoutRow8.addClassName(Gap.MEDIUM);
        layoutRow17.setHeightFull();
        layoutRow17.addClassName(Gap.MEDIUM);
        layoutRow8.setFlexGrow(1.0, layoutRow17);
        layoutRow9.setHeightFull();
        layoutRow8.setFlexGrow(1.0, layoutRow9);
        layoutRow9.addClassName(Gap.MEDIUM);
        textField4.setLabel("Endereço:");
        layoutRow9.setFlexGrow(1.0, textField4);
        layoutRow18.setHeightFull();
        layoutRow18.addClassName(Gap.MEDIUM);
        layoutRow8.setFlexGrow(1.0, layoutRow18);
        layoutColumn6.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn6);
        layoutRow10.setWidthFull();
        layoutColumn6.setFlexGrow(1.0, layoutRow10);
        layoutRow10.addClassName(Gap.MEDIUM);
        layoutRow19.setHeightFull();
        layoutRow19.addClassName(Gap.MEDIUM);
        layoutRow10.setFlexGrow(1.0, layoutRow19);
        buttonPrimary.setText("Deletar");
        buttonPrimary.addClickListener(e -> {
            String matricula = textField.getValue();
            String nomeCompleto = textField2.getValue();
            String email = emailField.getValue();
            String telefone = textField3.getValue();
            String endereco = textField4.getValue();

            deleteAlunoToDatabase(matricula, nomeCompleto, telefone, email, endereco);
        });
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Voltar");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutRow20.setHeightFull();
        layoutRow10.setFlexGrow(1.0, layoutRow20);
        layoutRow20.addClassName(Gap.MEDIUM);
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(layoutRow);
        layoutRow.add(layoutRow11);
        layoutRow.add(layoutRow2);
        layoutRow2.add(h1);
        layoutRow.add(layoutRow12);
        layoutColumn2.add(layoutColumn4);
        layoutColumn4.add(layoutRow3);
        layoutRow3.add(layoutRow13);
        layoutRow3.add(layoutRow4);
        layoutRow4.add(textField);
        layoutRow4.add(textField2);
        layoutRow3.add(layoutRow14);
        layoutColumn2.add(layoutColumn5);
        layoutColumn5.add(layoutRow5);
        layoutRow5.add(layoutRow15);
        layoutRow5.add(layoutRow6);
        layoutRow6.add(emailField);
        layoutRow5.add(layoutRow7);
        layoutRow7.add(textField3);
        layoutRow5.add(layoutRow16);
        layoutColumn2.add(layoutRow8);
        layoutRow8.add(layoutRow17);
        layoutRow8.add(layoutRow9);
        layoutRow9.add(textField4);
        layoutRow8.add(layoutRow18);
        layoutColumn2.add(layoutColumn6);
        layoutColumn6.add(layoutRow10);
        layoutRow10.add(layoutRow19);
        layoutRow10.add(buttonPrimary);
        layoutRow10.add(buttonPrimary2);
        layoutRow10.add(layoutRow20);
    }

    private Connection deleteAlunoToDatabase(String matricula, String nomeCompleto, String telefone, String email,
                                          String endereco) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sistema-escolar\\target\\classes\\bancoEscolar.db");
            Statement statement = connection.createStatement();
            System.out.println("Conexão com o SQLite estabelecida com sucesso.");
            String deleteQuery = "DELETE FROM aluno WHERE Matricula = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, matricula);

            int rowsDeleted = preparedStatement.executeUpdate();

            if (rowsDeleted > 0) {
                Notification.show("Aluno deletado com sucesso");
            } else {
                Notification.show("Aluno não encontrado");
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            // Handle database error and show an error message
            Notification.show("Erro ao deletar o aluno");
            e.printStackTrace();
        }
        return connection;
    }}