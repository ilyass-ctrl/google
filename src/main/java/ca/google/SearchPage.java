/*
 * searchFunction testing.
 */
package ca.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage {
	
	protected WebDriver driver = null;
	
	public SearchPage (WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy (css = "input.gLFyf.gsfi")
	WebElement searchField;
	
	@FindBy (css = "#tsf > div:nth-child(2) > div.A8SBwf.emcav > div.UUbT9 > div.aajZCb > div.VlcLAe > center > input.gNO89b")
	WebElement searchBtn;
	
	public void search(String word) {
		searchField.sendKeys(word);
		searchBtn.click();
	}

}
