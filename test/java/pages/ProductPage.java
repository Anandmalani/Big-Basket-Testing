package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;
	public ProductPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//
	

	@FindBy(xpath="/html/body/div[1]/div[3]/product-deck/section/div[2]/div[4]/div[1]/div/div/div[2]/div/div[1]/product-template/div/div[3]")
	WebElement clickOnProduct;
//	/html/body/div[1]/div[3]/product-deck/section/div[2]/div[4]/div[1]/div/div/div[2]/div/div[1]/product-template/div/div[5]
	
	
	@FindBy(xpath="/html/body/div[1]/div[3]/product-deck/section/div[2]/div[3]/div/div[5]/div/div[4]")
	WebElement sortOption1;
	
	
	public void clickOnProductButton() throws InterruptedException {
		Thread.sleep(5000);
		clickOnProduct.click();
	}

	
	public void clickOnSortOption1() {
		sortOption1.click();
	}

}
