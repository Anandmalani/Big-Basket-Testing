package loginTests;

import org.testng.annotations.Test;

//import factoryClass.factoryClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class loginEmailtest {
	
	String fpath = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\object\\objects.property";
	Properties p;
	File f;
	FileInputStream fis;
	WebDriver driver;
	factoryClass fc;
	
	@BeforeMethod
	public void beforeMethod() {
		fc.clearEmail();
	}
	
	@Test(dataProvider="dpEmail", priority=1)
	public void Test1(String data) throws InterruptedException {
		fc.setEmail(data);
		Boolean btn = fc.continueBtn.isEnabled();
		Boolean exp = false;
		if(btn) {
			fc.clickCont();
			Thread.sleep(30000);
			Assert.assertEquals(driver.getTitle(), p.getProperty("dashboardTitle"));
		}else {
			Assert.assertEquals(btn, exp);
		}
	}
	
	@BeforeTest
	public void beforeTest() throws IOException {
		f = new File(fpath);
		fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
		  
		System.setProperty(p.getProperty("browser"), p.getProperty("chromeDriver"));
		driver = new ChromeDriver();
		
		fc = new factoryClass(driver);
		  
		driver.navigate().to(p.getProperty("url"));
		fc.clickEmail();
	}

	@AfterTest
	public void afterTest() {
		
		driver.close();
	}	

  @DataProvider
	public Object[][] dpEmail() {
		return new Object[][] {
		      new Object[] { " " },
		      new Object[] { "abcd"},
		      new Object[] { "malanianand2000@gmail.com"},
		};
  	}
  
}
