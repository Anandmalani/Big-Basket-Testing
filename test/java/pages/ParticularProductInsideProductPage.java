package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParticularProductInsideProductPage {
	
	WebDriver driver;
	
	
	public ParticularProductInsideProductPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="qty")
	WebElement quantity;
	
//	@FindBy(xpath="//[@data-qa='addToBasket']")
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div[3]/div[2]/div[1]")
		
	public
//	public
	WebElement AddToBasketButton;
//	
//	@FindBy(xpath="//h1[@class=\"GrE04\"]")
//	WebElement heading;

	public void enterQuantityAsZero() {
		quantity.clear();
		
		quantity.sendKeys("0");
	}
	
//	public void clickOnAddToBasketButton() {
//		AddToBasketButton.click();
//	}

}

