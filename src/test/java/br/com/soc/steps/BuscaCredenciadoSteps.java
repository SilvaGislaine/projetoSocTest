package br.com.soc.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;

import br.com.soc.pageobjects.BlogPage;
import br.com.soc.pageobjects.CredenciadoPage;
import br.com.soc.pageobjects.SocnetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuscaCredenciadoSteps {
	private static BlogPage blogPage = BlogPage.getInstance();
	private static SocnetPage socnetPage = SocnetPage.getInstance();
	private static CredenciadoPage credPage = CredenciadoPage.getInstance();
	
	@Given("que entrei na pagina do blog do soc")
	public void acessarPaginaBlog() {
		blogPage.startDrive();
		blogPage.navegarParaUrl();
	}

	@When("efetuar click funcionalidades")
	public void efetuar_click_funcionalidades() throws InterruptedException {
		blogPage.funcionalidades.click();
	}

	@And("efetuar click na rede socnet")
	public void efetuar_click_na_rede_socnet() throws InterruptedException {
		blogPage.redeSocNet.click();
	}

	@When("direcionado a pagina de socnet clicar busca de credenciados")
	public void direcionado_a_pagina_de_socnet_clicar_busca_de_credenciados() throws InterruptedException{
		socnetPage.initElements();
		socnetPage.botaoBuscarCredenciado.click();
	}
	
	@When ("efetuar click filtro empresa")
	public void efetuar_click_filtro_empresa() {
		credPage.initElements();
		credPage.filtroEmpresa.click();
	}
	
	@And ("efetuar click no campo busca")
	public void efetuar_click_no_campo_busca() {
		credPage.campoBuscaCredenciada.click();
	}
	
    @And ("preencher campo busca perfil prime")
    public void preencher_campo_busca_perfil_prime() {
		credPage.campoBuscaCredenciada.sendKeys("perfil prime");
	}
	
    @And ("efetuar click no botao de busca")
    public void efetuar_click_no_botao_de_busca() {
    	credPage.botaoBusca.click();
	}
	
    @And ("deve retorna resultado")
    public void deve_retorna_resultado() {
		assertEquals("PERFIL PRIME GESTÃO OCUPACIONAL", credPage.nomeEmpresa.getText());
	}
	
    @Then ("efetuar click em saiba mais")
    public void efetuar_click_filtro_em_saiba_mais() throws InterruptedException {
    	Thread.sleep(2000);
    	credPage.actions.moveToElement(credPage.resultadoBusca).perform();;
    	Thread.sleep(2000);
    	credPage.saibaMais.click();
	}
}
