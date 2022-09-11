package checkOut;


import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import addToCart.AddItemsPage;


public class checkoutTest {
	
//	String fpath = "C:\\Users\\himan\\eclipse-workspace\\BigBasket_testing\\src\\test\\resources\\object\\objects.property";
//	Properties p;
	String fpath = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\object\\objects.property";
	Properties p;
	File f;
	FileInputStream fis;
	WebDriver driver;
	
	factoryClass fc;
	AddItemsPage fc2;

@Test(priority=0)
public void checkBasket() throws InterruptedException {
	fc.clickMyBasket();
	driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
	fc.clickBasketProceed();
	driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
	String displyedMessage = "";
	Assert.assertEquals(displyedMessage, "");
}

@Test(priority=1)
public void checkBasketLogin() throws InterruptedException {
	driver.navigate().to(p.getProperty("url"));
	fc.setMob(p.getProperty("id"));
	fc.clickCont();
	Thread.sleep(25000);
	System.out.println("Logged in");
	fc.clickMyBasket();
	driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	fc.clickBasketProceed();
	String displyedMessage = "";
	Assert.assertEquals(displyedMessage, "");
}

@Test(priority=2)
public void addProduct() throws InterruptedException {
	driver.get(p.getProperty("potatoUrl"));
	fc2.enterNumberOfItems("1");
	fc2.clickOnAddButton();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	String displyedMessage = "";
	Assert.assertEquals(displyedMessage, "");
}

@Test(priority=3)
public void decreaseQty() throws InterruptedException {
	driver.navigate().to(p.getProperty("basketUrl"));
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	fc.clickIncQty();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	fc.decQuantity();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	String displyedMessage = "";
	Assert.assertEquals(displyedMessage, "");
}

@Test(priority=4)
public void increaseQty() throws InterruptedException {
	driver.navigate().to(p.getProperty("basketUrl"));
	
	driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
	fc.clickIncQty();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	fc.decQuantity();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	String displyedMessage = "";
	Assert.assertEquals(displyedMessage, "");
}

@Test(priority=5)
public void testPromo() throws InterruptedException {
	driver.navigate().to(p.getProperty("basketUrl"));
	
	driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
	fc.clickPromo();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	fc.clickClosePromo();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println("Promos Viewed");

}

@Test(priority=6)
public void removeItem() throws InterruptedException {
	driver.navigate().to(p.getProperty("basketUrl"));
	
	driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS);
	fc.clickRemove();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println("Removed");	
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
	  fc2 = new AddItemsPage(driver);
	  
	  driver.navigate().to(p.getProperty("website"));
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}