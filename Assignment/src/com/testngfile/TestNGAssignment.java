package com.testngfile;

import org.testng.annotations.Test;

import com.ExcelKeyword.Keywords;
import com.MainMethods.Functionalities;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;

public class TestNGAssignment {

	Functionalities obj = new Functionalities();

	@Test(priority = 2)
	public void reLogin() {
     obj.selectHamburgerMenu();
     obj.navigateToLoginAndSecurity();
      obj.login1();
	obj.Initialize();
	}

	@Test(priority = 1)
	public void signout() {
        // obj.Initialize();
		obj.login();
		obj.logout();

	}

	@Test(priority = 3)
	public void searchAndBuyMobile() {
		
		obj.Initialize();
		obj.login();
		obj.searchMobile();
		obj.buy();

	}

	@BeforeTest
	public void beforeTest() {
		obj.Initialize();

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Successful Execution!");
	}

	
}
