package com.example.application.views;

import com.example.application.views.atualizaraluno.AtualizarAlunoView;
import com.example.application.views.atualizarnota.AtualizarNotaView;
import com.example.application.views.deletaraluno.DeletarAlunoView;
import com.example.application.views.deletarnota.DeletarNotaView;
import com.example.application.views.inseriraluno.InserirAlunoView;
import com.example.application.views.inserirnota.InserirNotaView;
import com.example.application.views.menu.MenuView;
import com.example.application.views.menualuno.MenuAlunoView;
import com.example.application.views.menunota.MenuNotaView;
import com.example.application.views.visualizarAlunos.VisualizarAlunosView;
import com.example.application.views.visualizarnotas.VisualizarNotasView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        H1 appName = new H1("Sistema Escolar");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("Menu", MenuView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Menu Aluno", MenuAlunoView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("AtualizarAluno", AtualizarAlunoView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Deletar Aluno", DeletarAlunoView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Inserir Aluno", InserirAlunoView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Menu Nota", MenuNotaView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Atualizar Nota", AtualizarNotaView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Deletar Nota", DeletarNotaView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Inserir Nota", InserirNotaView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Visualizar Notas", VisualizarNotasView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Visualizar Alunos", VisualizarAlunosView.class, LineAwesomeIcon.USER.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
