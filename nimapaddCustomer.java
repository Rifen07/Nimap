package nimap_Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class nimapaddCustomer {
	WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		nimapaddCustomer customer = new nimapaddCustomer();
		customer.openDriver();
		customer.openLogin();
		customer.validSignin("rifengonsalvesbusiness@gmail.com", "Rifen07*");
		customer.validateUserLogin();
		customer.addCustomer();
		customer.enterDetails("Suraj Chauhan","1","Suraj Chauhan","7392912314","2678203","surajc@gmail.com","Software Tester");
		//customer.enterAddress();
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
		public void addCustomer() {
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
			    WebElement myCustomer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/customers']")));
			    myCustomer.click();
			    System.out.println("Clicked on My Customer Button");
			    
			    WebElement  newCustomer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/kt-base/div[2]/div/div/div/div/ng-component/kt-customers-list/mat-drawer-container/mat-drawer-content/kt-portlet/div/kt-portlet-header/div[4]/button[1]")));
			    newCustomer.click();
			    System.out.println("Clicked on New Customer Button");
			    
		}
		public void enterDetails(String leadname,String refno,String personname,String mnumber,String tnumber,String email,String designation) {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		    WebElement Leadname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/mat-dialog-container[1]/kt-customers-edit-dialog[1]/div[1]/form[1]/div[1]/div[2]/div[1]/mat-form-field[1]/div[1]/div[1]")));
		    Leadname.sendKeys(leadname);
		    System.out.println("Leadname Added");
		    
		    WebElement Refno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='mat-input-13'])[1]")));
		    Refno.sendKeys(refno);
		    System.out.println("Reference number Added");
		    
		    WebElement Personname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-16")));
		    Personname.sendKeys(personname);
		    System.out.println("Contact person name Added");
		    
		    WebElement Mobileno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-15")));
		    Mobileno.sendKeys(mnumber);
		    System.out.println("Mobile Number Added");
	    
		    WebElement Teleno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/kt-customers-edit-dialog/div[1]/form/div/div[4]/div[3]/mat-form-field/div/div[1]/div/input")));
		    Teleno.sendKeys(tnumber);
		    System.out.println("Telephone Number Added");
		    
		    WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/kt-customers-edit-dialog/div[1]/form/div/div[4]/div[4]/mat-form-field/div/div[1]/div/input")));
		    Email.sendKeys(email);
		    System.out.println("Email Added");
		    
		    WebElement Designation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mat-input-19")));
		    Designation.sendKeys(designation);
		    System.out.println("Designation Added");
		}
		
		public void enterAddress() {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			WebElement country = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/mat-dialog-container/kt-customers-edit-dialog/div[1]/form/div/div[6]/div[2]/mat-form-field/div/div[1]/div/mat-select/div/div[1]")));
		    country.click();
		    System.out.println("Country Clicked");
		}
	}
		
