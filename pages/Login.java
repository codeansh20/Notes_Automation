package notesAutomation.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	WebDriver driver;
	WebDriverWait wait;
	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		AjaxElementLocatorFactory ajaxElementLocatorFactory=new AjaxElementLocatorFactory(driver, 10);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(ajaxElementLocatorFactory, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement loginButton;
	@FindBy(xpath = "//input[@id='email']") WebElement user_email;
	@FindBy(xpath = "//input[@id='password']") WebElement user_pass;
	@FindBy(xpath = "//button[normalize-space()='Login']") WebElement login_btnElement;
	@FindBy(xpath = "//a[@data-testid='login-view']")WebElement register_loginElement;
	
	public void Login() {
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click;", loginButton);
	}
	
	public void inputmail(String usermail) {
		user_email.sendKeys(usermail);
	}
	
	public void inputpass(String userpass) {
		user_pass.sendKeys(userpass);
	}
	
	public void login_click() {
		login_btnElement.submit();
	}
	
	public void reg_login() {
//		wait.until(ExpectedConditions.elementToBeClickable(register_loginElement)).click();
//		register_loginElement.click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", register_loginElement);
	}
	
	public void outerLoginBtn() {
//		loginButton.click();
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", loginButton);
	}
}
