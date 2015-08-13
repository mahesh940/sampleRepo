package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class login{

	final WebDriver driver;
	 
	@FindBy(how = How.XPATH, using = ".//*[@id='UserName']")
 
	public WebElement UserName;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='Password']")
	 
	public WebElement Password;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='loginForm']/form/div[4]/div/input")
	 
	public WebElement btn_LogIn;
	
	@FindBy(how = How.XPATH, using = ".//*[@id='logoutForm']/ul/li[2]/a")
	 
	public WebElement actuallogin_name;
	
 
// This is a constructor, as every page need a base driver to find web elements
 
	public login(WebDriver driver)
 
	{
 
		this.driver = driver;
 
		}
 
}
