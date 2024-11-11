package notesAutomation.Utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSingleton {

    private static WebDriver driver = null;
    private static Properties properties;

    private DriverSingleton() {
        // Private constructor to prevent instantiation
    }
    @BeforeSuite
    public static WebDriver getDriver() {
        if (driver == null) {
            try {
            	FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/notesAutomation/Utilities/config.properties");
            	properties=new Properties();
            	properties.load(fileInputStream);
                System.out.println("Initializing ChromeDriver...");
                driver = new ChromeDriver();
                driver.get(properties.getProperty("baseURL"));
                driver.manage().deleteAllCookies();
                System.out.println("Driver initialized successfully.");
            } catch (Exception e) {
                System.out.println("Error initializing the driver: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return driver;
    }

    @AfterSuite
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("Driver quit successfully.");
        }
    }
    
    public static void CaptureScreenshot(String fileName) {
    	TakesScreenshot tScreenshot=(TakesScreenshot)driver;
    	File srcFile=tScreenshot.getScreenshotAs(OutputType.FILE);
    	File desFile=new File("./screenshots/"+fileName+".jpg");
//    	srcFile.renameTo(desFile);
        try {
            FileUtils.copyFile(srcFile, desFile);
            System.out.println("Screenshot saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

	}
}
