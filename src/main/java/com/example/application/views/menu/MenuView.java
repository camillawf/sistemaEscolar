package com.example.application.views.menu;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Menu")
@Route(value = "Menu", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class MenuView extends Composite<VerticalLayout> {

    public MenuView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        H2 h2 = new H2();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        Button buttonPrimary = new Button();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        Button buttonPrimary2 = new Button();
        getContent().setWidthFull();
        getContent().addClassName(Padding.LARGE);
        getContent().setHeightFull();
        layoutRow.setWidthFull();
        h2.setText("Selecione o tipo desejado:");
        layoutRow.setFlexGrow(1.0, h2);
        layoutRow.setAlignSelf(FlexComponent.Alignment.CENTER, h2);
        layoutColumn2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn3);
        buttonPrimary.setText("Alunos");
        buttonPrimary.setWidthFull();
        buttonPrimary.addClickListener(event -> {
            UI.getCurrent().navigate("MenuAluno");
        });
        layoutColumn3.setFlexGrow(1.0, buttonPrimary);
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutColumn4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn4);
        buttonPrimary2.setText("Notas");
        buttonPrimary2.setWidthFull();
        buttonPrimary2.addClickListener(event -> {
            UI.getCurrent().navigate("MenuNotas");
        });
        layoutColumn4.setFlexGrow(1.0, buttonPrimary2);
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(h2);
        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutColumn3);
        layoutColumn3.add(buttonPrimary);
        layoutColumn2.add(layoutColumn4);
        layoutColumn4.add(buttonPrimary2);
    }
}
