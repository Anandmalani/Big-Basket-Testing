package loginTests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.apache.poi.ss.usermodel.DataFormatter;

//import factoryClass.factoryClass;

public class loginMobtest {
	
	String fpath = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\object\\objects.property";
	Properties p;
	File f;
	FileInputStream fis;
	WebDriver driver;
	factoryClass fc;
	
	File f2;
	FileInputStream fis2;
	HSSFWorkbook wb;
	HSSFSheet sh;
	HSSFRow rw;
	HSSFCell cl;
	String fpath2 = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\Excel\\login_signup_data (1).xls";
	int rCount, cCount;
	
	DataFormatter formatter;
	
	@BeforeMethod
	public void beforeMethod() {
		fc.clearMob();
	}
	@Test(dataProvider="dpMob", priority=0)
	public void Test1(String data) throws InterruptedException {
		fc.setMob(data);
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
		
		
		f2 = new File(fpath2);
		fis2 = new FileInputStream(f2);
		wb = new HSSFWorkbook(fis2);
		sh = wb.getSheet("loginData");
		rCount = sh.getPhysicalNumberOfRows();
		cCount = sh.getRow(0).getPhysicalNumberOfCells();
		
		formatter = new DataFormatter();
	}

	@AfterTest
	public void afterTest() {
		
		driver.close();
	}
	
	@DataProvider
	public String[] dpMob(){
		String[] a = new String[rCount];
		for(int i = 0; i < rCount; i++) {
			rw = sh.getRow(i);
			a[i] = formatter.formatCellValue(rw.getCell(0));
		}
		return a;
	}
	  
//	@DataProvider
//	public Object[][] dpMob() {
//		return new Object[][] {
//		      new Object[] { " " },
//		      new Object[] { "abcd"},
//		      new Object[] { "55555"},
//		      new Object[] { "9999999999"},
//		      new Object[] { "9890685961"},
//		};
//	}
//	
	
	
}
