package br.com.soc.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.soc.base.BasePage;

public class SocnetPage extends BasePage{
	
	public static SocnetPage instance;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/section[1]/div/div/div/div/div/section/div/div/div/div/div/div[4]/div/div/a")
	public WebElement botaoBuscarCredenciado;
	
	public static synchronized SocnetPage getInstance() {
		if (instance == null)
			instance = new SocnetPage();
		return instance;
	}
	
	public void initElements() {
		System.out.print("START DRIVE");
//		BasePage.setup();
		PageFactory.initElements(driver, this);
	}
}
