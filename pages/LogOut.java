package notesAutomation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut {

	private WebDriver driver;
	private	WebDriverWait wait;
	public LogOut(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;	
		AjaxElementLocatorFactory ajaxElementLocatorFactory=new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(ajaxElementLocatorFactory, this);
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	@FindBy(xpath = "//button[@data-testid=\"logout\"]") WebElement logOutBtnElement;
	
	public void logOut() {
		wait.until(ExpectedConditions.elementToBeClickable(logOutBtnElement)).click();
	}
}
