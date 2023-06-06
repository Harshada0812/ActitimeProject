package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.BaseClass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.pom_ObjectRepository.HomePage;
import com.Actitime.pom_ObjectRepository.LoginPage;
import com.Actitime.pom_ObjectRepository.TaskPage;

public class CreateCustomer extends BaseClass{
@Test
public void createcustomer() throws EncryptedDocumentException, IOException
{ 
	
	HomePage hp = new HomePage(driver);
	hp.getTasktab().click();
	
	TaskPage tp = new TaskPage(driver);
	tp.getAddNewBtn().click();
	tp.getNewCust().click();
	
	FileLibrary fl = new FileLibrary();
	String custname = fl.readDataFromExcel("Data", 1, 1);
	tp.getCustname().sendKeys(custname);
	
	String custdesp = fl.readDataFromExcel("Data", 1, 2);
	tp.getCustdesp().sendKeys(custdesp);
	
	tp.getCreateBtn().click();
	
	String expectedResult = custname;
	String actualResult = driver.findElement(By.xpath("(//div[.='"+custname+"'])[2]")).getText();
	
	//we will use assertion to compare expected and actual data
	
	SoftAssert s = new SoftAssert();
	//soft assert has non-static methods
    s.assertEquals(actualResult, expectedResult);
	s.assertAll();
	
	
	
	
	
	

	
}
	
}
