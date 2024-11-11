package notesAutomation.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotesSection {

	WebDriver driver;
	public NotesSection(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='navbar-brand mb-2 mb-sm-0 logo_title']")
	WebElement logoElement;
	@FindBy(xpath = "//a[normalize-space()='Profile']")
	WebElement profileBtn;
	@FindBy(xpath = "//input[@id='user-id']")
	WebElement UserID;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement userPhone;
	@FindBy(xpath = "//input[@id='user-email']")
	WebElement userEmail;
	@FindBy(xpath = "//input[@name='company']")
	WebElement companyElement;
	@FindBy(xpath = "//input[@name='name']")
	WebElement UserName;
	@FindBy(xpath = "//button[normalize-space()='Update profile']")
	WebElement update_btnElement;
	@FindBy(xpath = "//div[@data-testid='alert-message']") WebElement alertmsgElement;

	public String logo_verification() {
		if (logoElement.isDisplayed()) {
			return logoElement.getText().toString();
		}
		return null;
	}

	public void profileSection() throws InterruptedException {
		profileBtn.click();
		Thread.sleep(2000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView()", update_btnElement);
	}

	public void username(String uname) {
		UserName.clear();
		UserName.sendKeys(uname);
	}

	public void userphone(String upaas) {
		userPhone.clear();
		userPhone.sendKeys(upaas);
	}

	public String user_id() {
		if (UserID.isDisplayed()) {
			return UserID.getText().toString();
		}
		return null;

	}

	public String user_mail() {
		if (userEmail.isDisplayed()) {
			return userEmail.getText().toString();
		}
		return null;
	}

	public void userCompany(String cname) {
		companyElement.clear();
		companyElement.sendKeys(cname);
	}

	public void profileUpdate() {
		update_btnElement.submit();
	}
	
	public String verification() {
		return alertmsgElement.getText().toString();
	}
}
