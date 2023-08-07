package pageModule;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Checkout_xpath;

public class Checkout_page extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	
	public void Checkout(ExtentTest test, WebDriver driver) throws InterruptedException, IOException, AWTException {
		Checkout_xpath checkout_xp = new Checkout_xpath(driver);

		fun.Click(driver, checkout_xp.Product_select);
		System.out.println("Product selected");
		// test.log(Status.PASS, "Product Selected",
		// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		// Product Description Page

		fun.Click(driver, checkout_xp.No_Mural_Radio);
		System.out.println("Mural selected");
		// test.log(Status.PASS, "Mural Selected",
		// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Scroll(driver, checkout_xp.Width_input);
		fun.Sendkeys(driver, checkout_xp.Width_input, "200");
		// System.out.println("Width entered");

		fun.Sendkeys(driver, checkout_xp.Hieght_input, "200");
		System.out.println("Height Entered");
		// test.log(Status.PASS, "Width and Hieght Entered",
		// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Scroll(driver, checkout_xp.Flipimage_Checkbox);
		fun.Click(driver, checkout_xp.Flipimage_Checkbox);

		fun.Scroll(driver, checkout_xp.Flipimage_Checkbox);
		fun.Click(driver, checkout_xp.Flipimage_Checkbox);
		fun.explicit_Wait(driver, checkout_xp.Crop_image);
		System.out.println("Flipimage Selected");
		// test.log(Status.PASS, "Flipimage Selected",
		// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Click(driver, checkout_xp.BlackandWhite_Checkbox);
		fun.explicit_Wait(driver, checkout_xp.Crop_image);
		System.out.println("BlackandWhite Selected");
//		test.log(Status.PASS, "Black and white selected", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Click(driver, checkout_xp.Protectivetop_Checkbox);
		System.out.println("Protective Top Selected");
		// test.log(Status.PASS, "Protective top Selected",
		// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Scroll(driver, checkout_xp.Quantity_input);
		fun.Sendkeys(driver, checkout_xp.Quantity_input, "3");
		// test.log(Status.PASS, "Quantity Entered",
		// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		System.out.println("Quantity entered");

		fun.Scroll(driver, checkout_xp.AddtoCart_Button);
		fun.Click(driver, checkout_xp.AddtoCart_Button);
		System.out.println("Product added to cart");
		// test.log(Status.PASS, "Add to Cart Clicked",
		// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		// Cart menu

		try {
			fun.explicit_Wait(driver, checkout_xp.AddtoCart_icon_number);
//		test.log(Status.PASS, "Product Added to the Cart", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			fun.Click(driver, checkout_xp.AddtoCart_icon);
			fun.Click(driver, checkout_xp.ViewCart_Button);
			// test.log(Status.PASS, "Navigated to Cart Page",
			// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		} catch (Exception e) {

			fun.explicit_Wait(driver, checkout_xp.AddtoCart_icon_number);
			// test.log(Status.PASS, "Product Added to the Cart",
			// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			fun.Click(driver, checkout_xp.AddtoCart_icon);
			fun.Click(driver, checkout_xp.ViewCart_Button);
			// test.log(Status.PASS, "Navigated to Cart Page",
			// MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
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
		
		
		fun.Sendkeys(driver, checkout_xp.Billing_Firstname, "Rajesh");
		fun.Sendkeys(driver, checkout_xp.Billing_Lastname, "k");
		test.log(Status.PASS, "Firstname Lastname Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Order_notes, "Automation Test by Gopinath");
		test.log(Status.PASS, "Order notes Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Billing_Company, "Datanetiix");
		test.log(Status.PASS, "Billing Company Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		Select country = new Select(checkout_xp.Billing_Country);
		country.selectByVisibleText("United States (US)");
		test.log(Status.PASS, "Billing Country Selected", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Billing_address_1, "15, Groove Street");
		fun.Sendkeys(driver, checkout_xp.Billing_address_2, "1st Avenue");
		test.log(Status.PASS, "Billing Address Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Scroll(driver, checkout_xp.Billing_City);
		fun.Sendkeys(driver, checkout_xp.Billing_City, "Venice");
		test.log(Status.PASS, "Billing City Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Scroll(driver, checkout_xp.Billing_State);
		Select state = new Select(checkout_xp.Billing_State);
		state.selectByVisibleText("Alaska");
		test.log(Status.PASS, "Billing State Selected", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Scroll(driver, checkout_xp.Billing_postcode);
		fun.Sendkeys(driver, checkout_xp.Billing_postcode, "99501");
		test.log(Status.PASS, "Billing Postcode Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Billing_Mobile, "9876547890");
		test.log(Status.PASS, "Billing Mobile Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.Sendkeys(driver, checkout_xp.Billing_Email, "gopinath@datanetiix.com");
		System.out.println("Billing Address entered");
		test.log(Status.PASS, "Billing Email Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		// Card Payment
		fun.Scroll(driver, checkout_xp.Card_No);
		Thread.sleep(5000);

		StringBuffer cardNumber = new StringBuffer().append("1111");

		StringBuffer cardExpiry = new StringBuffer().append("2026");

		StringBuffer cardCVV = new StringBuffer().append("585");

		fun.Click(driver, checkout_xp.Card_No);
		fun.Sendkeys(driver, checkout_xp.Card_No, "4111");
		fun.Sendkeys(driver, checkout_xp.Card_No, cardNumber);
		fun.Sendkeys(driver, checkout_xp.Card_No, cardNumber);
		fun.Sendkeys(driver, checkout_xp.Card_No, cardNumber);
		System.out.println("Cardnumber entered");
		fun.Scroll(driver, checkout_xp.Card_Expiry);
		fun.Click(driver, checkout_xp.Card_Expiry);
		fun.Sendkeys(driver, checkout_xp.Card_Expiry,"08");
		fun.Sendkeys(driver, checkout_xp.Card_Expiry, cardExpiry);
		fun.Click(driver, checkout_xp.Card_CVV);
		fun.Sendkeys(driver, checkout_xp.Card_CVV, cardCVV);
		System.out.println("Card Details Entered");
		test.log(Status.PASS, "Card details Entered", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		fun.Scroll(driver, checkout_xp.PlaceOrder_Button);
		fun.explicit_Wait(driver, checkout_xp.Card_No);
		fun.Click(driver, checkout_xp.PlaceOrder_Button);
		System.out.println("Place Order button id clicked");
		test.log(Status.PASS, "PlaceOrder Button CLicked", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		fun.explicit_Wait(driver, checkout_xp.OrderConfirmation_Page);
		
		String order_Confirm = checkout_xp.OrderConfirmation_Page.getText();
		if (order_Confirm.contains("Your order has been")) {
			System.out.println("Navigated to Order Confirmation Page");
			test.log(Status.PASS, "Order Placed Succesfully", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		} else {
			System.out.println("Order is Not Placed");
			test.log(Status.PASS, "Order Placed Not Placed", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		}

	}
}