package br.com.felipe.leilao.acceptance.steps;

import org.junit.Assert;
import br.com.felipe.leilao.e2e.pages.Browser;
import br.com.felipe.leilao.e2e.pages.LeiloesPage;
import br.com.felipe.leilao.e2e.pages.LoginPage;
import io.cucumber.java.en.*;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Given("o usuario valido")
    public void o_usuario_valido() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @When("realiza login")
    public void realiza_login() {
        leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Then("eh redirecionado para a pagina de leiloes")
    public void eh_redirecionado_para_a_pagina_de_leiloes() {
//        Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
        boolean estaNaPaginaDeLeiloes = new LeiloesPage().estaNaPaginaDeLeiloes();
        Assert.assertTrue(estaNaPaginaDeLeiloes);
    }



    @Given("o usuario invalido")
    public void o_usuario_invalido() {

    }

    @When("tenta se logar")
    public void tenta_se_logar() {

    }

    @Then("continua na página de login")
    public void continua_na_página_de_login() {

    }
}
