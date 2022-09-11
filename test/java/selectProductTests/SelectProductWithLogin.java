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
import pages.LoginPage;
import pages.ProductPage;

public class SelectProductWithLogin {
	String fpath = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\object\\objects.property";
	Properties p;
	File f;
	FileInputStream fis;
	
	WebDriver driver;
    LoginPage loginPage;
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
        driver.get(p.getProperty("url"));
        loginPage=new LoginPage(driver);
        hp=new HomePage(driver);
        pg=new ProductPage(driver);
        
        
}
    @AfterTest
    public void afterTest() {
    	driver.close();
    }
    @Test (priority=1)
    public void selectProductWithLoginWithExistingProductName() throws InterruptedException{
//    	driver.get("https://www.bigbasket.com/auth/login/");
    	loginPage.enterMobileNumber(p.getProperty("id"));

    	loginPage.clickOnContinueButton();
     	Thread.sleep(25000);
//    	Assert.assertEquals(driver.getTitle(),"Login - bigbasket");
    	
    	hp.clickOnSearchField("Apple");
    	hp.clickOnSearchButton();
    	
    	pg.clickOnProductButton();
    	
    	
    }
    @Test (priority=2)
    public void selectProductWithLoginWithSpellingMistakeInProductName() throws InterruptedException{
    	
//    	Assert.assertEquals(driver.getTitle(),"Login - bigbasket");
    	driver.get(p.getProperty("website"));
    	hp.clickOnSearchField("orang");
    	hp.clickOnSearchButton();
    	
    	pg.clickOnProductButton();
    	
    	
    }
    @Test (priority=3)
    public void selectProductWithLoginWithEmptyProductName() throws InterruptedException{
    	
//    	Assert.assertEquals(driver.getTitle(),"Login - bigbasket");
    	driver.get(p.getProperty("website"));
//    	hp.clickOnSearchField("Apdjd");
    	hp.clickOnSearchButton();
    	Assert.assertEquals(driver.getTitle(),"Page Not Found | bigbasket.com");
    	
//    	pg.clickOnProductButton();
    	
    	
    }
    @Test (priority=4)
    public void selectProductWithLoginWithInvalidProductName() throws InterruptedException{
    	
//    	Assert.assertEquals(driver.getTitle(),"Login - bigbasket");
    	driver.get(p.getProperty("website"));
    	hp.clickOnSearchField("@#");
    	hp.clickOnSearchButton();
    	Assert.assertEquals(driver.getTitle(),"Page Not Found | bigbasket.com");
    	
//    	pg.clickOnProductButton();
    	
    	
    }

}


