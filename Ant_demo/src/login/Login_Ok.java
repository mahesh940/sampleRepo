package login;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Po_Login;
import utility.Constant;


public class Login_Ok {

public WebDriver driver;

	@BeforeTest(description="Launches the URL ")
	public void geturl(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(Constant.URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
	public WebDriver login(WebDriver driver) throws Exception{
		Po_Login l1 = PageFactory.initElements(driver, Po_Login.class);	
		l1.UserName.sendKeys("vijay.nikam@spadeworx.com");
		Thread.sleep(2000);
		
		l1.Password.sendKeys("Work@123");
		Thread.sleep(2000);
		
		l1.btn_LogIn.click();
		Thread.sleep(2000);
		
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	@Test()
	public void test() throws Exception{
		login(driver);
		Po_Login l1 = PageFactory.initElements(driver, Po_Login.class);			
		WebElement act = l1.actuallogin_name;
		String expected = "Hello vijay.nikam!";
		String actual = act.getText();
		System.out.println("---------------------------");
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		}
	
	
	 @AfterTest()
	    public void tearDown()
	    {
	        driver.quit();
	    }
	
	
}
