package selectProductTests;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ParticularProductInsideProductPage;
import pages.ProductPage;

public class SelectProductSomeOtherTestCases {
	String fpath = "D:\\myeclipse\\TSl_1047\\BigBasket\\src\\test\\resources\\object\\objects.property";
	Properties p;
	File f;
	FileInputStream fis;
	
	WebDriver driver;
    LoginPage loginPage;
    HomePage hp;
    ProductPage pg;
    ParticularProductInsideProductPage ppi;
    
    @BeforeTest
    public void beforeTest() throws IOException {
        f = new File(fpath);
   	    fis = new FileInputStream(f);
   	    p = new Properties();
   	    p.load(fis);
   	  
    	System.setProperty(p.getProperty("browser"), p.getProperty("chromeDriver"));
        driver=new ChromeDriver();
        driver.get(p.getProperty("website"));
        loginPage=new LoginPage(driver);
        hp=new HomePage(driver);
        pg=new ProductPage(driver);
        ppi=new ParticularProductInsideProductPage(driver);
        
        
}
//    
    @AfterTest
    public void afterTest() {
    	driver.close();
    }
    @Test (priority=1)
    public void selectProductToCheckSortFeature() throws InterruptedException{
//    	driver.get("https://www.bigbasket.com/auth/login/");
    	
//    	Assert.assertEquals(driver.getTitle(),"Login - bigbasket");
    	
    	hp.clickOnSearchField("Apple");
    	hp.clickOnSearchButton();
    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
    	pg.clickOnSortOption1();
    	Thread.sleep(8000);
//    	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
    	
//    	
    	
    }
    @Test (priority=2)
    public void toVerifyZeroQuantityEnterInProductPage() throws InterruptedException {
    	driver.get(p.getProperty("website"));
    	hp.clickOnSearchField("Apple");
    	hp.clickOnSearchButton();
    	
    	pg.clickOnProductButton();
    	ppi.enterQuantityAsZero();
    	boolean a=ppi.AddToBasketButton.isEnabled();
    	Assert.assertEquals(a,false);
    }
    @Test(priority=3)
    public void toCheckScrollFeatureInProductPage() throws InterruptedException {
    	driver.get(p.getProperty("website"));
       	hp.clickOnSearchField("Apple");
    	hp.clickOnSearchButton();
    	
    	pg.clickOnProductButton();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("scrollBy(0, 1500)"); 
    	Thread.sleep(5000);
    }
}
