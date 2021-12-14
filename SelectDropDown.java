package handsonexercise;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.selenium.WebDriverManager;

public class SelectDropDown {
	

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	@BeforeClass
	public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		driver.get("https://demoqa.com/select-menu");
		wait = new WebDriverWait(driver,120);
	}
	
	@Test
	public void Test() {
		WebElement ele=driver.findElement(By.id("oldSelectMenu"));
		
		Select select=new Select(ele);
		
		select.selectByIndex(3);
		select.selectByVisibleText("Black");
		select.selectByValue("8");
		
		
		
	
		
	
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}



}
