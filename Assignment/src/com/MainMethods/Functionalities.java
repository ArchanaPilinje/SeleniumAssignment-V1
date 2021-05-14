package com.MainMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ExcelKeyword.Keywords;

public class Functionalities {
	WebDriver driver = new ChromeDriver();

	public void Initialize() {
		System.out.println("Launching the Chrome Browser");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		System.out.println("Navigating to Amazon website");
		String baseUrl = "http://www.amazon.in/";
		driver.navigate().to(baseUrl);
		 driver.manage().window().maximize();
	}
	
	public void login() {
		Keywords excelFile=new Keywords();
		 excelFile.setInputFile("E:/KeywordDrivenCheck.xls");
	     try {
			excelFile.loginCredentials();
		} catch (IOException e) {
			System.out.println(e);
		}
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		WebElement username = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		if(username.isDisplayed()) {
		username.sendKeys(excelFile.id);
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();}
		else {
		System.out.println("Not displayed username");
		}
		WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		if (password.isDisplayed()) {
			System.out.println("Pasword field is displayed");
			password.sendKeys(excelFile.pwd);
			driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		} else {
			System.out.println("Password field is not displayed");
		}
	}
	
	public void searchMobile() {
		Keywords excelFile=new Keywords();
		 excelFile.setInputFile("E:/KeywordDrivenCheck.xls");
	     try {
			excelFile.testData();
		} catch (IOException e) {
			System.out.println(e);
		}
	     WebElement searchBox=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
	     searchBox.sendKeys(excelFile.phone);
	     driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]")).click();
        
	}
	
	public void buy(){
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/h2/a/span")).click();
		for(String childWindow:driver.getWindowHandles())
		if(!childWindow.equals(parentWindow))
		    driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
		
	}
	
	public void logout() {
		Actions actions = new Actions(driver);
		 WebElement menuOption = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]"));
		 actions.moveToElement(menuOption);
		 WebElement signOut=driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span"));
		 actions.moveToElement(signOut);
		 actions.click().build().perform();
	}
	
	public void selectHamburgerMenu() {
		driver.findElement(By.xpath("//*[@id=\"nav-hamburger-menu\"]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[27]/a")).click();
	}
	
	public void navigateToLoginAndSecurity() {
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[2]/div/div[2]/div[2]/a/div/div/div")).click();
	}
	
	public void login1() {
		Keywords excelFile=new Keywords();
		 excelFile.setInputFile("E:/KeywordDrivenCheck.xls");
	     try {
			excelFile.loginCredentials();
		} catch (IOException e) {
			System.out.println(e);
		}
		WebElement username = driver.findElement(By.xpath("//*[@id=\"ap_email\"]"));
		if(username.isDisplayed()) {
		username.sendKeys(excelFile.id);
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();}
		else {
		System.out.println("Not displayed username");
		}
		WebElement password = driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		if (password.isDisplayed()) {
			System.out.println("Pasword field is displayed");
			password.sendKeys(excelFile.pwd);
			driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
		} else {
			System.out.println("Password field is not displayed");
		}
	}

	public static void main(String[] args) {
		Functionalities f = new Functionalities();
		//f.Initialize();
	}
}
