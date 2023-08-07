package execution;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.DriverFactory;
import base.Testbase;
import pageModule.Billing_Address_Validation;
import pageModule.Checkout_page;
import pageModule.Invalid_Login_page;
import pageModule.Login_page;
import pageModule.Manual_Upload;
import pageModule.Product_description_dimesion_validation_page;
import util.ReadExcel;

public class Smoke extends Testbase {

	public Product_description_dimesion_validation_page dim_valid = new Product_description_dimesion_validation_page();
	public Login_page login = new Login_page();
	public Invalid_Login_page invalid_login = new Invalid_Login_page();
	public Checkout_page checkout = new Checkout_page();
	public Manual_Upload man_upload = new Manual_Upload();
	public Billing_Address_Validation bill_val = new Billing_Address_Validation();
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
		ExtentSparkReporter spark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/src/test/resource/output/ExtentReport.html");

		report.setSystemInfo("User Name", "GopiNath");
		report.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostName().toString());
		report.setSystemInfo("Operating System", System.getProperty("os.name").toString());
		report.setSystemInfo("Environment", "Staging");

		final File CONF = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config\\extent-config.xml");
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

	@DataProvider(name = "Mural_dimensions", parallel = true)
	public Object[][] readExcel2() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"Mural_dimensions");
	}

	@DataProvider(name = "Billing_Data_empty", parallel = true)
	public Object[][] readExcel3() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"Billing_Data_empty");
	}

	@DataProvider(name = "LoginValidData", parallel = true)
	public Object[][] readExcel() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"LoginValidData");
	}

	@DataProvider(name = "LoginInvalidData", parallel = true)
	public Object[][] readExcel1() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"LoginInvalidData");

	}

	@Test(dataProvider = "LoginValidData", threadPoolSize = 2, enabled = false)
	public void Logintest(String UserName, String Password) throws InterruptedException, IOException, AWTException {
		System.out.println("Login Test case");
		test = report.createTest("Login Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		login.Login(test, driver, UserName, Password);
	}

	@Test(dataProvider = "LoginInvalidData", enabled = false)
	public void Invalid_Logintest(String UserName, String Password)
			throws InterruptedException, IOException, AWTException {
		System.out.println("Invalid Login Test case");
		test = report.createTest("InvalidLogin Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		invalid_login.Invalid_Login(test, driver, UserName, Password);

	}

	@Test(dataProvider = "Mural_dimensions", threadPoolSize = 6, enabled = false)
	public void Product_Description(String Height, String Width)
			throws InterruptedException, IOException, AWTException {
		System.out.println("Dimension Validation");
		test = report.createTest("Dimension Validation");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		dim_valid.Product_dim_descript(test, driver, Height, Width);
	}

	@Test(enabled = true)
	public void Checkout_test() throws InterruptedException, IOException, AWTException {
		System.out.println("Checkout Test Case");
		test = report.createTest("Checkout Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		checkout.Checkout(test, driver);

	}

	@Test(enabled = false)
	public void Manual_upload() throws InterruptedException, IOException, AWTException {
		System.out.println("Manual_upload Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		test = report.createTest("Manual_upload Test Case");
		man_upload.Upload_file(test, driver);

	}

	@Test(dataProvider = "Billing_Data_empty", threadPoolSize = 13, enabled = false)
	public void Billing_valid(String Firstname, String Lastname, String Ordernotes, String Company, String City,
			String Address1, String Address2, String Postcode, String Mobile, String Email)
			throws InterruptedException, IOException, AWTException {
		System.out.println("Billing Validation Test Case");
		test = report.createTest("Billing Validation Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		bill_val.Bill_Add(test, driver, Firstname, Lastname, Ordernotes, Company, City, Address1, Address2, Postcode,
				Mobile, Email);

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