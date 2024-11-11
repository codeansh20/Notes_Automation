package notesAutomation.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NotesAdd {

	WebDriver driver;
	public NotesAdd(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='navbar-brand mb-2 mb-sm-0 logo_title']")
	WebElement logoElement;
	@FindBy(xpath = "//button[normalize-space()='+ Add Note']") WebElement addnotebtn;
	@FindBy(xpath = "//div[@data-testid=\"notes-list\"]//div[@class='col-12 col-sm-12 col-md-6 col-lg-4 mb-3']") 
	List<WebElement> totalNotesElements;
	@FindBy(xpath = "//select[@id='category']") WebElement dropdownElement;
	@FindBy(xpath = "//input[@id='title']")WebElement titlElement;
	@FindBy(xpath = "//textarea[@id='description']") WebElement descriptionElement;
	@FindBy(xpath = "//button[text()='Create']") WebElement createnotesElement;
	@FindBy(xpath = "//button[normalize-space()='Cancel']") WebElement cancelElement;
	
	public void logoClick() throws InterruptedException {
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView()", logoElement);
		Thread.sleep(1200);
		logoElement.click();//to refresh the notes section
	}
	
	public void create_notes() {
		addnotebtn.click();
	}
	
	public void selectNotes(String drop_txt) {
		Select scSelect=new Select(dropdownElement);
		scSelect.selectByVisibleText(drop_txt);
	}
	
	public void notes_title(String title) {
		titlElement.clear();
		titlElement.sendKeys(title);
	}
	
	public void notes_desc(String desc) {
		descriptionElement.clear();
		descriptionElement.sendKeys(desc);
	}
	
	public void note_created() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", createnotesElement);

//		createnotesElement.submit();
	}
	
	public void note_cancel() {
		cancelElement.click();
	}
	
	public int totalNotes() {
		return totalNotesElements.size();
	}
}
