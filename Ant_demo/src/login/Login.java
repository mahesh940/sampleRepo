package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.login;

public class Login {

private static WebDriver driver=null;
	
	@Test(priority = 1)
	public void Log() throws Exception{
		WebDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		driver.get("https://anritsucloud-qa.azurewebsites.net");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		login l1 = PageFactory.initElements(driver, login.class);
		l1.UserName.sendKeys("vijay.nikam@spadeworx.com");
		l1.Password.sendKeys("Work@123");
		l1.btn_LogIn.click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement act = l1.actuallogin_name;
		String expected = "Hello vijay.nikam!";
		String actual = act.getText();
		System.out.println("---------------------------");
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
				
	}
	
	 @AfterTest
	    public void tearDown()
	    {
	        driver.quit();
	    }
	
}
