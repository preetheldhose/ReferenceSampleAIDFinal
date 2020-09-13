/**
 * 
 */
package com.yahoo.TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.yahoo.Pages.LoginPageNew;

import Helper.BrowserFactory;

/**
 * @author Preeth Eldhose
 *
 */
public class VerfiyYahooLoginTCFinal {
	
	
		   WebDriver driver;
	public String baseUrl;
	public Properties prop;
	public String Login_User;
	public String Login_Passwd;
	
	public void checkEleLoaded(WebDriver ndriver, String passedXpath) {
		driver = ndriver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passedXpath)));
	}
	
	public void checkEleWname(String passedName) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(passedName)));
	}
	
	@BeforeTest
	public void setUp() throws FileNotFoundException, IOException
	{
		  
		prop = new Properties();
		prop.load(new FileInputStream("./Configuration/configurations"));		
		baseUrl=prop.getProperty("baseUrlActual");  		
		Login_User=prop.getProperty("userName");
		Login_Passwd=prop.getProperty("passWord");	
		BrowserFactory bf = new BrowserFactory();
		driver = bf.startBrowser("chrome", baseUrl);
	
	}
	
	@Test
	public void validYahooLogin() throws InterruptedException {
		
		LoginPageNew login_page_new  = PageFactory.initElements(driver, LoginPageNew.class);
		String mailIcon = login_page_new.mail_icon();
		checkEleLoaded(driver, mailIcon);
		login_page_new.mail_icon_click(driver);
		

		boolean signin = driver.getPageSource().contains("Sign in");
		if(signin) {
		  login_page_new.signin_icon_click(driver);
		  System.out.println("fyi : found Sign in on page & clicked it");
		} else {
			System.out.println("fyi : no Sign in on page");
		}
		
		System.out.println("About to login into Yahoo Mail");
		login_page_new.login_into_YahooMail(Login_User, Login_Passwd);
		
		System.out.println("About to login out of Yahoo Mail");
		login_page_new.mail_LogOut();
		
		System.out.println("About to close the browser");
		driver.close();
		
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}
}
