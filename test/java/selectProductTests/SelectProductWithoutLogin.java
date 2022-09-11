package selectProductTests;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
//import pages.LoginPage;
import pages.ProductPage;

public class SelectProductWithoutLogin {
	String fpath = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\object\\objects.property";
	Properties p;
	File f;
	FileInputStream fis;
	
	WebDriver driver;
//    LoginPage loginPage;
    HomePage hp;
    ProductPage pg;
    
    @BeforeTest
    public void beforeTest() throws IOException {
        f = new File(fpath);
   	    fis = new FileInputStream(f);
   	    p = new Properties();
   	    p.load(fis);
   	  
    	System.setProperty(p.getProperty("browser"), p.getProperty("chromeDriver"));
        driver=new ChromeDriver();
        driver.get(p.getProperty("website"));
//        loginPage=new LoginPage(driver);
        hp=new HomePage(driver);
        pg=new ProductPage(driver);
        
        
}
    @AfterTest
    public void afterTest() {
    	driver.close();
    }
    @Test
    public void selectProductWithoutLoginWithExistingProductName() throws InterruptedException{
    	
//    	Assert.assertEquals(driver.getTitle(),"Login - bigbasket");
    	
    	hp.clickOnSearchField("Apple");
    	hp.clickOnSearchButton();
    	
    	pg.clickOnProductButton();
    	
    	
    }
    @Test
    public void selectProductWithoutLoginWithSpellingMistakeInProductName() throws InterruptedException{
    	
//    	Assert.assertEquals(driver.getTitle(),"Login - bigbasket");
    	driver.get(p.getProperty("website"));
    	hp.clickOnSearchField("Apdjd");
    	hp.clickOnSearchButton();
    	
    	pg.clickOnProductButton();
    	
    	
    }
    @Test
    public void selectProductWithoutLoginWithEmptyProductName() throws InterruptedException{
    	
//    	Assert.assertEquals(driver.getTitle(),"Login - bigbasket");
    	driver.get(p.getProperty("website"));
//    	hp.clickOnSearchField("Apdjd");
    	hp.clickOnSearchButton();
    	Assert.assertEquals(driver.getTitle(),"Page Not Found | bigbasket.com");
    	
//    	pg.clickOnProductButton();
    	
    	
    }
    @Test
    public void selectProductWithoutLoginWithInvalidProductName() throws InterruptedException{
    	
//    	Assert.assertEquals(driver.getTitle(),"Login - bigbasket");
    	driver.get(p.getProperty("website"));
    	hp.clickOnSearchField("@#");
    	hp.clickOnSearchButton();
    	Assert.assertEquals(driver.getTitle(),"Page Not Found | bigbasket.com");
    	
//    	pg.clickOnProductButton();
    	
    	
    }

}

