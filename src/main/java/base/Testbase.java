package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;


public class Testbase {

	public static BasicFunction fun = new BasicFunction();
	static BrowserFactory bf = new BrowserFactory();

	public static void browserinitialization(String browsername, ExtentTest test)
			throws IOException, InterruptedException {

		DriverFactory.getInstance().setDriver(bf.createbrowserInstance(browsername));
		WebDriver driver = DriverFactory.getInstance().getDriver();

		driver.manage().window().maximize();
		String url = "http://dev.datanetiix.com/orange_coast/";
		driver.navigate().to(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Navigated to URL : "+url);

		String Title = driver.getTitle();
		if (Title.equalsIgnoreCase("Orange Coast")) {
			System.out.println("PASS: Page navigated successfully");
			test.log(Status.PASS,"Page Navigated Successfully",MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		} else {
			System.out.println("FAIL: Page is not navigated");
			test.log(Status.FAIL, "Page is not navigated "+"Expected Title "+"Orange Coast"+" Actual Title "+Title+MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		}


		
	}

}
