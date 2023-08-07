package pageModule;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Manual_upload_xpath;

public class Manual_Upload extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	
	public void Upload_file(ExtentTest test, WebDriver driver) throws InterruptedException, IOException, AWTException {
		Manual_upload_xpath Upload_xp = new Manual_upload_xpath(driver);

		fun.Click(driver, Upload_xp.Upload_menu);
		fun.Scroll(driver, Upload_xp.Manual_Upload_product);
		fun.Click(driver, Upload_xp.Manual_Upload_product);
		fun.explicit_Wait_Click(driver, Upload_xp.File_upload_Button);
		fun.Click(driver, Upload_xp.File_upload_Button);

		try {
		Runtime.getRuntime().exec("C:\\eclipse\\orange_coast\\src\\test\\resources\\UploadFile\\FileUpload.exe");

			fun.explicit_Wait_invisible(driver, Upload_xp.Default_photo);
		

		if (Upload_xp.Default_photo.isDisplayed() == false) {
			
			Thread.sleep(15000);
			test.log(Status.PASS, "Photo Uploaaded", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			

		}
		}
		catch (Exception e) {

			test.log(Status.FAIL, "Photo Uploaaded", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			e.printStackTrace();
			
		}

	}

}