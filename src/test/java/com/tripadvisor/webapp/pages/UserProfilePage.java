/**
 * 
 */
package com.tripadvisor.webapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tripadvisor.webapp.base.BasePage;
import com.tripadvisor.webapp.utilities.PropertyFileReader;

/**
 * @author Vrushali
 *
 */
public class UserProfilePage extends BasePage {

	@FindBy(css="span[class='OUDwj b brsfY']")
	WebElement userName;
	
	public UserProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public String getTheUserProfilePageTitle() {
		waitForPageTitle(PropertyFileReader.readConfigFile().getProperty("UserProfilePageTitle"));
		return getPageTitle();
	}

}
