package checkOut;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class factoryClass {
	
	@FindBy(xpath="//input[@name='qty']")
	WebElement quantityWebElement;
	
	@FindBy(xpath="//div[@class=\"form-group\"]/input")
	WebElement mobIn;
		
	@FindBy(xpath="//button[contains(@class,'btn btn-default login-btn')]")
	WebElement continueBtn;
	
	@FindBy(xpath="//a[@qa=\"myBasket\"]")
	WebElement myBasket;
	
	@FindBy(xpath="//div[@class=\"empty-basket\"]/p/span")
	public
	WebElement emptyBasketMsg;
	
	@FindBy(xpath="//button[@qa=\"viewBasketMB\"]")
	WebElement basketProceed;
		
	@FindBy(xpath="//*[@id=\"cart-items\"]/section/div[2]/a")
	WebElement emptyBasket;
	
	@FindBy(xpath="//*[@id=\"alert_ok\"]")
	WebElement clickOk;
	
	@FindBy(xpath="//*[@id=\"empty_message\"]/div[2]/a")
	WebElement contShop;
	
	@FindBy(xpath="//*[@id=\"id_prow_10000072\"]/ul/li[4]/div/button[1]") 
	WebElement decQty;
	
	@FindBy(xpath="//a[@qa=\"prodRemove\"]")
	WebElement removeItem;
	
	@FindBy(xpath="//button[@qa=\"incBaskQty\"]") 
	WebElement incQty;
	
	@FindBy(xpath="//*[@id=\"mainEligiblePromo\"]/a/p") 
	WebElement viewPromo;
	
	@FindBy(xpath="//*[@id=\"popup_available_promos\"]/a") 
	WebElement closePromo;
	
	@FindBy(id="input")
	WebElement searchProduct;
	
	@FindBy(xpath="//div[@qa=\"product_name\"]/a")
	WebElement selectFirst;
	
	@FindBy(xpath="//div[@data-qa=\"addToBasket\"]")
	WebElement addToBasket;
	
	@FindBy(xpath="//span[@id=\"noItems\"]")
	WebElement prodCount;
	
	@FindBy(xpath="//button[@class=\"hvr-fade\"]")
	WebElement searchBtn;
	
	WebDriver driver;
	
	public factoryClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickaddToBasket() {
		addToBasket.click();
	}
	
	public void clickFirstP() {
		selectFirst.click();
	}
	
	public void setMob(String u) {
		mobIn.sendKeys(u);
	}
	
	public void setSearchProduct(String u) {
		searchProduct.sendKeys(u);
	}
	
	public void clickCont() {
		continueBtn.click();
	}
	
	public void clickMyBasket() {
		myBasket.click();
	}
	
	public void clickBasketProceed() {
		basketProceed.click();
	}
	public void clickEmptyBasket() {
		emptyBasket.click();
	}
	public void clickOkBtn() {
		clickOk.click();
	}
	public void clickContShop() {
		contShop.click();
	}
	public void decQuantity() {
		decQty.click();
	}
	public void clickRemove() {
		removeItem.click();
	}
	
	public void clickPromo() {
		viewPromo.click();
	}
	public void clickClosePromo() {
		closePromo.click();
	}
	public void clickIncQty() {
		incQty.click();
	}
}