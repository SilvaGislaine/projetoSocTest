package br.com.soc.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import br.com.soc.pageobjects.BlogPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuscaBlogSteps {
	private static BlogPage page = BlogPage.getInstance();
	
	@Given("que acessei a pagina do blog do soc")
	public void que_acessei_a_pagina_do_blog_soc() {
		page.startDrive();
		page.navegarParaUrl();
	}

	@When("eu clicar no campo de busca")
	public void eu_clicar_no_campo_de_busca() throws InterruptedException {
		page.campoBusca.click();
	}

	@And("preencher o campo com socnet")
	public void preencher_o_campo_com_socnet() {
		page.campoBusca.sendKeys("socnet");
	}

	@And("efetuar o click do botao de busca")
	public void efetuar_o_click_do_botao_de_busca() {
		page.botaoSubmit.click();
	}

	@Then("deve retornar uma lista de artigos")
	public void deve_retornar_uma_lista_de_artigos() {
		assertFalse(page.titulosArtigos.isEmpty());
	}

	@And("o primeiro item seria conheca as vantagens de ser um credenciado da socnet")
	public void o_primeiro_item_seria_conheca_as_vantagens_de_ser_um_credenciado_da_socnet() {
		assertEquals("Conheça as vantagens de ser um credenciado da SOCNET", page.getTituloPrimeiroArtigo());
	}

}
