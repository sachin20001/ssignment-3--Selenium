package handsonexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import utilities.selenium.WebDriverManager;

public class DyanamicData {
	
	org.testng.asserts.SoftAssert sf;
	

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	@BeforeClass
	public void setUp(){
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver,120);
		driver.get("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
		
	}
	
	@BeforeMethod
	public void testPreReq()
	{
		sf=new org.testng.asserts.SoftAssert();
	}
	
	@Test
	public void Test() {
		driver.findElement(By.id("save")).click();
		By oLoading=By.id("loading");
		wait.until(ExpectedConditions.invisibilityOfElementWithText(oLoading, "loading..."));

		WebElement oPic=driver.findElement(By.xpath("//div[@id='loading']/img"));
		String imgSrc=oPic.getAttribute("src");
		sf.assertTrue(imgSrc.contains("jpg"),"FAIL | Image src"+imgSrc+" doesn't contain .jpg extension");
		sf.assertTrue(oPic.getSize().getHeight()>0,"FAIL | IMage height should be greater than 0 but is"+oPic.getSize().getHeight());
		sf.assertTrue(oPic.getSize().getWidth()>0,"FAIL | IMage width should be greater than 0 but is"+oPic.getSize().getWidth());

		System.out.println(oPic.getSize().getHeight());
		System.out.println(oPic.getSize().getWidth());

		String name=driver.findElement(oLoading).getText();
		String[] arrName=name.split("\n");
		arrName[0].replace("First Name: ","");
		arrName[2].replace("Last Name: ","");
		sf.assertTrue(arrName[0].length()>0,"FAIL | First name lenght should be greater than 0 but is"+arrName[0]);
		sf.assertTrue(arrName[2].length()>0,"FAIL | Last name lenght should be greater than 0 but is"+arrName[2]);
		sf.assertAll();		
	
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}



}
