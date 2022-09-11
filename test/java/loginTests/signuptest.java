package loginTests;

import org.testng.annotations.Test;

//import factoryClass.factoryClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class signuptest {
	
	String fpath = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\object\\objects.property";
	Properties p;
	File f;
	FileInputStream fis;
	WebDriver driver;
	factoryClass fc;
	
//	@BeforeMethod
//	public void beforeMethod() {
//		fc.fname.clear();
//		fc.lname.clear();
//		fc.formEmail.clear();
//	}
	
	@Test(dataProvider="dpMob", priority=0)
	public void Test1(String data1, String data2, String data3, String data4) throws InterruptedException {
		fc.setSignupMob(data1);
		fc.clickSignupMobBtn();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		fc.setFname(data2);
		fc.setLname(data3);
		fc.setFormEmail(data4);
		Boolean btn = fc.signupBtn.isEnabled();
		Boolean exp = true;
		Assert.assertEquals(btn, exp);
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
		  
		driver.navigate().to(p.getProperty("signup_url"));
	}

	@AfterTest
	public void afterTest() {
		
		driver.close();
	}
	  
	@DataProvider
	public Object[][] dpMob() {
		return new Object[][] {
		      new Object[] { "9890685961", " ", " ", " " },
		      new Object[] { "9890685961", "Hello", "Hello", "hello" },
		      new Object[] { "9890685961", "Hello", "Hello", "himanshuyyt20@gmail.com" },
		};
	}
}
