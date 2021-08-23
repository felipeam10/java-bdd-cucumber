package br.com.felipe.leilao.acceptance.steps;

import br.com.felipe.leilao.model.Lance;
import br.com.felipe.leilao.model.Leilao;
import br.com.felipe.leilao.model.Usuario;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.math.BigDecimal;

public class PropondoLanceSteps {

    private Lance lance;
    private Lance lance10;
    private Lance lance15;
    private Leilao leilao;

    @Given("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("Felipe");
        lance = new Lance(usuario, BigDecimal.TEN);
        leilao = new Leilao("Tablet Sansumg");
    }

    @When("propoe ao leilao")
    public void quando_propoe_o_lance() {
        leilao.propoe(lance);
    }

    @Then("o lance eh aceito")
    public void entao_o_lance_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
    }


//    @Given("varios lances validos")
//    public void varios_lances_validos() {
//        Usuario usuario = new Usuario("Felipe");
//        lance10 = new Lance(usuario, BigDecimal.TEN);
//        Usuario usuario2 = new Usuario("Lidiane");
//        lance15 = new Lance(usuario2, new BigDecimal("15.0"));
//        leilao = new Leilao("Tablet Sansumg");
//    }

    @Given("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario_felipe(Double valor, String nomeUsuario) {
        System.out.println(valor);
        System.out.println(nomeUsuario);
    }

    @When("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        leilao.propoe(lance10);
        leilao.propoe(lance15);
    }

    @Then("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        Assert.assertEquals(2, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
        Assert.assertEquals(new BigDecimal("15.0"), leilao.getLances().get(1).getValor());
    }
}
