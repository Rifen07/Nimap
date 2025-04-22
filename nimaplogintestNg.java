package com.app.TestNG;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class nimaplogintestNg {
	WebDriver driver;
	@Test
	public void openDriver() {
		driver=new ChromeDriver();
		System.out.println("ChromeDriver is Opened");
		driver.manage().window().maximize();
		}
	@Test
	public void openLogin() {
		driver.get("https://testffc.nimapinfotech.com/auth/login");
		String Currenturl = driver.getCurrentUrl();
		System.out.println(Currenturl);
		if(Currenturl.equals("https://testffc.nimapinfotech.com/auth/login")) {
			System.out.println("User is Navigated to Login Page");
		}else
		System.out.println("User is not Navigated to Login Page, Hence Enter Website Link Corrrectly");
	}
	@Test
	public void validSignin() throws InterruptedException {
		System.out.println("Validating Login Page by Using Valid Email Id and Password");
		WebElement email = driver.findElement(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]"));
		email.sendKeys("rifen.gonsalves@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]"));
		password.sendKeys("Rifen07*");
		
		WebElement signinBtn = driver.findElement(By.id("kt_login_signin_submit"));
		signinBtn.click();
		Thread.sleep(5000);
	}
	@Test
		public void validateUserLogin() {
		String cUrl = driver.getCurrentUrl();
		System.out.println(cUrl);
		
		if (cUrl.equals("https://testffc.nimapinfotech.com/dashboard")){
			System.out.println("User has Successfully Signed in and is Redirected to Dashboard");
		}else
		{
			System.out.println("User has not Successfully Signed in and is not Redirected to Dashboard");
		}
		}
	@Test
	   public void openNewTab() {
	        // Open a new tab using JavaScript Executor
	        String script = "window.open('https://testffc.nimapinfotech.com/auth/login', '_blank');";
	        ((ChromeDriver) driver).executeScript(script);
	        
	        // Switch to the new tab
	        switchToNewTab();
	    }

	    // Switch to the newly opened tab
	    public void switchToNewTab() {
	        // Get all window handles (tabs/windows)
	        Set<String> handles = driver.getWindowHandles();
	        
	        // Loop through and switch to the second tab (new tab)
	        for (String handle : handles) {
	            driver.switchTo().window(handle);
	        }
	        System.out.println("Switched to new tab to Validate Login with Invalid Details");
	    }
	@Test
	 public void invalidSignin() throws InterruptedException {
	    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			System.out.println("Validating Login Page by Using Valid Email Id and Invalid Password");
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]")));
			email.sendKeys("rifen.gonsalves@gmail.com");
			
			WebElement password = driver.findElement(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]"));
			password.sendKeys("!@#");
			
			WebElement signinBtn = driver.findElement(By.id("kt_login_signin_submit"));
			signinBtn.click();
			Thread.sleep(5000);
			String cUrll = driver.getCurrentUrl();
			System.out.println(cUrll);
			if (cUrll.equals("https://testffc.nimapinfotech.com/dashboard")){
				System.out.println("User has Successfully Signed in and is Redirected to Dashboard");
			}else
			{
				System.out.println("User has not Successfully Signed in and is not Redirected to Dashboard");
			}
			driver.quit();
			}
}
