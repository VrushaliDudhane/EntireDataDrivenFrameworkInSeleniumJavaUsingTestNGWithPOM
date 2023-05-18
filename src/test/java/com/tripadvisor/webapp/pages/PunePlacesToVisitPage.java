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
public class PunePlacesToVisitPage extends BasePage{

	@FindBy(xpath="//table[@class='flWFV']/tbody/tr[1]/td")
	private WebElement noOfAttractions;
	
	public PunePlacesToVisitPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public String getPunePlacesToVisitPageTitle() {
		waitForPageTitle("30 BEST Places to Visit in Pune - UPDATED 2023 (with Photos & Reviews) - Tripadvisor");
		return getPageTitle();
	}
	
	public String getPuneNoOfAttractions() {
		waitForElementToBePresent(noOfAttractions);
		return noOfAttractions.getText();
	}
	
	

}
