package webElement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Testbase;

public class CategoryUI_xpath extends Testbase {
	
	public CategoryUI_xpath(WebDriver driver) {
		PageFactory.initElements(driver, this);
				
	}
	
	@FindBy(xpath="//*[@id=\"site-header\"]/div/nav[1]/div/ul/li/a[contains(text(),'My account')]")
	public WebElement My_Account;

	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/a[contains(text(),'Categories')]")
	public WebElement Category_menu;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/a[contains(text(),'UPLOAD YOUR OWN')]")
	public WebElement Upload_menu;
	
	
	@FindBy(xpath = "//h1[@class='entry-title']")			
	public WebElement Category_Product_List_Header_Title;
	
	@FindBy(xpath = "//*[@id='main']/header/h1")			//Shop
	public WebElement Product_List_Sky_Header;
	

	@FindBy(xpath ="//p[@class = 'woocommerce-result-count']")						//Showing 1–16 of 1376 results
	public WebElement Result_Count;
	
	@FindBy(xpath = "//ul[@class='products columns-4']/li")
	public List<WebElement> Product_List;
	
	@FindBy(xpath = "//*[@class='woocommerce-pagination']/ul/li/a")
	public List<WebElement> Pagination_currentpage_exclude;
	
	@FindBy(xpath = "//*[@class='woocommerce-pagination']/ul/li")
	public List<WebElement> Pagination;
	

	@FindBy(xpath = "//span[@class='page-numbers dots']")
	public WebElement Pagination_dot;
	
	@FindBy(xpath = "//span[@class='page-numbers current']")
	public WebElement Pagination_currentpage;
	
	@FindBy(xpath = "//*[@class='next page-numbers']")
	public WebElement next_page;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Sky')]")
	public WebElement Sky_Page;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Natures Pattern')]")
	public WebElement Natures_Pattern_Page;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Abstract Nature')]")
	public WebElement Abstract_Nature_Page;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Mineral Pattern')]")
	public WebElement Mineral_Pattern_Page;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Stone Pattern')]")
	public WebElement Stone_Pattern_Page;
	
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Wood Texture')]")
	public WebElement Wood_Texture_Page;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Flowers')]")
	public WebElement Flowers_Page;
	
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Macro Nature')]")
	public WebElement Macro_Nature_Page;
	

	
	
	
}
