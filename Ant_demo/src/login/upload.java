package login;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class upload {
	
private static WebDriver driver=null;
	
	@BeforeTest(description="Launches the URL ")
	public void geturl() throws IOException{
				
		//System.setProperty("webdriver.chrome.driver","D:\\Ankur\\Selenium Webdriver\\WebdriverSetup\\drivers\\chromedriver_win32\\chromedriver.exe");
		//create chrome instance
		//driver = new ChromeDriver();
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		driver.get("https://anritsucloud-qa.azurewebsites.net");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
	@Test(priority = 2)
	public void upload() throws InterruptedException, IOException{
		
		driver.findElement(By.xpath(".//*[@id='UserName']")).sendKeys("vijay.nikam@spadeworx.com");
		driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("Work@123");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		new WebDriverWait(driver, 1000000).until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='jobs-table']/tbody/tr/td")));
//Click on Job
		driver.findElement(By.xpath("//table[@id='jobs-table']/tbody/tr[3]/td[2]")).click();
		new WebDriverWait(driver, 1000000).until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[104]")));
		//Click on result
		driver.findElement(By.xpath("(//button[@type='button'])[104]")).click();
		new WebDriverWait(driver, 1000000).until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
		//Thread.sleep(3000);
		//WebElement a = driver.findElement(By.xpath(".//*[@id='jobReviewHeader']/div/div[3]/div/div[2]/tracemultifiles-uploader/div[1]/input"));
		//a.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("c:\\Files\\window_firefox.exe");
		new WebDriverWait(driver, 1000000).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='jobReviewHeader']/div/div[3]/div/div[2]/tracemultifiles-uploader/div[2]/div/i")));
		System.out.println("Loader is visible");
		new WebDriverWait(driver, 1000000).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='jobReviewHeader']/div/div[3]/div/div[2]/tracemultifiles-uploader/div[2]/div/i")));
		System.out.println("Perform task after loader is invisible");
}
}
