package execution;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.DriverFactory;
import base.Testbase;
import pageModule.Product_List_Abstract_nature;
import pageModule.Product_List_Flowers;
import pageModule.Product_List_Macro_nature;
import pageModule.Product_List_Mineral_pattern;
import pageModule.Product_List_Natures_pattern;
import pageModule.Product_List_Sky;
import pageModule.Product_List_Stone_pattern;
import pageModule.Product_List_Wood_texture;
import pageModule.Product_List_page;

public class ProductListExtract extends Testbase {

	public Product_List_page product_list = new Product_List_page();
	public Product_List_Abstract_nature product_list_Abstract_nature = new Product_List_Abstract_nature();
	public Product_List_Flowers product_list_Flowers = new Product_List_Flowers();
	public Product_List_Macro_nature product_list_Macro_nature = new Product_List_Macro_nature();
	public Product_List_Mineral_pattern product_list_Mineral_patter = new Product_List_Mineral_pattern();
	public Product_List_Natures_pattern product_list_Natures_pattern = new Product_List_Natures_pattern();
	public Product_List_Sky product_list_Sky = new Product_List_Sky();
	public Product_List_Stone_pattern product_list_Stone_pattern = new Product_List_Stone_pattern();
	public Product_List_Wood_texture product_list_Wood_texture = new Product_List_Wood_texture();
	public static ExtentTest test;
	public static ExtentReports report;
	


	@BeforeSuite
	public void beforesuite() {
		System.out.println("This is before suite");
	}

	@BeforeClass
	public void beforeclass() throws IOException {
		System.out.println("This is before class");

		 report = new ExtentReports();
		 ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/test/resource/output/ExtentReport.html");
		 
		 report.setSystemInfo("User Name", "GopiNath");
		 report.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName().toString());
		 report.setSystemInfo("Operating System",System.getProperty("os.name").toString());
		 report.setSystemInfo("Environment", "Staging");

		 
		 final File CONF = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\extent-config.xml");
		 spark.loadXMLConfig(CONF);
		 
		 report.attachReporter(spark);

	}

	@BeforeMethod
	@Parameters({ "browsername" })
	public void beforemethod(String browsername) throws IOException, InterruptedException {
		System.out.println("Before Method");
		test = report.createTest("Browser Intialization");
		browserinitialization(browsername, test);
	}
	



	@Test(enabled = true)
	public void ProductList() throws InterruptedException, IOException, AWTException {
		System.out.println("Total Products");
		test = report. createTest("Total Products");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list.Product_List(test,driver);

	}

	@Test(enabled = true)
	public void ProductList_abstractnature() throws InterruptedException, IOException, AWTException {
		System.out.println("ProductList_abstractnature");
		test = report. createTest("ProductList_abstractnature");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Abstract_nature.Product_List(test,driver);

	}

	@Test(enabled = true)
	public void ProductList_Flower() throws InterruptedException, IOException, AWTException {
		System.out.println("Flowers");
		test = report. createTest("Flowers");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Flowers.Product_List(test,driver);

	}

	@Test(enabled = true)
	public void ProductList_Macronature() throws InterruptedException, IOException, AWTException {
		System.out.println("Macro_nature");
		test = report. createTest("Macro_nature");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Macro_nature.Product_List(test,driver);

	}

	@Test(enabled = true)
	public void ProductList_Mineralpattern() throws InterruptedException, IOException, AWTException {
		System.out.println("Mineral_pattern");
		test = report. createTest("Mineral_patter");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Mineral_patter.Product_List(test,driver);

	}

	@Test(enabled = true)
	public void ProductList_Naturespattern() throws InterruptedException, IOException, AWTException {
		System.out.println("Natures_pattern");
		test = report. createTest("Natures_pattern");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Natures_pattern.Product_List(test,driver);

	}

	@Test(enabled = true)
	public void ProductList_Sky() throws InterruptedException, IOException, AWTException {
		System.out.println("ProductList_Sky");
		test = report. createTest("ProductList_Sky");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Sky.Product_List(test,driver);

	}

	@Test(enabled = true)
	public void ProductList_Stonepattern() throws InterruptedException, IOException, AWTException {
		System.out.println("ProductList_Stonepattern");
		test = report. createTest("ProductList_Stonepattern");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Stone_pattern.Product_List(test,driver);

	}

	@Test(enabled = true)
	public void ProductList_WoodTexture() throws InterruptedException, IOException, AWTException {
		System.out.println("ProductList_WoodTexture");
		test = report. createTest("ProductList_WoodTexture");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Wood_texture.Product_List(test,driver);

	}

	@AfterMethod

	public void aftermethod() {
		
		DriverFactory.getInstance().Close();
	
	}

	@AfterClass
	public void afterclass() {
		System.out.println("This is after class");
		report.flush();

	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("This is after suite");

	}

}