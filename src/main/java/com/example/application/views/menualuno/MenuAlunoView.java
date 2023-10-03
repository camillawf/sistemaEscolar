package com.example.application.views.menualuno;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("MenuAluno")
@Route(value = "MenuAluno", layout = MainLayout.class)
@Uses(Icon.class)
public class MenuAlunoView extends Composite<VerticalLayout> {

    public MenuAlunoView() {
        VerticalLayout layoutColumn2 = new VerticalLayout();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn9 = new VerticalLayout();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        H2 h2 = new H2();
        VerticalLayout layoutColumn5 = new VerticalLayout();
        Button buttonPrimary = new Button();
        VerticalLayout layoutColumn6 = new VerticalLayout();
        Button buttonPrimary2 = new Button();
        VerticalLayout layoutColumn7 = new VerticalLayout();
        Button buttonPrimary3 = new Button();
        VerticalLayout layoutColumn8 = new VerticalLayout();
        Button buttonPrimary4 = new Button();
        VerticalLayout layoutColumn10 = new VerticalLayout();
        getContent().setWidthFull();
        getContent().addClassName(Padding.LARGE);
        getContent().setHeightFull();
        layoutColumn2.setWidthFull();
        layoutColumn2.addClassName(Padding.LARGE);
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutRow.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow);
        layoutRow.setFlexGrow(1.0, layoutColumn9);
        layoutColumn9.setWidth(null);
        layoutRow2.setHeightFull();
        layoutRow.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutColumn3.setHeightFull();
        layoutRow2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setWidth(null);
        layoutColumn4.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setJustifyContentMode(JustifyContentMode.CENTER);
        layoutColumn4.setAlignItems(Alignment.CENTER);
        h2.setText("Escolha a opção para prosseguir:");
        h2.setWidthFull();
        layoutColumn4.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        layoutColumn5.addClassName(Padding.SMALL);
        layoutColumn5.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn5);
        buttonPrimary.setText("Atualizar Cadastro do Aluno");
        buttonPrimary.setWidthFull();
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary.addClickListener(event -> {
            UI.getCurrent().navigate("AtualizarAluno");
        });
        layoutColumn5.setFlexGrow(1.0, buttonPrimary);
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn6.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn6);
        layoutColumn6.addClassName(Padding.SMALL);
        buttonPrimary2.setText("Deletar Cadastro do Aluno");
        buttonPrimary2.setWidthFull();
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.addClickListener(event -> {
            UI.getCurrent().navigate("DeletarAluno");
        });
        layoutColumn6.setFlexGrow(1.0, buttonPrimary2);
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn7.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutColumn7);
        layoutColumn7.addClassName(Gap.SMALL);
        layoutColumn7.addClassName(Padding.SMALL);
        buttonPrimary3.setText("Inserir Cadastro do Aluno");
        buttonPrimary3.setWidthFull();
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary3.addClickListener(event -> {
            UI.getCurrent().navigate("InserirAluno");
        });
        layoutColumn7.setFlexGrow(1.0, buttonPrimary3);
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn3.setFlexGrow(1.0, layoutColumn8);
        layoutColumn8.addClassName(Gap.SMALL);
        layoutColumn8.addClassName(Padding.SMALL);
        layoutColumn8.setWidthFull();
        buttonPrimary4.setText("Visualizar Cadastro dos Alunos");
        buttonPrimary4.setWidthFull();
        buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary4.addClickListener(event -> {
            UI.getCurrent().navigate("VisualizarAluno");
        });
        layoutColumn8.setFlexGrow(1.0, buttonPrimary4);
        layoutColumn8.setAlignSelf(FlexComponent.Alignment.CENTER, buttonPrimary4);
        buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutRow.setFlexGrow(1.0, layoutColumn10);
        layoutColumn10.setWidth(null);
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutRow);
        layoutRow.add(layoutColumn9);
        layoutRow.add(layoutRow2);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(layoutColumn4);
        layoutColumn4.add(h2);
        layoutColumn3.add(layoutColumn5);
        layoutColumn5.add(buttonPrimary);
        layoutColumn3.add(layoutColumn6);
        layoutColumn6.add(buttonPrimary2);
        layoutColumn3.add(layoutColumn7);
        layoutColumn7.add(buttonPrimary3);
        layoutColumn3.add(layoutColumn8);
        layoutColumn8.add(buttonPrimary4);
        layoutRow.add(layoutColumn10);
    }
}
