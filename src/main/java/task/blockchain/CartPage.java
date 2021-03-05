package task.blockchain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="total-sum")
	public WebElement totaltxt;
	
	@FindBy(xpath="//div[@id='tpapopup-1614972078848_rtby_comp-j4ci4xqn']")
	WebElement checkoutbtn;
	
	public void checkoutPage() {
		clickButton(checkoutbtn);
	}



}
