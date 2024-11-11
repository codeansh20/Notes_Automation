package notesAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account {

	WebDriver driver;
	public Account(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//b[normalize-space()='User account created successfully']") WebElement validationMsgElement;
	
	public String validationMsg() {
		return validationMsgElement.getText().toString();
	}
}
