package br.com.felipe.leilao.acceptance.steps;

import br.com.felipe.leilao.model.Lance;
import br.com.felipe.leilao.model.Leilao;
import br.com.felipe.leilao.model.Usuario;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.math.BigDecimal;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;

    @Given("Dado um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("Felipe");
        lance = new Lance(usuario, BigDecimal.TEN);
    }

    @When("Quando propoe o lance")
    public void quando_propoe_o_lance() {
        leilao = new Leilao("Tablet Sansumg");
        leilao.propoe(lance);
    }

    @Then("Entao o lance eh aceito")
    public void entao_o_lance_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }
}
