package notesAutomation.Utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started");
//		DriverSingleton.CaptureScreenshot("Ansh");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Sucess");
		DriverSingleton.CaptureScreenshot("AnshIsthere");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		DriverSingleton.CaptureScreenshot("AnshIsthere");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped");
	}


	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Started Initially");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Ended");
	}
	
}

