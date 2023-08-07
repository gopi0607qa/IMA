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
import pageModule.Product_List_Abstract_nature;
import pageModule.Product_List_Flowers;
import pageModule.Product_List_Macro_nature;
import pageModule.Product_List_Mineral_pattern;
import pageModule.Product_List_Natures_pattern;
import pageModule.Product_List_Sky;
import pageModule.Product_List_Stone_pattern;
import pageModule.Product_List_Wood_texture;
import pageModule.Product_List_page;
import pageModule.Product_description_dimesion_validation_page;
import util.ReadExcel;

public class Execution extends Testbase {

	public Product_description_dimesion_validation_page dim_valid = new Product_description_dimesion_validation_page();
	public Login_page login = new Login_page();
	public Invalid_Login_page invalid_login = new Invalid_Login_page();
	public Checkout_page checkout = new Checkout_page();
	public Manual_Upload man_upload = new Manual_Upload();
	public Billing_Address_Validation bill_val = new Billing_Address_Validation();
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

	@DataProvider(name = "Mural_dimensions")
	public Object[][] readExcel2() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"Mural_dimensions");
	}

	@DataProvider(name = "Billing_Data")
	public Object[][] readExcel3() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"Billing_Data");
	}

	@DataProvider(name = "LoginValidData")
	public Object[][] readExcel() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"LoginValidData");
	}

	@DataProvider(name = "LoginInvalidData")
	public Object[][] readExcel1() throws InvalidFormatException, IOException {
		return ReadExcel.readExcel(System.getProperty("user.dir") + "/src/test/resources/excel/TestData.xlsx",
				"LoginInvalidData");

	}

	@Test(dataProvider = "LoginValidData", enabled = true)
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

	@Test(dataProvider = "Mural_dimensions", enabled = false)
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

	@Test(enabled = true)
	public void Manual_upload() throws InterruptedException, IOException, AWTException {
		System.out.println("Manual_upload Test Case");
		test = report.createTest("Manual_upload Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		man_upload.Upload_file(test, driver);

	}

	@Test(dataProvider = "Billing_Data", enabled = false)
	public void Billing_valid(String Firstname, String Lastname, String Ordernotes, String Company, String City,
			String Address1, String Address2, String Postcode, String Mobile, String Email)
			throws InterruptedException, IOException, AWTException {
		System.out.println("Billin Validation Test Case");
		test = report.createTest("Billin Validation Test Case");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		bill_val.Bill_Add(test, driver, Firstname, Lastname, Ordernotes, Company, City, Address1, Address2, Postcode,
				Mobile, Email);
	}

	@Test(enabled = false)
	public void ProductList() throws InterruptedException, IOException, AWTException {
		System.out.println("Total Products");
		test = report.createTest("Total Products");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list.Product_List(test, driver);

	}

	@Test(enabled = false)
	public void ProductList_abstractnature() throws InterruptedException, IOException, AWTException {
		System.out.println("ProductList_abstractnature");
		test = report.createTest("ProductList_abstractnature");
		product_list_Abstract_nature.Product_List(test, null);

	}

	@Test(enabled = false)
	public void ProductList_Flower() throws InterruptedException, IOException, AWTException {
		System.out.println("Flowers");
		test = report.createTest("Flowers");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Flowers.Product_List(test, driver);

	}

	@Test(enabled = false)
	public void ProductList_Macronature() throws InterruptedException, IOException, AWTException {
		System.out.println("Macro_nature");
		test = report.createTest("Macro_nature");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Macro_nature.Product_List(test, driver);

	}

	@Test(enabled = false)
	public void ProductList_Mineralpattern() throws InterruptedException, IOException, AWTException {
		System.out.println("Mineral_patter");
		test = report.createTest("Mineral_patter");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Mineral_patter.Product_List(test, driver);

	}

	@Test(enabled = false)
	public void ProductList_Naturespattern() throws InterruptedException, IOException, AWTException {
		System.out.println("Natures_pattern");
		test = report.createTest("Natures_pattern");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Natures_pattern.Product_List(test, driver);

	}

	@Test(enabled = false)
	public void ProductList_Sky() throws InterruptedException, IOException, AWTException {
		System.out.println("ProductList_Sky");
		test = report.createTest("ProductList_Sky");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Sky.Product_List(test, driver);

	}

	@Test(enabled = false)
	public void ProductList_Stonepattern() throws InterruptedException, IOException, AWTException {
		System.out.println("ProductList_Stonepattern");
		test = report.createTest("ProductList_Stonepattern");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Stone_pattern.Product_List(test, driver);

	}

	@Test(enabled = false)
	public void ProductList_WoodTexture() throws InterruptedException, IOException, AWTException {
		System.out.println("ProductList_WoodTexture");
		test = report.createTest("ProductList_WoodTexture");
		WebDriver driver = DriverFactory.getInstance().getDriver();
		product_list_Wood_texture.Product_List(test, driver);

	}

	@AfterMethod
	public void aftermethod() {

		DriverFactory.getInstance().Close();

		System.out.println("This is after method");

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
