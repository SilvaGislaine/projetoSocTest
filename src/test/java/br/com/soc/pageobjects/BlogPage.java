package br.com.soc.pageobjects;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.soc.base.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;


public class BlogPage extends BasePage {

	public static final String BuscarCredenciado = null;

	private static BlogPage instance;

	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/section[1]/div/div/div/div/div/section[2]/div/div/div[2]/div/div/div/div/form/div/input")
	public WebElement campoBusca;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/header[1]/div/div/div/div/div/section[2]/div/div/div/div/div/div[2]/div/nav[1]/ul/li[2]/a")
	public WebElement funcionalidades;

	@FindBy(how = How.CLASS_NAME, using = "menu-item-294")
	public WebElement redeSocNet;
	
	@FindBy(how = How.CLASS_NAME, using = "elementor-search-form__submit")
	public WebElement botaoSubmit;

	@FindAll(@FindBy(how = How.CLASS_NAME, using = "elementor-post__title"))
	public List<WebElement> titulosArtigos;

	public WebElement botaoBuscarCredenciado;

	public Object buscarCredenciado;

	public static synchronized BlogPage getInstance() {
		if (instance == null)
			instance = new BlogPage();
		return instance;
	}
	
	public void startDrive() {
		System.out.print("START DRIVE");
		BasePage.setup();
		PageFactory.initElements(driver, this);
	}

	public void navegarParaUrl() {
		driver.get("https://www.soc.com.br/blog-de-sst/");
	}
	
	public String getTituloPrimeiroArtigo() {
		if(!this.titulosArtigos.isEmpty()) {
			return this.titulosArtigos.get(0).getText();			
		}
		
		return StringUtils.EMPTY;
	}

	@After
	public void closeBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
		    byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		    scenario.attach(screenshot, "image/png", "name");
		}
		System.out.print("QUIT");
		driver.close();
	}

}