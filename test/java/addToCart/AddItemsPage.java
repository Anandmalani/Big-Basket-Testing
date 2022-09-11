package addToCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddItemsPage {
	
	@FindBy(xpath="//input[@name='qty']")
	WebElement quantityWebElement;
	
	@FindBy(xpath="//div[@class='Cs6YO rippleEffect']")
	WebElement addButtonWebElement;
	
	@FindBy(xpath="//div[@class='_1aJzw']")
	WebElement addOneMoreItemWebElement;
	
	@FindBy(xpath="//div[@class='_1h7JQ']")
	WebElement removeOneItemWebElement;
	
	WebDriver driver;
	
	public AddItemsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterNumberOfItems(String quantity) {
		
		quantityWebElement.clear();
		quantityWebElement.sendKeys(quantity);
		
	}
	
	public void clickOnAddButton() {
		
		addButtonWebElement.click();
		
	}
	
	public void addOneMoreItem() {
		
		try {
		    
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(addOneMoreItemWebElement));
			addOneMoreItemWebElement.click();
			addOneMoreItemWebElement.click();
			
		}
		catch(org.openqa.selenium.StaleElementReferenceException e) {
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(addOneMoreItemWebElement));
			addOneMoreItemWebElement.click();
			addOneMoreItemWebElement.click();
			
		}
		
	}
	
	public void removeOneItem() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(removeOneItemWebElement));
		removeOneItemWebElement.click();
		
	}
	
}
