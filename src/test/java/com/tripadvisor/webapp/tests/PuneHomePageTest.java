/**
 * 
 */
package com.tripadvisor.webapp.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tripadvisor.webapp.base.BaseTest;
import com.tripadvisor.webapp.pages.HomePage;
import com.tripadvisor.webapp.pages.PuneHomePage;
import com.tripadvisor.webapp.pages.SignInPage;
import com.tripadvisor.webapp.pages.UserHomePage;
import com.tripadvisor.webapp.pages.UserProfilePage;
import com.tripadvisor.webapp.utilities.PropertyFileReader;

/**
 * @author Vrushali
 *
 */
public class PuneHomePageTest extends BaseTest{
	private HomePage objHomePage;
	private SignInPage objSignInPage;
	private UserHomePage objUserSignInPage;
	private UserProfilePage objUserProfilePage;
	private PuneHomePage objPuneHomePage;
	
	Logger logger=Logger.getLogger(PuneHomePageTest.class.getName());
	
	@Test()
	public void TC_TripAdvisor_PuneHomePage_001()
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
	}
	
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
		objPuneHomePage.clickOnThingsToDo();
	}

}
