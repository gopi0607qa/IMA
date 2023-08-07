package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Login_xpath extends Testbase {
	public Login_xpath(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id=\"site-header\"]/div/nav[1]/div/ul/li/a[contains(text(),'My account')]")
	public WebElement My_Account;

	@FindBy(id = "username")
	public WebElement Username_Field;

	@FindBy(id = "password")
	public WebElement password_Field;

	@FindBy(xpath = "//*[@id=\'customer_login\']/div[1]/form/p[3]/button")
	public WebElement Login_Button;

	@FindBy(xpath = "//ul[@class='woocommerce-error']/li")
	public WebElement Error_text;
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']/li/strong")
	public WebElement Error_strong_text;

	@FindBy(xpath = "//*[@id='primary']/main/div/div[1]/nav/ul/li[1]/a")
	public WebElement Dashboard_user;
	
	
	//ul[@class="woocommerce-error"]/li

}