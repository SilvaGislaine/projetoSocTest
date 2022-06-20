package br.com.soc.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;
	public static Actions actions;

	public static void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C://Users//GISLAINE SILVA//eclipse-workspace//soc-test//drivers//chromedriver.exe");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		actions = new Actions(driver);
	}

}