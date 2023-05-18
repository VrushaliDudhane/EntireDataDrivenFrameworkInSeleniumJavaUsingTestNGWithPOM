/**
 * 
 */
package com.tripadvisor.webapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tripadvisor.webapp.base.BasePage;

/**
 * @author Vrushali
 *
 */
public class PuneHomePage extends BasePage{
	
	@FindBy(css="h1[class='biGQs _P fiohW mowmC izyXJ']>span")
	private WebElement punePageHeader;

	@FindBy(css="div[class='rGQXC _T ivvQp']>div>div>div:nth-of-type(3)>a")
	private WebElement puneThingsToDo;
	
	public PuneHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getPuneHomePageTitle() {
		waitForPageTitle("Pune Tourism (2023): Best of Pune, India - Tripadvisor");
		return getPageTitle();
	}
	
	public String getPuneHomePageHeader() {
		waitForElementToBePresent(punePageHeader);
		return getPageHeader(punePageHeader);
	}
	
	public PunePlacesToVisitPage clickOnThingsToDo()
	{
		waitForElementToBeClickable(puneThingsToDo);
		puneThingsToDo.click();
		return new PunePlacesToVisitPage(driver);
	}

}
