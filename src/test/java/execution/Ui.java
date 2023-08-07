package execution;

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
import pageModule.Category_abstract_Caption;
import pageModule.Category_flowers_Caption;
import pageModule.Category_macro_Caption;
import pageModule.Category_mineral_Caption;
import pageModule.Category_nature_Caption;
import pageModule.Category_sky_Caption;
import pageModule.Category_stone_Caption;
import pageModule.Category_wood_Caption;
import pageModule.HomePage_Caption;

public class Ui extends Testbase {
	
	public HomePage_Caption homePage = new HomePage_Caption();
	public Category_nature_Caption nature = new Category_nature_Caption();
	public Category_abstract_Caption abstrac = new Category_abstract_Caption();
	public Category_flowers_Caption flower = new Category_flowers_Caption();
	public Category_macro_Caption macro = new Category_macro_Caption();
	public Category_mineral_Caption mineral = new Category_mineral_Caption();
	public Category_stone_Caption stone = new Category_stone_Caption();
	public Category_wood_Caption wood = new Category_wood_Caption();
	public Category_sky_Caption sky = new Category_sky_Caption();
	public static  ExtentTest test;
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

	@Test(enabled = true )
	
	public void Homepage() throws IOException {
		
		System.out.println("Homepage UI Test");
		test = report.createTest("Homepage UI Test");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		homePage.Home(test, driver);
	

	}
	
	
	@Test(enabled = true)
	
	public void Abstract_cat() throws IOException {
		
		System.out.println("Abstract UI Test");
		test = report.createTest("Abstract UI Test");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		String header = "Abstract Nature";
		abstrac.lastpage(test, driver, header);
	

	}
	
	@Test(enabled = true)
	
	public void nature_cat() throws IOException {
		
		System.out.println("Nature page UI Test");
		test = report.createTest("Nature page UI Test");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		String header = "Natures Pattern";
		nature.lastpage(test, driver, header);
	

	}
	
	
	@Test(enabled = true)
	
	public void stone_cat() throws IOException {
		
		System.out.println("Stone page UI Test");
		test = report.createTest("Stone page UI Test");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		String header = "Stone Pattern";
		stone.lastpage(test, driver, header);
	

	}
	
	
	@Test(enabled = true)
	
	public void mineral_cat() throws IOException {
		
		System.out.println("Mineral page UI Test");
		test = report.createTest("Mineral page UI Test");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		String header = "Mineral Pattern";
		mineral.lastpage(test, driver, header);
	

	}
	
	
	@Test(enabled = true)
	
	public void wood_cat() throws IOException {
		
		System.out.println("Wood page UI Test");
		test = report.createTest("Wood page UI Test");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		String header = "Wood Texture";
		wood.lastpage(test, driver, header);
	

	}
	
	
	@Test(enabled = true)
	
	public void macro_cat() throws IOException {
		
		System.out.println("Macro page UI Test");
		test = report.createTest("Macro page UI Test");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		String header = "Macro Nature";
		macro.lastpage(test, driver, header);
	

	}
	
	
	@Test(enabled = true)
	
	public void flowers_cat() throws IOException {
		
		System.out.println("Flowers page UI Test");
		test = report.createTest("Flowers page UI Test");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		String header = "Flowers";
		flower.lastpage(test, driver, header);
	

	}
	
	
	@Test(enabled = true)
	
	public void sky() throws IOException {
		
		System.out.println("Sky page UI Test");
		test = report.createTest("Sky page UI Test");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		String header = "Sky";
		sky.lastpage(test, driver, header);
	
	}
	
	
	@AfterMethod
	public void aftermethod() {
		DriverFactory.getInstance().Close();
		System.out.println("This is after method");
		// driver.close();
		
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
