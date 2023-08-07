package webElement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_List_xpath{
	

	
	public Product_List_xpath(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@class='next page-numbers']")
	public WebElement next_page;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/a[contains(text(),'Categories')]")
	public WebElement Category_menu;
	

	
	@FindBy(xpath = "//ul[@class=\"products columns-4\"]")
	public List<WebElement> Product_List_Category;
	
	
	
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
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Natures Pattern')]")
	public WebElement Natures_Pattern_Page;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Macro Nature')]")
	public WebElement Macro_Nature_Page;
	
	@FindBy(xpath = "//nav[@class='site-navigation show']/div/ul/li/ul/li/a[contains(text(),'Sky')]")
	public WebElement Sky_Page;
	
	


}
