package ca.google;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class GoogleSearchTest {

	WebDriver driver = null;
	SearchPage searchPage = null;

	@BeforeTest
	public void setup () throws IOException {
		Properties browserConfigProps = new Properties();
		FileInputStream fis = new FileInputStream("config.cfg");

		browserConfigProps.load(fis);
		String browserType = browserConfigProps.getProperty("browser");

		if (browserType.equalsIgnoreCase("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saighi Ilyass\\Desktop\\Automation\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("FIREFOX")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saighi Ilyass\\Desktop\\Automation\\WebDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
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
