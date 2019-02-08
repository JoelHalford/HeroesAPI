package com.qa.selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {

	@FindBy(id = "nav-register")
	private WebElement navRegister;
	
	@FindBy(id = "username-register")
	private WebElement registerUsername;
	
	@FindBy(id = "password-register")
	private WebElement registerPassword;
	
	@FindBy(id = "username-login")
	private WebElement loginUsername;
	
	@FindBy(id = "password-login")
	private WebElement loginPassword;
	
	@FindBy(id = "register-button")
	private WebElement registerButton;
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	
	

	public void goToRegister() {
		navRegister.click();
	}
	
	public void registerInfo() {
		registerUsername.sendKeys("Selenium");
		registerPassword.sendKeys("Selenium");
		registerButton.click();
	}
	
	public void usernameTooShort() {
		registerUsername.sendKeys("a");
		registerPassword.sendKeys("aaaaaa");
		registerButton.click();
	}
	
	public void usernameTooLong() {
		registerUsername.sendKeys("thisusernameistoolong");
		registerPassword.sendKeys("thisusernameistoolong");
		registerButton.click();
	}
	
	public void usernameWithoutCapital() {
		registerUsername.sendKeys("nocapital");
		registerPassword.sendKeys("nocapital");
		registerButton.click();
	}
	
	public void correctRegister() {
		registerUsername.sendKeys("Selenium");
		registerPassword.sendKeys("Selenium");
		registerButton.click();
	}
	
	public void correctLogin() {
		registerUsername.sendKeys("Selenium");
		registerPassword.sendKeys("Selenium");
		registerButton.click();
	}
	
	public void updateAccount() {
		
	}
	
	public void deleteAccount() {
		
	}
	
	
}
