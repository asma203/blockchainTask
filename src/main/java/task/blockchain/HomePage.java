package task.blockchain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="comp-iy4cwgmq1label")
	WebElement shopbtn;
	
	@FindBy(partialLinkText = "C$25.00")
	public WebElement product4;
	
	public void clickOnShope() {
		clickButton(shopbtn);
		
	}
	public void openProduct() {
		clickButton(product4);
		
		
	}

}
