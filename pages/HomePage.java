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

public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		AjaxElementLocatorFactory ajaxElementLocatorFactory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(ajaxElementLocatorFactory, this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	@FindBy(xpath = "//a[normalize-space()='Create an account']") WebElement inputRegister;
	@FindBy(xpath = "//a[normalize-space()='Login']") WebElement loginbtnElement;	
	
	public void register() {
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", inputRegister);
//		wait.until(ExpectedConditions.elementToBeClickable(inputRegister)).click();
	}
	
	public void login() {
		wait.until(ExpectedConditions.elementToBeClickable(loginbtnElement)).click();
	}
	
}
