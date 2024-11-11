package notesAutomation.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;
    private static ExtentTest test;

    // Initialize the Extent Report
    public void onStart(ITestContext context) {
    	ExtentSparkReporter htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/Kumar/report.html");

		
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setReportName("Automation Test Report");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "YourHost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "YourUser");
    }

    // Run for each test start
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    // For test success
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    // For test failure
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
//        test.log(Status.FAIL, )
        test.log(Status.FAIL, result.getThrowable());  // Logs the stack trace
    }

    // For test skipped
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }

    // For each test completion
    public void onFinish(ITestContext context) {
        extent.flush();  // Writes the test results to the report
        System.out.println("Succes");
    }
}
