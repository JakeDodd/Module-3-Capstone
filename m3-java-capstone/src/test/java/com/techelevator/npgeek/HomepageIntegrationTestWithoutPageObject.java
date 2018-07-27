package com.techelevator.npgeek;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class HomepageIntegrationTestWithoutPageObject {

	private static WebDriver webDriver;
	
	@BeforeClass
	public static void openWebBrowserForTesting() {
		String homeDir = System.getProperty("user.home");
	
		System.setProperty("webdriver.chrome.driver", homeDir+"/dev-tools/chromedriver/chromedriver");
		webDriver= new ChromeDriver();
	}
	
	@Before
	public void openHomePage() {
		webDriver.get("Http://localhost:8080/m3-java-capstone/homepage");
	}
	
	@AfterClass
	public static void closeWebBrowser() {
		webDriver.close();
		webDriver.quit();
	}
	
	@Test
	public void elements_can_be_found_by_css_class() {
		List<WebElement> parkInfo = webDriver.findElements(By.className("completeParkContainer"));
		Assert.assertNotNull(parkInfo);
		Assert.assertEquals(10, parkInfo.size());
	}
	
	@Test
	public void clicking_on_links_navigates_to_pages() {
		WebElement homePageLink = webDriver.findElement(By.linkText("Home"));
		homePageLink.click();
		Assert.assertTrue(webDriver.getTitle().endsWith("Home Page"));
		
		WebElement surveyLink = webDriver.findElement(By.linkText("Survey"));
		surveyLink.click();
		Assert.assertTrue(webDriver.getTitle().endsWith("Survey"));
	}
}
