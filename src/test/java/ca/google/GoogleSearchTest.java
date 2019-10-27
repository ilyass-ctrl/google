package ca.google;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class GoogleSearchTest {

	WebDriver driver = null;
	SearchPage searchPage = null;

	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saighi Ilyass\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.ca/");
		searchPage = PageFactory.initElements(driver, SearchPage.class);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	@Test
	public void searchFunctionTest() {
		searchPage.search("wolf wallpapers 4k");
	}

}
