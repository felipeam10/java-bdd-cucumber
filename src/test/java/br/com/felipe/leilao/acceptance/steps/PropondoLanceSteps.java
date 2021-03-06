package br.com.felipe.leilao.acceptance.steps;

import br.com.felipe.leilao.model.Lance;
import br.com.felipe.leilao.model.Leilao;
import br.com.felipe.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropondoLanceSteps {

    private Lance lance;
    private Leilao leilao;
    private ArrayList<Lance> lista;

    @Before
    public void setup(){
        this.lista = new ArrayList<>();
        leilao = new Leilao("Tablet Sansumg");
    }

    //v3.4  
    @After
    public void tearDown(){
//        System.out.println("after");
    }

    @Given("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("Felipe");
        lance = new Lance(usuario, BigDecimal.TEN);
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




    @Given("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario_felipe(Double valor, String nomeUsuario) {
        Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
        lista.add(lance);
    }

    @When("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        this.lista.forEach(lance -> leilao.propoe(lance));
    }

    @Then("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        Assert.assertEquals(this.lista.size(), leilao.getLances().size());
        Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
    }




    @Given("um lance invalido de {double} reais e do usuario {string}")
    public void um_lance_invalido_de_reais(Double valor, String nomeUsuario) {
//      System.out.println(nomeUsuario);
        this.lance = new Lance(new BigDecimal(valor));
    }

    @Then("o lance nao eh aceito")
    public void o_lance_nao_eh_aceito() {
        Assert.assertEquals(0, leilao.getLances().size());
    }



    @Given("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String, String>> valores = dataTable.asMaps();
        for (Map<String, String> mapa : valores) {
            String valor = mapa.get("valor");
            String nome = mapa.get("nomeUsuario");
            Lance lance = new Lance(new Usuario(nome), new BigDecimal(valor));
            lista.add(lance);
        }
    }

    @Then("o segundo lance nao eh aceito")
    public void o_segundo_lance_nao_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
    }
}
