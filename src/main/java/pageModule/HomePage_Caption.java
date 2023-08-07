package pageModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Homepage_xpath;

public class HomePage_Caption extends Testbase {
	public static BasicFunction fun = new BasicFunction();
	
	
	public void Home(ExtentTest test, WebDriver driver) throws IOException {
		
		Homepage_xpath home_xp = new Homepage_xpath(driver);
		
		String myaccount =home_xp.My_Account.getText();
		String catogery =home_xp.Category_menu.getText();
		String upload_menu =home_xp.Upload_menu.getText();
		String home_Result =home_xp.HomePage_Result_Count.getText();
		String shop = home_xp.Product_List_Header_Title.getText();
		
		
		List<WebElement> pagination = home_xp.Pagination;
		
		int count = pagination.size();

		List<WebElement> pagination_exclude = home_xp.Pagination_currentpage_exclude;
		
		String Nextpage = pagination_exclude.get(6).getAttribute("class");
		String number_dot = home_xp.Pagination_dot.getAttribute("class");
		String Currrentpage = home_xp.Pagination_currentpage.getAttribute("aria-current");    
		

		
		List<WebElement> product_ist = home_xp.Product_List_Category;
		
		int product_count = product_ist.size();
		
		if (myaccount.equalsIgnoreCase("My account")) {
			
			fun.Scroll(driver, home_xp.My_Account);
			System.out.println("My Account caption matches");
			test.log(Status.PASS, "My Account caption Matches", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		} else {
			
			fun.Scroll(driver, home_xp.My_Account);
			System.out.println("My Account caption Does not matches");
			test.log(Status.FAIL, "My Account caption Matches", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		}
		
		if (catogery.equalsIgnoreCase("Categories")) {
			
			fun.Scroll(driver, home_xp.Category_menu);
			System.out.println("Categories caption matches");
			test.log(Status.PASS, "Categories caption Matches", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		} else {
			
			fun.Scroll(driver, home_xp.Category_menu);
			System.out.println("Categories caption does not matches");
			test.log(Status.FAIL, "Categories caption Matches", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		}
		
		
		Actions actions = new Actions(driver);
		actions.moveToElement(home_xp.Category_menu).perform();
		
		List<WebElement> categories = home_xp.Category_drop_menu;
		List<String> catsubmenu = new ArrayList<String>();


		for (WebElement submenulist : categories) {
			catsubmenu.add(submenulist.getText());

		}
		String catsub=catsubmenu.toString();
		System.out.println(catsub);
		test.log(Status.INFO, catsub, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		
		for(int i=0;i<=6;i++) {
		actions.moveToElement(home_xp.Category_menu).perform();
		fun.Click(driver, categories.get(i));
		//categories.get(i).click();
		String title = driver.getTitle();
		System.out.println(title);
		test.log(Status.INFO, "Title of the Page is : "+title, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		driver.navigate().back();
		}
		

		actions.moveToElement(home_xp.Category_menu).perform();
		fun.explicit_Wait_Click(driver, home_xp.Sky_Page);
		fun.Click(driver, home_xp.Sky_Page);
		String title = driver.getTitle();
		System.out.println(title);
		test.log(Status.INFO, "Title of the Page is : "+title, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		driver.navigate().back();
		
		if (upload_menu.equalsIgnoreCase("UPLOAD YOUR OWN")) {
			

			fun.Scroll(driver, home_xp.Upload_menu);
			System.out.println("Uplod your own caption matches");
			test.log(Status.PASS, "Upload your own caption Matches", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		} else {


			fun.Scroll(driver, home_xp.Upload_menu);
			System.out.println("Uplod your own caption does not matches");
			test.log(Status.FAIL, "Upload your own caption does not Matches", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		}
		
		
		if (home_Result.equalsIgnoreCase("Showing 1–16 of 1376 results")) {
			

			fun.Scroll(driver, home_xp.HomePage_Result_Count);
			System.out.println("Product Result count Displayed");
			test.log(Status.PASS, "Product Result count Displayed", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		} else {
			
			fun.Scroll(driver, home_xp.HomePage_Result_Count);
			System.out.println("Product Result count not Displayed properly");
			test.log(Status.FAIL, "Product Result count not Displayed properly", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		}
		
		
		if (shop.equalsIgnoreCase("Shop")) {
			

			fun.Scroll(driver, home_xp.Product_List_Header_Title);
			System.out.println("Shop List caption matches");
			test.log(Status.PASS, "Upload your own caption Matches", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
			
		} else {

			
			fun.Scroll(driver, home_xp.Product_List_Header_Title);
			System.out.println("Shop List caption does not matches");
			test.log(Status.FAIL, "Upload your own caption Matches", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		}
		
		if (product_count == 16) {
			
			
			System.out.println("Number of product Results in Homepage is : "+product_count);
			test.log(Status.PASS, "Number of product Results in Homepage is : "+product_count, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		} else {


			System.out.println("Number of product Results in Homepage is not : "+product_count);
			test.log(Status.FAIL,"Number of product Results in Homepage is not : "+product_count, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		}
		
		
		if (count==9) {
			

			fun.Scroll(driver, home_xp.Pagination_dot);
			System.out.println("pagination size is : "+count);
			test.log(Status.PASS,"pagination size is : "+count, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
			
		} else {
			
			fun.Scroll(driver, home_xp.Pagination_dot);
			System.out.println("pagination size is not : "+count);
			test.log(Status.FAIL,"pagination size is not : "+count, MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		}
		
		if (number_dot.equalsIgnoreCase("page-numbers dots")) {
			
			fun.Scroll(driver, home_xp.Pagination_dot);
			System.out.println("Page number Dot is present at fourth place in Pagination");
			test.log(Status.PASS,"Page number Dot is present at fourth palce in Pagination", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		} else {
			
			fun.Scroll(driver, home_xp.Pagination_dot);
			System.out.println("Page number Dot is not present at fourth place in Pagination");
			test.log(Status.FAIL,"Page number Dot is present not at fourth palce in Pagination", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			

		}
		
		if (Nextpage.equalsIgnoreCase("next page-numbers")) {
			
			fun.Scroll(driver, home_xp.Pagination_dot);
			System.out.println("Next page number is present at end of Pagination ");
			test.log(Status.PASS,"Next page number is present at end of Pagination", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
			
		} else {
			
			fun.Scroll(driver, home_xp.Pagination_dot);
			System.out.println("Next page number is not present end of Pagination"+Nextpage);
			test.log(Status.FAIL,"Next page number is not present end of Pagination", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			

		}
		
		if (Currrentpage.equalsIgnoreCase("page")) {
			
			fun.Scroll(driver, home_xp.Pagination_currentpage);
			System.out.println("Current page number is "+home_xp.Pagination_currentpage.getText());
			test.log(Status.PASS,"Current page number is "+home_xp.Pagination_currentpage.getText(), MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
			
		} else {
			

			fun.Scroll(driver, home_xp.Pagination_currentpage);
			System.out.println("Current page number is not "+home_xp.Pagination_currentpage.getText());
			test.log(Status.FAIL,"Current page number is not "+home_xp.Pagination_currentpage.getText(), MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			
		}
		
		
	}

}
