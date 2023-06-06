package com.Actitime.pom_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage {
	
	//Declaration
	
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newCust;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement custdesp;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createBtn;
	//initialization
	public TaskPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}


	public WebElement getNewCust() {
		return newCust;
	}

		public WebElement getCustname() 
	{
		return custname;
	}


	public WebElement getCustdesp() {
		return custdesp;
	}

	

	public WebElement getCreateBtn() {
		return createBtn;
	}

	
	
	

}
