package pageModule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.CategoryUI_xpath;

public class Category_sky_Caption extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	public void Category(ExtentTest test, WebDriver driver, String Header) throws IOException {

		CategoryUI_xpath catUI_xp = new CategoryUI_xpath(driver);

		Actions actions = new Actions(driver);
		actions.moveToElement(catUI_xp.Category_menu).perform();
		fun.Click(driver, catUI_xp.Sky_Page);


		String myaccount = catUI_xp.My_Account.getText();
		String catogery = catUI_xp.Category_menu.getText();
		String upload_menu = catUI_xp.Upload_menu.getText();
		String home_Result = catUI_xp.Result_Count.getText();
		String shop = catUI_xp.Product_List_Sky_Header.getText();

		List<WebElement> pagination = catUI_xp.Pagination;

		int count = pagination.size();

		List<WebElement> pagination_exclude = catUI_xp.Pagination_currentpage_exclude;

		//String Nextpage = pagination_exclude.get(6).getAttribute("class");
		// String number_dot = catUI_xp.Pagination_dot.getAttribute("class");
		String Currrentpage = catUI_xp.Pagination_currentpage.getAttribute("aria-current");

		List<WebElement> product_list = catUI_xp.Product_List;

		int product_count = product_list.size();

		// while (catUI_xp.next_page.isDisplayed() == true) {

