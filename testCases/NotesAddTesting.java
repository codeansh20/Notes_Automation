package notesAutomation.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import notesAutomation.Utilities.DriverSingleton;
import notesAutomation.pages.NotesAdd;

public class NotesAddTesting {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		driver=DriverSingleton.getDriver();
		System.out.println("Driver init notesaddtesting");
	}
	
	@Test
	public void AddNotes() throws InterruptedException {
		NotesAdd na=new NotesAdd(driver);
		na.logoClick();
		na.create_notes();
		na.selectNotes("Home");
		na.notes_title("Office Issue");
		na.notes_desc("Hey wake me up at 3:30");
		na.note_created();
		System.out.println(na.totalNotes());
	}
}
