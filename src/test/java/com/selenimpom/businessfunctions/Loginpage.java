package com.selenimpom.businessfunctions;

import org.openqa.selenium.WebDriver;

import com.seleniumpom.utilities.WebActions;

public class Loginpage extends WebActions {


	public Loginpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void set(){
		System.out.println("browser opened");
	}
}
