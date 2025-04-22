package nimap_Login;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class nimapuserLogin {
	
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		nimapuserLogin login = new nimapuserLogin();
		login.openDriver();
		login.openLogin();
		login.validSignin("rifengonsalvesbusiness@gmail.com", "Rifen07*");
		login.validateUserLogin();
		login.openNewTab();
		login.invalidSignin("rifengonsalvesbusiness@gmail.com", "1@");
		
		}
	public void openDriver() {
		driver=new ChromeDriver();
		System.out.println("ChromeDriver is Opened");
		driver.manage().window().maximize();
		}
	public void openLogin() {
		driver.get("https://testffc.nimapinfotech.com/auth/login");
		String Currenturl = driver.getCurrentUrl();
		System.out.println(Currenturl);
		if(Currenturl.equals("https://testffc.nimapinfotech.com/auth/login")) {
			System.out.println("User is Navigated to Login Page");
		}else
		System.out.println("User is not Navigated to Login Page, Hence Enter Website Link Corrrectly");
	}
	public void validSignin(String Email, String Password) throws InterruptedException {
		System.out.println("Validating Login Page by Using Valid Email Id and Password");
		WebElement email = driver.findElement(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]"));
		email.sendKeys(Email);
		
		WebElement password = driver.findElement(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]"));
		password.sendKeys(Password);
		
		WebElement signinBtn = driver.findElement(By.id("kt_login_signin_submit"));
		signinBtn.click();
		Thread.sleep(5000);
	}
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
	
	  // Open a new tab
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
    public void invalidSignin(String Email, String Password) throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		System.out.println("Validating Login Page by Using Valid Email Id and Invalid Password");
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[1]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]")));
		email.sendKeys(Email);
		
		WebElement password = driver.findElement(By.xpath("/html[1]/body[1]/kt-auth[1]/div[1]/div[1]/div[2]/kt-login[1]/div[2]/div[1]/form[1]/div[2]/mat-form-field[1]/div[1]/div[1]/div[1]/input[1]"));
		password.sendKeys(Password);
		
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
