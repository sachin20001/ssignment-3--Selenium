package handsonexercise;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.selenium.WebDriverManager;

public class AddInput {
	

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	@BeforeClass
	public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
		wait = new WebDriverWait(driver,120);
	}
	
	@Test
	public void confirmBoxTest() throws InterruptedException{
		
		WebElement ele1=driver.findElement(By.id("sum1"));
		WebElement ele2=driver.findElement(By.id("sum2"));
		WebElement ele3=driver.findElement(By.xpath("//button[@onclick=\"return total()\"]"));
		
		
		ele1.clear();
		ele1.sendKeys("1");
		ele2.clear();
		ele2.sendKeys("5");
		String value1=ele1.getAttribute("value");
		String value2=ele2.getAttribute("value");
		ele3.click();
		
		WebElement ele4=driver.findElement(By.id("displayvalue"));
		
		String expected=ele4.getText();
		
		
		
		try
		{
			int a=Integer.parseInt(value1);
			int b=Integer.parseInt(value2);
			int r=Integer.parseInt(expected);
			Assert.assertEquals(r, a+b);
		}
		catch(Exception e)
		{
			Assert.assertEquals(expected, "NaN");
			
		}
		
		
		
		
		
	
		
	
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}



}
