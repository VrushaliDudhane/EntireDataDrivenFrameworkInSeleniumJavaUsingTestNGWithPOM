/**
 * 
 */
package com.tripadvisor.webapp.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tripadvisor.webapp.base.BaseTest;
import com.tripadvisor.webapp.pages.HomePage;
import com.tripadvisor.webapp.pages.PuneHomePage;
import com.tripadvisor.webapp.pages.PunePlacesToVisitPage;
import com.tripadvisor.webapp.pages.SignInPage;
import com.tripadvisor.webapp.pages.UserHomePage;
import com.tripadvisor.webapp.pages.UserProfilePage;
import com.tripadvisor.webapp.utilities.PropertyFileReader;

/**
 * @author Vrushali
 *
 */
public class FunctionalTest extends BaseTest {
	private HomePage objHomePage;
	private SignInPage objSignInPage;
	private UserHomePage objUserSignInPage;
	private UserProfilePage objUserProfilePage;
	private PuneHomePage objPuneHomePage;
	private PunePlacesToVisitPage objPunePlacesToVisitPage;
	
	Logger logger=Logger.getLogger(PuneHomePageTest.class.getName());
	
	@Test()
	public void TC_TripAdvisor_PuneHomePage_002()
	{
		String city="Pune";
		String location="Maharashtra, India";
		objHomePage=new HomePage(driver);
		objSignInPage=objHomePage.clickOnSignIn();
		objSignInPage.clickOnContinueWithEmail();
		objUserSignInPage=objSignInPage.signInWithCredentials(PropertyFileReader.readConfigFile().getProperty("emailAddress"),PropertyFileReader.readConfigFile().getProperty("password"));
		logger.trace("User logged in with valid credentials");
		objPuneHomePage=objUserSignInPage.searchPerticularCity(city,location);
		String expectedHeader="Explore Pune";
		String actualHeader=objPuneHomePage.getPuneHomePageHeader();
		Assert.assertEquals(actualHeader, expectedHeader,"Pune Home Page not opened");
		logger.trace("Pune Home Page opened");
		objPunePlacesToVisitPage=objPuneHomePage.clickOnThingsToDo();
		String expectedTitle="30 BEST Places to Visit in Pune - UPDATED 2023 (with Photos & Reviews) - Tripadvisor";
		String actualTitle=objPunePlacesToVisitPage.getPunePlacesToVisitPageTitle();
		Assert.assertEquals(actualTitle,expectedTitle,"Places to visit page not opened");
		String noOfAttractionExpected="659";
		Assert.assertEquals(noOfAttractionExpected,objPunePlacesToVisitPage.getPuneNoOfAttractions());
	}
}
