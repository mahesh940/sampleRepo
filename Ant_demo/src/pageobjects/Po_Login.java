package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Po_Login {
	

	final WebDriver driver;
	 
	@FindBy(how = How.XPATH, using = ".//*[@id='UserName']")
 	public WebElement UserName;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='Password']")
	public WebElement Password;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Log In']")
	public WebElement btn_LogIn;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@href, '/Account/Manage')]")
	public WebElement actuallogin_name;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log Off')]")
	public WebElement logOff;
	
// This is a constructor, as every page need a base driver to find web elements
 
	public Po_Login(WebDriver driver)
 
	{
 
		this.driver = driver;
 
		}

}
