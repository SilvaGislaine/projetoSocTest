package br.com.soc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.soc.base.BasePage;

public class CredenciadoPage extends BasePage{
	
	public static CredenciadoPage instance;
	

	@FindBy(how = How.XPATH, using = "/html/body/div/div/section[2]/div[1]/div[1]/form/section/div/div[2]")
	public WebElement filtroEmpresa;

	@FindBy(how = How.ID, using = "ipt-busca-credenciado-2")
	public WebElement campoBuscaCredenciada;

	@FindBy(how = How.ID, using = "botao-buscar")
	public WebElement botaoBusca;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/section[2]/div[3]/div[1]/div/div/div/section/div[2]/a/button")
	public WebElement saibaMais;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/section[2]/div[3]/div[1]/div/div/div/section")
	public WebElement resultadoBusca;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"conteudo-resultados\"]/div[1]/div/div/div/section/div[2]/p/span[1]")
	public WebElement nomeEmpresa;
	
	public static synchronized CredenciadoPage getInstance() {
		if (instance == null)
			instance = new CredenciadoPage();
		return instance;
	}
	
	public void initElements() {
		System.out.print("START DRIVE");
		PageFactory.initElements(driver, this);
	}
}
