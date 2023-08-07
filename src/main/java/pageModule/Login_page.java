package pageModule;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import base.BasicFunction;
import base.Testbase;
import webElement.Login_xpath;

public class Login_page extends Testbase {
	public static BasicFunction fun = new BasicFunction();

	public void Login(ExtentTest test, WebDriver driver, String UserName, String Password)
			throws InterruptedException, IOException, AWTException {
		Login_xpath login_xp = new Login_xpath(driver);

		fun.Click(driver, login_xp.My_Account);
		System.out.println("MyAccount Page is Clicked");
		fun.Sendkeys(driver, login_xp.Username_Field, UserName);
		System.out.println("Username Entered");
		fun.Scroll(driver, login_xp.password_Field);
		fun.Sendkeys(driver, login_xp.password_Field, Password);
		System.out.println("Password Entered");
		fun.Click(driver, login_xp.Login_Button);
		System.out.println("Login Button is Clicked");

		fun.explicit_Wait(driver, login_xp.Dashboard_user);

		if (login_xp.Dashboard_user.isDisplayed()) {
			System.out.println("Successful Login");
			test.log(Status.PASS, "User Homepage Opened", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
		}else {
			System.out.println("Login Fail");
			test.log(Status.FAIL, "User Homepage Opened", MediaEntityBuilder.createScreenCaptureFromPath(fun.capturescreenshot(driver)).build());
	}
}
	
}