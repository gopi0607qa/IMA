package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Checkout_xpath extends Testbase {
	public Checkout_xpath(WebDriver driver) {
		PageFactory.initElements(driver, this);
				
	}
	
	
	@FindBy(xpath = "//*[@id='main']/ul/li[2]/a[2]")
	public WebElement Product_select;
	
	@FindBy(xpath = "//*[@id='no_mural']")
	public WebElement No_Mural_Radio;
	
	
	@FindBy(xpath = "//*[@id='options_width_inch']")
	public WebElement Width_input;
	
	
	@FindBy(xpath = "//*[@id='options_height_inch']")
	public WebElement Hieght_input;
	
	@FindBy(xpath = "//*[@id='protective_top']")
	public WebElement Protectivetop_Checkbox;
	
	@FindBy(xpath = "//*[@id='flip_img']")
	public WebElement Flipimage_Checkbox;
	
	@FindBy(xpath = "//*[@id='balck_white']")
	public WebElement BlackandWhite_Checkbox;
	
	@FindBy(xpath = "//*[@id='product-8233']/div[3]/form[2]/div/input")
	public WebElement Quantity_input;
	
	@FindBy(xpath = "//*[@id='product-8233']/div[3]/form[2]/button")
	public WebElement AddtoCart_Button;
	
	@FindBy(xpath = "//a[@class='wmc-cart']/img")
	public WebElement AddtoCart_icon;
	
	@FindBy(xpath = "//a[@class='wmc-cart']/child::span[contains(text(),'3')]")
	public WebElement AddtoCart_icon_number;
	
	
	@FindBy(xpath ="//div[@class='wmc-bottom-buttons'] /child:: a [contains(text(),'View Cart')]")
	public WebElement ViewCart_Button;
	
	@FindBy(xpath = "//*[@id='primary']/main/div/div[1]/div[2]/div/div/a")
	public WebElement Checkout_Button;
	
	@FindBy(xpath = "//*[@id='billing_first_name']")
	public WebElement Billing_Firstname;
	
	@FindBy(xpath = "//*[@id='billing_last_name']")
	public WebElement Billing_Lastname;
	
	
	@FindBy(xpath = "//*[@id='order_comments']")
	public WebElement Order_notes;
	
	
	@FindBy(xpath = "//*[@id='billing_company']")
	public WebElement Billing_Company;
	
	@FindBy(xpath = "//*[@id='billing_country']")
	public WebElement Billing_Country;
	
	@FindBy(xpath = "//*[@id='billing_state']")
	public WebElement Billing_State;
	
	
	@FindBy(xpath = "//*[@id='billing_address_1']")
	public WebElement Billing_address_1;
	
	
	@FindBy(xpath = "//*[@id='billing_address_2']")
	public WebElement Billing_address_2;
	
	
	@FindBy(xpath = "//*[@id='billing_city']")
	public WebElement Billing_City;
	
	
	@FindBy(xpath = "//*[@id='billing_postcode']")
	public WebElement Billing_postcode;
	
	
	@FindBy(xpath = "//*[@id='billing_phone']")
	public WebElement Billing_Mobile;
	
	
	@FindBy(xpath = "//*[@id='billing_email']")
	public WebElement Billing_Email;
	

	@FindBy(xpath = "//*[@id='payment']")
	public WebElement Payment_frame;
	
	
	
	@FindBy(xpath = "//*[@id='authnet-card-number']")
	public WebElement Card_No;
	
	@FindBy(xpath = "//*[@id='authnet-card-expiry']")
	public WebElement Card_Expiry;

	
	@FindBy(xpath = "//*[@id='authnet-card-cvc']")
	public WebElement Card_CVV;

	
	@FindBy(xpath = "//*[@id='place_order']")
	public WebElement PlaceOrder_Button;
	
	@FindBy(xpath = "//*[@id='primary']/main/div/div[1]/div/p")
	public WebElement OrderConfirmation_Page;
	
//	@FindBy()
//	public WebElement
	
	@FindBy(xpath = "//figure[@class='woocommerce-product-gallery__wrapper']/div/div[1]/div[1]/div[5]")
	public WebElement Crop_image;


	@FindBy(xpath = "//*[@id='show_msg']")  //Please select the appropriate parameters and then add the product to cart.
	public WebElement Empty_dimension_message;
	
	@FindBy(xpath = "//*[@id='alert_msg']")  ///The size should be between Minimum Width (1") and Maximum Width (240") and within Minimum Height (1") and Maximum Height (300")
	public WebElement dimension_alert_msg;
	
	@FindBy(xpath = "//*[@id='height_error']")  //Required field 
	public WebElement height_error;
	
	@FindBy(xpath = "//*[@id='width_error']")   //Required field 
	public WebElement width_error;
	
	@FindBy(xpath = "//img[@class='greyscale']")
	public WebElement Blackandwhite_image;

	
	@FindBy(xpath = "//img[@class='flipped']")
	public WebElement flipped_image;
	
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']")
	public WebElement Billing_error;
	
//	@FindBy()
//	public WebElement
//	
//	@FindBy()
//	public WebElement
//	
//	@FindBy()
//	public WebElement
//	
//	@FindBy()
//	public WebElement
	
	
	
	

}
