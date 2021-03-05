package task.blockchain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[@id=\"TPAMultiSection_j4ci4xqb\"]/div[1]/div[1]/article[1]/div[1]/div[1]/article[1]/section[2]/div[7]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	WebElement entervalue;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[4]/div/main/div/div/div/div[2]/div/div/div/div/div/div/article/div[1]/div/article/section[2]/div[7]/div[1]/div/div[1]/section/div[2]/div/div/ul/li[2]/label/span")
	public WebElement selectcolor;
	
	
	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
	public WebElement addtocartbtn;
	
	@FindBy(id = "widget-view-cart-button")
	WebElement viewcartbtn;
	
	public void addToCart(String amount) throws InterruptedException {
		
		entervalue.clear();
		setTextElementText(entervalue, amount);
		clickButton(selectcolor);
		clickButton(addtocartbtn);
		Thread.sleep(5000);
		
	}
	
	public void viewCart() {
		clickButton(viewcartbtn);
		
	}

}
