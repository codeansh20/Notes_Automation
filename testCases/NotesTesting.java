package notesAutomation.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import notesAutomation.Utilities.DriverSingleton;
import notesAutomation.pages.NotesSection;

public class NotesTesting {

	WebDriver driver;
	@BeforeClass
	public void setup() {
		try {
			driver=DriverSingleton.getDriver();
			System.out.println("Initialised for Notes");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void Profile_Validation() throws InterruptedException {
		NotesSection nSection=new NotesSection(driver);
		nSection.profileSection();
		System.out.println(nSection.user_id());
		System.out.println(nSection.user_mail());
		Thread.sleep(2000);
		nSection.username("Bhilu");
		nSection.userphone("7890767821");
		nSection.userCompany("Crocs");
		nSection.profileUpdate();
		
		Assert.assertEquals(nSection.verification(), "Profile updated successful");
	}
}
