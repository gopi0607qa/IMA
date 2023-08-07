package webElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Manual_upload_xpath extends Testbase{
	public Manual_upload_xpath(WebDriver driver) {
	PageFactory.initElements(driver, this); 
	}	

	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/a[contains(text(),'UPLOAD YOUR OWN')]")
	public WebElement Upload_menu;

	@FindBy(xpath = "//a[@class='button']")
	public WebElement Manual_Upload_product ;

	@FindBy(xpath = "//div[@class='fileUpload']")
	public WebElement File_upload_Button;
	
	@FindBy(xpath = "//img[@src='http://dev.datanetiix.com/orange_coast/wp-content/uploads/2021/12/tmp_1640869102924-547x684.jpg']")				//img[@class='wp-post-image']
	public WebElement Default_photo;
//	
//	@FindBy()
//	public WebElement;

	
}
