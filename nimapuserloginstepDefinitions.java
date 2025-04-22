package Cucumber1stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class nimapuserloginstepDefinitions {
	WebDriverWait wait;
	WebDriver driver;
	@Given("Browser is open and Login page is open")
	public void browser_is_open_and_login_page_is_open() {
		 driver = new ChromeDriver();
		    System.out.println("ChromeDriver is Opened");
		    driver.manage().window().maximize();
		    driver.get("https://testffc.nimapinfotech.com/auth/login");
		    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		    String Currenturl = driver.getCurrentUrl();
		    System.out.println(Currenturl);
		    if (Currenturl.equals("https://testffc.nimapinfotech.com/auth/login")) {
		        System.out.println("User is Navigated to Login Page");
		    } else {
		        System.out.println("User is not Navigated to Login Page, Hence Enter Website Link Corrrectly");
		    }
	}

	@When("^User enters (.*) and (.*).$")
	public void User_enters_Email_and_Password(String Email, String Password) {
		System.out.println("Validating Login Page by Using Valid Email Id and Password");
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]")));
		email.sendKeys(Email);
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]")));
		password.sendKeys(Password);
		
		
	}

	@And("User clicks on Submit button")
	public void User_clicks_on_Submit_button () {
		WebElement signinBtn = driver.findElement(By.id("kt_login_signin_submit"));
		signinBtn.click();
	    
	}
	@And("User Quits Browser")
	public void User_Quits_Browser () {
		    driver.quit();
	}
}
