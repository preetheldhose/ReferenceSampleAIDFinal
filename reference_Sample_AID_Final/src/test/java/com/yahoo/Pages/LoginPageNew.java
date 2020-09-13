/**
 * 
 */
package com.yahoo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Preeth eldhose
 *
 */
public class LoginPageNew {
	
	//driver from PF will be used here.
	public LoginPageNew(WebDriver ldriver) {
		
		this.driver=ldriver;
		
	}
	
	WebDriver driver;
	
	@FindBy(name="username") 
	WebElement user_name;
	
	@FindBy(how=How.XPATH, using=".//*[@id='login-signin']")
	WebElement next_value;
	
	@FindBy(how=How.NAME, using="password")
	WebElement pass_word;
	
	@FindBy(how=How.NAME, using ="verifyPassword")
	WebElement submit_button;
	
	public String uVal() {
		String userVal = "username";
		return userVal;
	}
	
	public String nVal() {
		String nextVal = ".//*[@id='login-signin']";
		return nextVal;
	}
	
	public String pVal() {
		String passVal = "password";
		return passVal;
	}
	
	
	public String sbVal() {
		String submitVal = "verifyPassword";
		return submitVal;
	}
	
	public void login_into_YahooMail(String uid, String passwd) {
		
		checkEleWithname(driver, uVal());
		user_name.sendKeys(uid);
		checkEleXpath(driver, nVal());
		next_value.click();
		checkEleWithname(driver, pVal());
		pass_word.sendKeys(passwd);
		checkEleWithname(driver, sbVal());
		submit_button.click();
		
	}
	
	public String sign_icon() {
		
		String signIconVal = "//*[@id='signin-main']/div[1]/a[2]/span";
		return signIconVal;
		
	}
	
	public void signin_icon_click(WebDriver sncdriver) {
		
		driver = sncdriver;
		String mailIconVal = "/html/body/div[1]/a[2]/span";
		System.out.println("inside mail_icon_click + 1 " + mailIconVal);
		driver.findElement(By.xpath(mailIconVal)).click();
		
	}
	
	public String mail_icon() {
		
		String mailIconVal = "/html/body/header/div[2]/div/div/div/div/div[3]/div/div[3]/div[3]/div/a/span[2]";
		return mailIconVal;
	}
	

	public void mail_icon_click(WebDriver mnewdriver) {
	
		driver = mnewdriver;
		String mailIconVal = "/html/body/header/div[2]/div/div/div/div/div[3]/div/div[3]/div[3]/div/a/span[2]";
		driver.findElement(By.xpath(mailIconVal)).click();		System.out.println("inside mail_icon_click + 2 " + mailIconVal);
	
	}
	
	public String mail_dropDown_icon() {
		
		String dropDown = ".//*[@id='ybar-inner-wrap']/div[2]/div/div[3]/div[1]/div/label/span";
		return dropDown;
		
	}
	
	public String signOut_icon() {
		
		String signOutVl = ".//*[@id='ybarAccountMenuBody']/a[3]/span[2]";
		return signOutVl;
		
	}
	
	public void mail_LogOut() {
		
		checkEleXpath(driver, mail_dropDown_icon());
	    WebElement dropDown = driver.findElement(By.xpath(".//*[@id='ybar-inner-wrap']/div[2]/div/div[3]/div[1]/div/label/span"));
	    dropDown.click();
	    checkEleXpath(driver, signOut_icon());
	    driver.findElement(By.xpath(".//*[@id='ybarAccountMenuBody']/a[3]/span[2]")).click();

	}
	
	public void checkEleXpath(WebDriver cedriver, String passedXpath) {

		cedriver = driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(passedXpath)));

	}
	
	public void checkEleWithname(WebDriver cdriver, String passedName) {
		
		cdriver = driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(passedName)));		System.out.println("Inside checkEleWithname + 2 ");
		
	}
	
}
