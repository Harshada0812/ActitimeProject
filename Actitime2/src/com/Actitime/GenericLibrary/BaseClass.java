
package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Actitime.pom_ObjectRepository.LoginPage;

public class BaseClass {
	
	FileLibrary fl = new FileLibrary();
	
	public static WebDriver driver;
	@BeforeSuite
	public void databaseConnect() {
		Reporter.log("Database Connected",true);
	}
	@BeforeClass
	public void lauchBrowser () {
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.actitime.com/login.do");
		Reporter.log("Browser is launched",true);
	}
	@BeforeMethod
	public void logIn() throws IOException {
		
		LoginPage lp = new LoginPage(driver);
		
		String un = fl.dataFromPropertyFile("username");
		lp.getUntbx().sendKeys(un);
		
		String pwd = fl.dataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(pwd);
		
		lp.getLgbtn().click();
		Reporter.log("LoggedIn to actitime",true);
	}
	@Test
	public void createCustomer() {
		Reporter.log("Customer is created",true);
	}
	@AfterMethod
	public void logOut() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Logout sucessfully",true);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
		Reporter.log("Browser is closed", true);
	}
	@AfterSuite
	public void DisconnectDatabase() {
		Reporter.log("Database is Disconnected",true);
	}
}