		while (catUI_xp.next_page.isDisplayed() == true) {
			if (myaccount.equalsIgnoreCase("My account")) {

				fun.Scroll(driver, catUI_xp.My_Account);
				System.out.println("My Account caption matches");
				test.log(Status.PASS, "My Account caption Matches "+" Title : "+myaccount,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.My_Account);
				System.out.println("My Account caption Does not matches");
				test.log(Status.FAIL, "My Account caption Matches"+" Title : "+myaccount,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (catogery.equalsIgnoreCase("Categories")) {

				fun.Scroll(driver, catUI_xp.Category_menu);
				System.out.println("Categories caption matches");
				test.log(Status.PASS, "Categories caption Matches"+" Title : "+catogery,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Category_menu);
				System.out.println("Categories caption does not matches");
				test.log(Status.FAIL, "Categories caption Matches"+" Title : "+catogery,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (upload_menu.equalsIgnoreCase("UPLOAD YOUR OWN")) {

				fun.Scroll(driver, catUI_xp.Upload_menu);
				System.out.println("Uplod your own caption matches");
				test.log(Status.PASS, "Upload your own caption Matches"+" Title : "+upload_menu,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Upload_menu);
				System.out.println("Uplod your own caption does not matches");
				test.log(Status.FAIL, "Upload your own caption does not Matches"+" Title : "+upload_menu,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (home_Result.contains("Showing") == true) {

				fun.Scroll(driver, catUI_xp.Result_Count);
				System.out.println("Product Result count Displayed");
				test.log(Status.PASS, "Product Result count Displayed"+" Result count : "+home_Result,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Result_Count);
				System.out.println("Product Result count not Displayed properly");
				test.log(Status.FAIL, "Product Result count not Displayed properly"+" Result count : "+home_Result,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (shop.equalsIgnoreCase(Header)) {

				fun.Scroll(driver, catUI_xp.Product_List_Sky_Header);
				System.out.println("Shop List caption matches");
				test.log(Status.PASS, "Upload your own caption Matches"+" Title : "+Header,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Product_List_Sky_Header);
				System.out.println("Shop List caption does not matches");
				test.log(Status.FAIL, "Upload your own caption Matches"+" Title : "+Header,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (product_count == 16) {

				System.out.println("Number of product Results in page is : " + product_count);
				test.log(Status.PASS, "Number of product Results in page is : " + product_count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			} else if (product_count == 12) {

				System.out.println("Number of product Results in page is : " + product_count);
				test.log(Status.PASS, "Number of product Results in page is : " + product_count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				System.out.println("Number of product Results in page is wrong : " + product_count);
				test.log(Status.FAIL, "Number of product Results in page is wrong : " + product_count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (count == 9) {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("Page number Dot is not present at fourth place in Pagination");
				test.log(Status.PASS, "Page number Dot is present not at fourth palce in Pagination",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			} else if (count == 10) {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("Pagination count" + count);
				test.log(Status.PASS, "Pagination count" + count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("pagination size is wrong: " + count);
				test.log(Status.FAIL, "pagination size is wrong : " + count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}


			
			fun.Scroll(driver, catUI_xp.Pagination_currentpage);

			if (Currrentpage.equalsIgnoreCase("page")) {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("Current page number is " + catUI_xp.Pagination_currentpage.getText());
				test.log(Status.PASS, "Current page number is " + catUI_xp.Pagination_currentpage.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("Current page number is not " + catUI_xp.Pagination_currentpage.getText());
				test.log(Status.FAIL, "Current page number is not " + catUI_xp.Pagination_currentpage.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}

//			if (catUI_xp.next_page.isDisplayed() == true) {
//
//				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
//				System.out.println("Next page number is present at end of Pagination ");
//				test.log(Status.PASS, "Next page number is present at end of Pagination",
//						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
//
//			} else if (catUI_xp.next_page.isDisplayed() == false) {
//
//				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
//				System.out.println("Next page number is not present end of Pagination" + Nextpage);
//				test.log(Status.INFO, "Next page number is not present end of Pagination",
//						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
//
//			}

			fun.Click(driver, catUI_xp.next_page);
		}
	}

	public void lastpage(ExtentTest test, WebDriver driver, String Header) throws IOException {

		CategoryUI_xpath catUI_xp = new CategoryUI_xpath(driver);

		Category_sky_Caption cap = new Category_sky_Caption();

		try {

			cap.Category(test, driver, Header);

		} catch (Exception e) {
			
			e.printStackTrace();

			String myaccount = catUI_xp.My_Account.getText();
			String catogery = catUI_xp.Category_menu.getText();
			String upload_menu = catUI_xp.Upload_menu.getText();
			String home_Result = catUI_xp.Result_Count.getText();
			String shop = catUI_xp.Product_List_Sky_Header.getText();

			List<WebElement> pagination = catUI_xp.Pagination;

			int count = pagination.size();

			//List<WebElement> pagination_exclude = catUI_xp.Pagination_currentpage_exclude;

			//String Nextpage = pagination_exclude.get(6).getAttribute("class");
			// String number_dot = catUI_xp.Pagination_dot.getAttribute("class");
			String Currrentpage = catUI_xp.Pagination_currentpage.getAttribute("aria-current");

			List<WebElement> product_list = catUI_xp.Product_List;

			int product_count = product_list.size();

			if (myaccount.equalsIgnoreCase("My account")) {

				fun.Scroll(driver, catUI_xp.My_Account);
				System.out.println("My Account caption matches");
				test.log(Status.PASS, "My Account caption Matches",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.My_Account);
				System.out.println("My Account caption Does not matches");
				test.log(Status.FAIL, "My Account caption Matches",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (catogery.equalsIgnoreCase("Categories")) {

				fun.Scroll(driver, catUI_xp.Category_menu);
				System.out.println("Categories caption matches");
				test.log(Status.PASS, "Categories caption Matches",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Category_menu);
				System.out.println("Categories caption does not matches");
				test.log(Status.FAIL, "Categories caption Matches",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (upload_menu.equalsIgnoreCase("UPLOAD YOUR OWN")) {

				fun.Scroll(driver, catUI_xp.Upload_menu);
				System.out.println("Uplod your own caption matches");
				test.log(Status.PASS, "Upload your own caption Matches",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Upload_menu);
				System.out.println("Uplod your own caption does not matches");
				test.log(Status.FAIL, "Upload your own caption does not Matches",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (home_Result.contains("Showing") == true) {

				fun.Scroll(driver, catUI_xp.Result_Count);
				System.out.println("Product Result count Displayed");
				test.log(Status.PASS, "Product Result count Displayed",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Result_Count);
				System.out.println("Product Result count not Displayed properly");
				test.log(Status.FAIL, "Product Result count not Displayed properly",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (shop.equalsIgnoreCase(Header)) {

				fun.Scroll(driver, catUI_xp.Product_List_Sky_Header);
				System.out.println("Shop List caption matches");
				test.log(Status.PASS, "Upload your own caption Matches",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Product_List_Sky_Header);
				System.out.println("Shop List caption does not matches");
				test.log(Status.FAIL, "Upload your own caption Matches",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			if (product_count == 16) {

				System.out.println("Number of product Results in page is : " + product_count);
				test.log(Status.PASS, "Number of product Results in page is : " + product_count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			} else if (product_count == 12) {

				System.out.println("Number of product Results in page is : " + product_count);
				test.log(Status.PASS, "Number of product Results in page is : " + product_count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else if (product_count == 11) {

				System.out.println("Number of product Results in page is : " + product_count);
				test.log(Status.PASS, "Number of product Results in page is : " + product_count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {
				
				System.out.println("Number of product Results in page is : " + product_count);
				test.log(Status.INFO, "Number of product Results in page is  : " + product_count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
				
			}
			if (count == 9) {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("Page number Dot is not present at fourth place in Pagination");
				test.log(Status.FAIL, "Page number Dot is present not at fourth palce in Pagination",
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
			} else if (count == 10) {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("Pagination count" + count);
				test.log(Status.PASS, "Pagination count" + count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("pagination size is wrong: " + count);
				test.log(Status.FAIL, "pagination size is wrong : " + count,
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}


			fun.Scroll(driver, catUI_xp.Pagination_currentpage);

			if (Currrentpage.equalsIgnoreCase("page")) {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("Current page number is " + catUI_xp.Pagination_currentpage.getText());
				test.log(Status.PASS, "Current page number is " + catUI_xp.Pagination_currentpage.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			} else {

				fun.Scroll(driver, catUI_xp.Pagination_currentpage);
				System.out.println("Current page number is not " + catUI_xp.Pagination_currentpage.getText());
				test.log(Status.FAIL, "Current page number is not " + catUI_xp.Pagination_currentpage.getText(),
						MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

			}
			
			System.out.println("This is the last page");

			test.log(Status.INFO, "This is Last Page",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());

		}

	}
}
