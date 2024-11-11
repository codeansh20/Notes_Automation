package notesAutomation.testCases;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import notesAutomation.pages.LogOut;
import notesAutomation.pages.Login;
import notesAutomation.pages.NotesSection;
import notesAutomation.Utilities.DriverSingleton;

public class LoginTest {

    WebDriver driver;
    public static Properties properties;

    @BeforeClass
    public void setup() throws IOException {
        // Initialize the driver using DriverSingleton
        driver = DriverSingleton.getDriver();
        System.out.println("Driver initialized in LoginTest: " + driver);
        properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/notesAutomation/Utilities/config.properties");
    	properties.load(fileInputStream);
        // Maximize window and set timeouts (if needed)
        driver.manage().window().maximize();
    }

    @Test
    public void login() throws InterruptedException {
        
        // Initialize the Login page object
        Login lgLogin = new Login(driver);
        NotesSection nst=new NotesSection(driver);
        
        // Perform login actions
//        lgLogin.reg_login();
        lgLogin.outerLoginBtn();
        lgLogin.inputmail(properties.getProperty("loginMail"));
        lgLogin.inputpass(properties.getProperty("loginPass"));
        lgLogin.login_click();	
        
        Thread.sleep(2000);
        String logo_txt=nst.logo_verification();
        Assert.assertEquals(logo_txt.trim(), "MyNotes");
        
        //logout
        LogOut lgLogOut=new LogOut(driver);
        lgLogOut.logOut();
    }
    
    @Test(priority = 1,enabled = false)
    public void logOut() {
		if(driver!=null)
		{
			DriverSingleton.quitDriver();
		}
	}
}
