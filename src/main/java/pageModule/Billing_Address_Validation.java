package pageModule;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Checkout_xpath;

public class Billing_Address_Validation extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	public void Bill_Add(ExtentTest test, WebDriver driver, String Firstname, String Lastname, String Ordernotes,
			String Company, String City, String Address1, String Address2, String Postcode, String Mobile, String Email)
			throws InterruptedException, IOException, AWTException {
		Checkout_xpath checkout_xp = new Checkout_xpath(driver);

		fun.Click(driver, checkout_xp.Product_select);
		System.out.println("Product selected");
		// test.log(Status.PASS, "Product Selected",
		// test.addScreenCapture(fun.capturescreenshot(driver)));

		// Product Description Page

		fun.Click(driver, checkout_xp.No_Mural_Radio);
		System.out.println("Mural selected");
		// test.log(Status.PASS, "Mural Selected",
		// test.addScreenCapture(fun.capturescreenshot(driver)));

		fun.Scroll(driver, checkout_xp.Width_input);
		fun.Sendkeys(driver, checkout_xp.Width_input, "200");
		// System.out.println("Width entered");

		fun.Sendkeys(driver, checkout_xp.Hieght_input, "200");
		System.out.println("Height Entered");
		// test.log(Status.PASS, "Width and Hieght Entered",
		// test.addScreenCapture(fun.capturescreenshot(driver)));

		fun.Scroll(driver, checkout_xp.Flipimage_Checkbox);
		fun.Click(driver, checkout_xp.Flipimage_Checkbox);

		fun.Scroll(driver, checkout_xp.Flipimage_Checkbox);
		fun.Click(driver, checkout_xp.Flipimage_Checkbox);
		fun.explicit_Wait(driver, checkout_xp.Crop_image);
		System.out.println("Flipimage Selected");
		// test.log(Status.PASS, "Flipimage Selected",
		// test.addScreenCapture(fun.capturescreenshot(driver)));

		fun.Click(driver, checkout_xp.BlackandWhite_Checkbox);
		fun.explicit_Wait(driver, checkout_xp.Crop_image);
		System.out.println("BlackandWhite Selected");
//		test.log(Status.PASS, "Black and white selected", test.addScreenCapture(fun.capturescreenshot(driver)));

		fun.Click(driver, checkout_xp.Protectivetop_Checkbox);
		System.out.println("Protective Top Selected");
		// test.log(Status.PASS, "Protective top Selected",
		// test.addScreenCapture(fun.capturescreenshot(driver)));

		fun.Scroll(driver, checkout_xp.Quantity_input);
		fun.Sendkeys(driver, checkout_xp.Quantity_input, "3");
		// test.log(Status.PASS, "Quantity Entered",
		// test.addScreenCapture(fun.capturescreenshot(driver)));
		System.out.println("Quantity entered");

		fun.Scroll(driver, checkout_xp.AddtoCart_Button);
		fun.Click(driver, checkout_xp.AddtoCart_Button);
		System.out.println("Product added to cart");
		// test.log(Status.PASS, "Add to Cart Clicked",
		// test.addScreenCapture(fun.capturescreenshot(driver)));

		// Cart menu

		try {
			fun.explicit_Wait(driver, checkout_xp.AddtoCart_icon_number);
//		test.log(Status.PASS, "Product Added to the Cart", test.addScreenCapture(fun.capturescreenshot(driver)));
			fun.Click(driver, checkout_xp.AddtoCart_icon);
			fun.Click(driver, checkout_xp.ViewCart_Button);
			// test.log(Status.PASS, "Navigated to Cart Page",
			// test.addScreenCapture(fun.capturescreenshot(driver)));

		} catch (Exception e) {

			fun.explicit_Wait(driver, checkout_xp.AddtoCart_icon_number);
			// test.log(Status.PASS, "Product Added to the Cart",
			// test.addScreenCapture(fun.capturescreenshot(driver)));
			fun.Click(driver, checkout_xp.AddtoCart_icon);
			fun.Click(driver, checkout_xp.ViewCart_Button);
			// test.log(Status.PASS, "Navigated to Cart Page",
			// test.addScreenCapture(fun.capturescreenshot(driver)));
			e.printStackTrace();

		}
		
		try {
		fun.Scroll(driver, checkout_xp.Checkout_Button);
		fun.Click(driver, checkout_xp.Checkout_Button);
		}
		
		catch (Exception e) {

			fun.Scroll(driver, checkout_xp.Checkout_Button);
			fun.Click(driver, checkout_xp.Checkout_Button);
			e.printStackTrace();
			
		}
		test.log(Status.PASS, "Navigated to Billing Page", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Sendkeys(driver, checkout_xp.Billing_Firstname, Firstname);
		fun.Sendkeys(driver, checkout_xp.Billing_Lastname, Lastname);
		test.log(Status.PASS, "Firstname Lastname Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Order_notes, Ordernotes);
		test.log(Status.PASS, "Order notes Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Billing_Company, Company);
		test.log(Status.PASS, "Billing Company Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		Select country = new Select(checkout_xp.Billing_Country);
		country.selectByVisibleText("United States (US)");
		test.log(Status.PASS, "Billing Country Selected", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Billing_address_1, Address1);
		fun.Sendkeys(driver, checkout_xp.Billing_address_2, Address2);
		test.log(Status.PASS, "Billing Address Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Scroll(driver, checkout_xp.Billing_City);
		fun.Sendkeys(driver, checkout_xp.Billing_City, City);
		test.log(Status.PASS, "Billing City Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Scroll(driver, checkout_xp.Billing_State);
		Select state = new Select(checkout_xp.Billing_State);
		state.selectByVisibleText("Alaska");
		test.log(Status.PASS, "Billing State Selected", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Scroll(driver, checkout_xp.Billing_postcode);
		fun.Sendkeys(driver, checkout_xp.Billing_postcode, Postcode);
		test.log(Status.PASS, "Billing Postcode Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Billing_Mobile, Mobile);
		test.log(Status.PASS, "Billing Mobile Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Billing_Email, Email);
		System.out.println("Billing Address entered");
		test.log(Status.PASS, "Billing Email Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		try {
			fun.explicit_Wait(driver, checkout_xp.PlaceOrder_Button);
			fun.Scroll(driver, checkout_xp.PlaceOrder_Button);

			fun.explicit_Wait_Click(driver, checkout_xp.PlaceOrder_Button);
			fun.Click(driver, checkout_xp.PlaceOrder_Button);
			System.out.println("Place Order button id clicked");
			test.log(Status.PASS, "PlaceOrder Button CLicked", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			fun.explicit_Wait(driver, checkout_xp.Billing_error);
		} catch (Exception e) {
			
			fun.explicit_Wait(driver, checkout_xp.PlaceOrder_Button);
			fun.Scroll(driver, checkout_xp.PlaceOrder_Button);

			fun.explicit_Wait_Click(driver, checkout_xp.PlaceOrder_Button);
			fun.Click(driver, checkout_xp.PlaceOrder_Button);
			System.out.println("Place Order button id clicked");
			test.log(Status.PASS, "PlaceOrder Button CLicked", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			fun.explicit_Wait(driver, checkout_xp.Billing_error);
			e.printStackTrace();
		}

		try {
			List<WebElement> Validation = checkout_xp.Billing_error.findElements(By.tagName("li"));
			fun.Scroll(driver, checkout_xp.Billing_error);

			if (checkout_xp.Billing_error.isDisplayed() == true)

				for (int i = 0; i < Validation.size(); i++) {
//				String validates = Validation.get(i).getText();
					System.out.println(Validation.get(i).getText());
					test.log(Status.PASS,
							" FirstName: " + Firstname + " Lastname: " + Lastname + " Notes: " + Ordernotes
									+ " Address Line 1: " + Address1 + " Address Line 2: " + Address2 + " City: " + City
									+ " Postcode: " + Postcode + " Email: " + Email + " Validation Message: "
									+ Validation.get(i).getText(),
									MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

				}
			else {
				test.log(Status.INFO,
						" FirstName: " + Firstname + " Lastname: " + Lastname + " Notes: " + Ordernotes
								+ " Address Line 1: " + Address1 + " Address Line 2: " + Address2 + " City: " + City
								+ " Postcode: " + Postcode + " Email: " + Email + " Accepted the Enterd Value",
								MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}

		} catch (Exception e) {
			System.out.println(checkout_xp.OrderConfirmation_Page.getText());
			test.log(Status.FAIL,
					" FirstName: " + Firstname + " Lastname: " + Lastname + " Notes: " + Ordernotes
							+ " Address Line 1: " + Address1 + " Address Line 2: " + Address2 + " City: " + City
							+ " Postcode: " + Postcode + " Email: " + Email + " No Validation Occured",
							MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			e.printStackTrace();
		}

	}
}
