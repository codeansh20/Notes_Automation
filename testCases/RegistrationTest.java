package notesAutomation.testCases;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import notesAutomation.pages.Account;
import notesAutomation.pages.HomePage;
import notesAutomation.pages.LogOut;
import notesAutomation.pages.Login;
import notesAutomation.pages.NotesSection;
import notesAutomation.pages.Registration;
import notesAutomation.Utilities.DP;
import notesAutomation.Utilities.DriverSingleton;

public class RegistrationTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		try {
			System.out.println("Fetching driver from DriverSingleton...");
			driver = DriverSingleton.getDriver(); // Check if driver is initialized
			System.out.println("Driver fetched: " + driver);

			if (driver != null) {
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			} else {
				System.out.println("Driver is null. Cannot proceed with setup.");
			}
		} catch (Exception e) {
			System.out.println("Error in setup method: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "data-provider", dataProviderClass = DP.class)
	public void userRegistration(String mail, String pass, String name) throws InterruptedException {
		if (driver == null) {
			System.out.println("Driver is null in test method. Test cannot proceed.");
			return;
		}

		HomePage hP = new HomePage(driver);
		Registration rg = new Registration(driver);
		Account account = new Account(driver);
		Login lgLogin = new Login(driver);
		NotesSection nst = new NotesSection(driver);
		LogOut lgLogOut = new LogOut(driver);
		SoftAssert sAssert = new SoftAssert();

		/*
		 * Earlier was using this when not dealing with DP.java String emailString =
		 * "rajatdalal"; UUID randomUuid = UUID.randomUUID()
		 */

		try {
			hP.register();
			rg.user_email(mail);
			rg.user_pass(pass);
			rg.user_name(name);
			rg.user_confirmpass(pass);
			rg.registerbutton();

			if (rg.popUpRegister() > 0) {
				sAssert.assertTrue(false);// fail as it is already registered
				rg.anchorLink();
			} else {
				System.out.println("trying login");
				lgLogin.reg_login();
				lgLogin.inputmail(mail);
				lgLogin.inputpass(pass);
				lgLogin.login_click();

				Thread.sleep(1000);
				String logo_txt = nst.logo_verification();
				Assert.assertEquals(logo_txt.trim(), "MyNotes");

				// logOut
				lgLogOut.logOut();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Some other error");
			e.printStackTrace();
		} finally {
			sAssert.assertAll();
		}

//		sAssert.assertEquals(account.validationMsg(), "User account created successfully");

		// Perform login actions
//		lgLogin.reg_login();
//		lgLogin.inputmail(mail);
//		lgLogin.inputpass(pass);
//		lgLogin.login_click();
//
//		Thread.sleep(1000);
//		String logo_txt = nst.logo_verification();
//		Assert.assertEquals(logo_txt.trim(), "MyNotes");
//
//		// logOut
//		lgLogOut.logOut();

		// valiate did all the testCase passsed or not
//		sAssert.assertAll();
	}
}
