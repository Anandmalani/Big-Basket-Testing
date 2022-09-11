package addToCart;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AddItemsTest {
	String fpath = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\object\\objects.property";
	Properties p;
//	String fpath = "C:\\Users\\himan\\eclipse-workspace\\BigBasket_testing\\src\\test\\resources\\object\\objects.property";
//	Properties p;
	File f;
	FileInputStream fis;
	
	WebDriver driver;
	AddItemsPage addItemsPage;
	String quantity = "3";
	
	@BeforeTest
	public void beforeTest() throws IOException {
		f = new File(fpath);
		fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
		  
		System.setProperty(p.getProperty("browser"), p.getProperty("chromeDriver"));
		driver = new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void beforeMethod() {	
		driver.get(p.getProperty("potatoUrl"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		addItemsPage = new AddItemsPage(driver);	
	}
	
	@Test(priority = 1, enabled = true)
	public void addFeatureWhenZeroQuantityEntered() {
		
		addItemsPage.enterNumberOfItems("0");
		addItemsPage.clickOnAddButton();
		
		String displyedMessage = "a";
		Assert.assertEquals(displyedMessage, "");
		
	}
	
	@Test(priority = 2, enabled = true)
	public void addFeatureWhenMoreThanSixItemsAdded() {
		
		addItemsPage.enterNumberOfItems("8");
		addItemsPage.clickOnAddButton();
		
		String displyedMessage = "";
		Assert.assertEquals(displyedMessage, "");
		
	}
	
	@Test(priority = 3)
	public void validateAddItemsToCartFeature() {
		
		addItemsPage.enterNumberOfItems(quantity);
		addItemsPage.clickOnAddButton();
		//addItemsPage.addOneMoreItem();
		
		String displyedMessage = "";
		Assert.assertEquals(displyedMessage, "");
		
	}
	
	@Test(priority = 4, enabled = true)
	public void addOneMoreItemToCart() {
		
		addItemsPage.addOneMoreItem();
		
		String displyedMessage = "";
		Assert.assertEquals(displyedMessage, "");
		
	}
	
	@Test(priority = 5, enabled = true)
	public void removeOneItemFromCart() {
		
		addItemsPage.removeOneItem();;
		
		String displyedMessage = "";
		Assert.assertEquals(displyedMessage, "");
		
	}
	
	@AfterTest
	public void afterTest() {
		
		driver.close();
		
	}

}
