package notesAutomation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {

	WebDriver driver;

	public Registration(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']")
	WebElement reg_emailElement;
	@FindBy(xpath = "//input[@id='password']")
	WebElement reg_passwordElement;
	@FindBy(xpath = "//input[@id='name']")
	WebElement reg_usernamElement;
	@FindBy(xpath = "//input[@id='confirmPassword']")
	WebElement reg_confirmPassElement;
	@FindBy(xpath = "//button[normalize-space()='Register']")
	WebElement reg_buttonElement;
	@FindBy(xpath = "//a[contains(text(),'Home - My Notes - The App for Automation Testing P')]")
	WebElement homeElement;
	@FindBy(xpath = "//div[@class=\"toast-body\"]") List<WebElement> errorElement;
	public void user_email(String email) {
		reg_emailElement.sendKeys(email);
	}

	public void user_pass(String pass) {
		reg_passwordElement.sendKeys(pass);
	}

	public void user_confirmpass(String confirmpass) {
		reg_confirmPassElement.sendKeys(confirmpass);
	}

	public void user_name(String name) {
		reg_usernamElement.sendKeys(name);
	}

	public void registerbutton() throws InterruptedException {
		reg_buttonElement.submit();
	}

	public int popUpRegister() {
//		System.out.println(errorElement.isDisplayed());
//		System.out.println("Content "+errorElement.getText().toString());
		System.out.println(errorElement.size());
		return errorElement.size();

	}
	
	public void anchorLink() {
		homeElement.click();
	}
}
