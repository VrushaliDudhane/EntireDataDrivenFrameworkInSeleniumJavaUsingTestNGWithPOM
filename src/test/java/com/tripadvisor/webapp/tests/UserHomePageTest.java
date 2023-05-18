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

public class UserHomePageTest extends BaseTest {

	private HomePage objHomePage;
	private SignInPage objSignInPage;
	private UserHomePage objUserSignInPage;
	private UserProfilePage objUserProfilePage;
	private PuneHomePage objPuneHomePage;
	
	Logger logger=Logger.getLogger(UserHomePageTest.class.getName());
	
	@Test(enabled=false)
	public void TC_TripAdvisor_UserHomePage_001()
	{
		objHomePage=new HomePage(driver);
		Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		objSignInPage.clickOnContinueWithEmail();
		objUserSignInPage=objSignInPage.signInWithCredentials(PropertyFileReader.readConfigFile().getProperty("emailAddress"),PropertyFileReader.readConfigFile().getProperty("password"));
		String expectedTitle= "Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more";
		String actualTitle=objUserSignInPage.getTheUserHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Wrong Page Opened");
		logger.trace("User logged in with valid credentials");
		objUserProfilePage=objUserSignInPage.viewUserProfile();
		String actualUserProfilePageTitle=objUserProfilePage.getTheUserProfilePageTitle();
		String expectedUserProfilePageTitle=PropertyFileReader.readConfigFile().getProperty("UserProfilePageTitle");
		Assert.assertEquals(actualUserProfilePageTitle, expectedUserProfilePageTitle, "Wrong User profile Opened");
	}
	
	@Test()
	public void TC_TripAdvisor_UserHomePage_002()
	{
		String city="Pune";
		String location="Maharashtra, India";
		objHomePage=new HomePage(driver);
		//Assert.assertEquals(objHomePage.isLogoDisplayed(), true);
		objSignInPage=objHomePage.clickOnSignIn();
		objSignInPage.clickOnContinueWithEmail();
		objUserSignInPage=objSignInPage.signInWithCredentials(PropertyFileReader.readConfigFile().getProperty("emailAddress"),PropertyFileReader.readConfigFile().getProperty("password"));
		//String expectedTitle= "Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more";
		//String actualTitle=objUserSignInPage.getTheUserHomePageTitle();
		//Assert.assertEquals(actualTitle, expectedTitle, "Wrong Page Opened");
		logger.trace("User logged in with valid credentials");
		objUserSignInPage.clickOnThingsToDo();
		objUserSignInPage.searchPerticularCityThingsToDo(city,location);
		
		
	}
	
	@Test(enabled=false)
	public void TC_TripAdvisor_UserHomePage_003()
	{
		String city="Pune";
		String location="Maharashtra, India";
		objHomePage=new HomePage(driver);
		objSignInPage=objHomePage.clickOnSignIn();
		objSignInPage.clickOnContinueWithEmail();
		objUserSignInPage=objSignInPage.signInWithCredentials(PropertyFileReader.readConfigFile().getProperty("emailAddress"),PropertyFileReader.readConfigFile().getProperty("password"));
		logger.trace("User logged in with valid credentials");
		objPuneHomePage=objUserSignInPage.searchPerticularCity(city,location);
		String expectedTitle="Pune Tourism (2023): Best of Pune, India - Tripadvisor";
		String actualTitle=objPuneHomePage.getPuneHomePageTitle();
		Assert.assertEquals(actualTitle, expectedTitle,"Pune Home Page not opened");
		logger.trace("Pune Home Page opened");
	}
	
	
	
//	@Test()
//	public void TC_TripAdvisor_UserHomePage_004()
//	{
//		String city="Frankfurt";
//		String location="Hesse, Germany";
//		objHomePage=new HomePage(driver);
//		objSignInPage=objHomePage.clickOnSignIn();
//		objSignInPage.clickOnContinueWithEmail();
//		objUserSignInPage=objSignInPage.signInWithCredentials(PropertyFileReader.readConfigFile().getProperty("emailAddress"),PropertyFileReader.readConfigFile().getProperty("password"));
//		logger.trace("User logged in with valid credentials");
//		objPuneHomePage=objUserSignInPage.searchPerticularCity(city,location);
//		String expectedTitle="Frankfurt Tourism (2023): Best of Frankfurt, Germany - Tripadvisor";//"Pune Tourism (2023): Best of Pune, India - Tripadvisor";
//		String actualTitle=objPuneHomePage.getPuneHomePageTitle();
//		Assert.assertEquals(actualTitle, expectedTitle,"Pune Home Page not opened");
//		
//	}
}
