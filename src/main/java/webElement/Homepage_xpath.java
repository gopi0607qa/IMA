package webElement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class Homepage_xpath extends Testbase {
	public Homepage_xpath(WebDriver driver) {
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(xpath="//*[@id=\"site-header\"]/div/nav[1]/div/ul/li/a[contains(text(),'My account')]")
	public WebElement My_Account;

	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/a[contains(text(),'Categories')]")
	public WebElement Category_menu;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/a[contains(text(),'UPLOAD YOUR OWN')]")
	public WebElement Upload_menu;
	
	
	@FindBy(xpath = "//*[@id='main']/header/h1")			//Shop
	public WebElement Product_List_Header_Title;
	
	
	@FindBy(xpath ="//p[@class = 'woocommerce-result-count']")						//Showing 1–16 of 1376 results
	public WebElement HomePage_Result_Count;
	
	
	
	@FindBy(xpath = "//ul[@class='products columns-4']/li")
	public List<WebElement> Product_List_Category;
	
	@FindBy(xpath = "//*[@class='woocommerce-pagination']/ul/li/a")
	public List<WebElement> Pagination_currentpage_exclude;
	
	@FindBy(xpath = "//*[@class='woocommerce-pagination']/ul/li")
	public List<WebElement> Pagination;
	

	@FindBy(xpath = "//span[@class='page-numbers dots']")
	public WebElement Pagination_dot;
	
	@FindBy(xpath = "//span[@class='page-numbers current']")
	public WebElement Pagination_currentpage;
	
	
	@FindBy(xpath="//nav[@class='site-navigation show']/div/ul/li[2]/ul/li")
	public List<WebElement> Category_drop_menu;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Sky')]")
	public WebElement Sky_Page;
	
//	@FindBy()
//	public WebElement
	
//	@FindBy()
//	public WebElement

}
