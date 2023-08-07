package pageModule;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Checkout_xpath;

public class Product_description_dimesion_validation_page extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	
	public void Product_dim_descript(ExtentTest test, WebDriver driver, String Width,String Height) throws InterruptedException, IOException, AWTException {
		Checkout_xpath checkout_xp = new Checkout_xpath(driver);

		fun.Click(driver, checkout_xp.Product_select);
		System.out.println("Product selected");
		test.log(Status.PASS, "Product Selected", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		// Product Description Page
		

		fun.Scroll(driver, checkout_xp.Width_input);
		fun.Sendkeys(driver, checkout_xp.Width_input, Width);
		System.out.println("Width entered");
		fun.Sendkeys(driver, checkout_xp.Hieght_input, Height);
		System.out.println("Height Entered");
		test.log(Status.PASS, "Width and Hieght Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Scroll(driver, checkout_xp.AddtoCart_Button);
		fun.Click(driver, checkout_xp.AddtoCart_Button);
		
//		fun.Scroll(driver, checkout_xp.AddtoCart_icon_number);


		
		//		String cartValue = checkout_xp.AddtoCart_icon_number.getText();

		
		if (checkout_xp.Crop_image.isDisplayed()==false) {
			
			test.log(Status.PASS,  "Parameter:"+"Height:"+Height+"Width"+Width+"Validation Occured", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			System.out.println("Parameter: "+" Height = "+Height+" Width = "+Width+"Validation occured");
		}
		
			if (checkout_xp.height_error.isDisplayed()) {
				fun.Scroll(driver, checkout_xp.height_error);
				String height_err = checkout_xp.height_error.getText();
				test.log(Status.PASS, "Parameter:"+"Height:"+Height+"Width"+Width+"Validation:"+height_err, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
				System.out.println("Parameter:"+" Height: "+Height+" Width: "+Width+"Validation: "+height_err);
			}
				else if (checkout_xp.Empty_dimension_message.isDisplayed()) {
					
					fun.Scroll(driver, checkout_xp.Empty_dimension_message);
					String Dimension_err = checkout_xp.Empty_dimension_message.getText();
					test.log(Status.PASS,  " Parameter: "+" Height:"+Height+" Width: "+Width+" Validation: "+Dimension_err, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
					System.out.println("Parameter:"+"Height:"+Height+"Width"+Width+"Validation:"+Dimension_err);
					
				}
				else if (checkout_xp.dimension_alert_msg.isDisplayed()) {
					
					fun.Scroll(driver, checkout_xp.dimension_alert_msg);
					String dim_alert = checkout_xp.dimension_alert_msg.getText();
					test.log(Status.PASS, "Validation:"+dim_alert, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
					System.out.println(" Parameter: "+" Height: "+Height+" Width: "+Width+" Validation: "+dim_alert);
					
				}
				
				else {
					
					test.log(Status.FAIL, "Validation Failed", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
				}
					
		
	}
}