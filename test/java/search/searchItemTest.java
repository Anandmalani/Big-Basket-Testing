package search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;

 

public class searchItemTest {
//	String fpath = "C:\\Users\\himan\\eclipse-workspace\\BigBasket_testing\\src\\test\\resources\\object\\objects.property";
//	Properties p;
	String fpath = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\object\\objects.property";
	Properties p;
	File f;
	FileInputStream fis;
	
	WebDriver driver;
	SearchItemPage searchPage;
	@BeforeTest
	public void beforetest() throws IOException {
		 f = new File(fpath);
	   	 fis = new FileInputStream(f);
	   	 p = new Properties();
	   	 p.load(fis);
	   	  
	    System.setProperty(p.getProperty("browser"), p.getProperty("chromeDriver"));

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(p.getProperty("website"));
		 
		searchPage= new SearchItemPage(driver);
		

	}
	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
	@Test(priority=1,dataProvider="testdata2") 
	public void validateSearchPage(String Product) {
		searchPage.searchProduct(Product);
		searchPage.clickOnSearchButton();
		String a = searchPage.resultText.getText();
		Assert.assertEquals(a, Product);
	}
	
	@Test(priority=2,dataProvider="testdata1") 
	public void validateSearchPage1(String Prod) {
		searchPage.searchProduct(Prod);
		searchPage.clickOnSearchButton();
		String a = searchPage.noResultText.getText();
		Assert.assertEquals(a, p.getProperty("noResultText"));
	}
	
//	@Test(priority=3)
//	public void validateSearchPage2() throws InterruptedException {
//		searchPage.clickOnLoginButton();
//		searchPage.enterMobile(p.getProperty("id"));
//		searchPage.clickCont();
//		Thread.sleep(30000);
//	}
//	
//	@Test(priority=4,dataProvider="testdata2") 
//	public void validateSearchPage3(String Product) {
//		searchPage.searchProduct(Product);
//		searchPage.clickOnSearchButton();
//	}
//	
//	@Test(priority=5,dataProvider="testdata1") 
//	public void validateSearchPage4(String Prod) {
//		searchPage.searchProduct(Prod);
//		searchPage.clickOnSearchButton();
//	}
	
	@DataProvider(name="testdata2")
	public Object[][] csvread2() throws IOException {
		CSVReader readcsv = null;
		String[][] mydata = new String[3][1];
		try {
			readcsv = new CSVReader(new FileReader("D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\csv\\Product.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String[] nextLine;
			int x=0;
			while ((nextLine = readcsv.readNext())!= null) {
			    mydata[x]=nextLine;
			    x++;
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mydata;
	}
	@DataProvider(name="testdata1")
	public Object[][] csvread1() throws IOException {
		CSVReader readcsv = null;
		String[][] mydata = new String[3][1];
		try {
			readcsv = new CSVReader(new FileReader("D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\csv\\InvalidProduct.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String[] nextLine;
			int x=0;
			while ((nextLine = readcsv.readNext())!= null) {
			    mydata[x]=nextLine;
			    x++;
			}	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mydata;
	}
	
}
