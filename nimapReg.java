package nimap_Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class nimapReg {
	
	WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		nimapReg register = new nimapReg();
		register.openDriver();
		register.openRegisterpage();
		register.signupUser();
		register.signupuserDetails();
		register.userSubmit();
	}
	public void openDriver() {
		driver=new ChromeDriver();
		System.out.println("ChromeDriver is Opened");
	}
	public void openRegisterpage() {
		driver.get("https://testffc.nimapinfotech.com/auth/login");
		System.out.println("User is on Login Page");
//		String s = driver.getCurrentUrl();
//		if (s.equals("https://testffc.nimapinfotech.com/auth/login")) {
//			System.out.println("User is on Login Page");
//		}else {
//			System.out.println("User is not on Login Page");
//		}
		
	}
	public void signupUser() {
		WebElement signUp = driver.findElement(By.cssSelector("a[href='/auth/register']"));
		signUp.click();
		
	}
	public void signupuserDetails() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		System.out.println("Entering User Valid Details");
		
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[formcontrolname='name'][formcontrolname='name']")));
		name.sendKeys("Rifen");
		System.out.println("Name is Entered");
		
		WebElement mNumber= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-register[1]/div[1]/div[1]/form[1]/div[3]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]")));
		mNumber.click();
		mNumber.sendKeys("7350478206");
		System.out.println("Mobile Number is Entered");
		
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-register[1]/div[1]/div[1]/form[1]/div[4]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]")));
		email.click();
		email.sendKeys("rifengonsalvesbusiness@gmail.com");
		System.out.println("Email is Entered");
		
	}
	public void userSubmit() {
		WebElement submitBtn = driver.findElement(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-register[1]/div[1]/div[1]/form[1]/div[5]/button[2]"));
	submitBtn.click();
	System.out.println("User is Registered with Proper Details");
	driver.quit();
	}
	
}
