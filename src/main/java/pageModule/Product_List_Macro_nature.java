package pageModule;

import java.awt.AWTException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Product_List_xpath;

public class Product_List_Macro_nature extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	public void Product_List(ExtentTest test, WebDriver driver) throws InterruptedException, IOException, AWTException {
		Product_List_xpath Prod_Li_xp = new Product_List_xpath(driver);
		
		Actions actions = new Actions(driver);
		actions.moveToElement(Prod_Li_xp.Category_menu).perform();
		fun.Click(driver, Prod_Li_xp.Macro_Nature_Page);
		
		
		fun.explicit_Wait_List(driver, Prod_Li_xp.Product_List_Category);

		List<WebElement> productelements = Prod_Li_xp.Product_List_Category;
		List<String> products = new ArrayList<String>();
		
		for(WebElement product_element: productelements) {
			products.add(product_element.getText());
		}
			//WebElement next = driver.findElement(By.xpath("//*[@id='main']/nav[2]/ul/li[11]/a"));
			fun.Scroll(driver, Prod_Li_xp.next_page);
			
			try {
				
				while (Prod_Li_xp.next_page.isEnabled()) 
				{	
					//driver.findElement(By.xpath("//*[@id='main']/nav[2]/ul/li[11]/a")).click();
					fun.Scroll(driver, Prod_Li_xp.next_page);
					fun.Click(driver, Prod_Li_xp.next_page);
					productelements = Prod_Li_xp.Product_List_Category;
					
					for(WebElement product_element: productelements) {
						products.add(product_element.getText());
					}
					
				//	next = driver.findElement(By.xpath("//*[@id='main']/nav[2]/ul/li[11]/a"));
					
				}
				
			} catch (Exception e) {

				
				for(String product : products) {
					System.out.println(product);
					int total_products = products.size();
					System.out.println("Total Products   ="+total_products);
		            @SuppressWarnings("resource")
					XSSFWorkbook book = new XSSFWorkbook();     
		            XSSFSheet sheet = book.createSheet("Macro_Nature");
//		            XSSFRow row0 = sheet.createRow(0);
//		            row0.createCell(0).setCellValue("Product List");
		            int rowno = 0;
		            for (String add : products) {          
		                Row row = sheet.createRow(rowno++);
		                createlist(add,row);            
		            }

		            FileOutputStream out = new FileOutputStream(new File("C:\\eclipse\\orange_coast\\src\\test\\resources\\excel\\Macro_Nature.xlsx")); // file name with path
					book.write(out);
					out.close();

				}
			}

			test.log(Status.PASS, "Collected Abstract nature product list",
					MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		}

		private static void createlist(String add, Row row) {
			Cell cell = row.createCell(0);
			cell.setCellValue(add);

		}

	}
		
		
		
		
		
		
//		for (int i = 0; i < productelements.size(); i++) {
//			int num = i + 1;
//			String elem = productelements.get(i).getText();
//			System.out.println(num + "*" + elem + "*");

