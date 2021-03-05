package task.blockchain;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProductTest extends TestBase{
	HomePage homepageObject;
	ProductPage productpageObject;
	WebDriverWait wait;
	JavascriptExecutor js;
	String amount = "3";
	
	@Test(priority =1, alwaysRun = true)
	public void openProductPage() throws InterruptedException {
		homepageObject = new HomePage(driver);
		homepageObject.clickOnShope();
		Thread.sleep(5000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", homepageObject.product4);
		homepageObject.openProduct();
		//wait.until(ExpectedConditions.urlContains("i-m-a-product"));
		String expectedUrl ="https://arielkiell.wixsite.com/interview/product-page/i-m-a-product";
		String actualUrl = driver.getCurrentUrl();
		softassert.assertEquals(actualUrl, expectedUrl);
	
	}
	
	@Test(priority = 2, dependsOnMethods = "openProductPage")
	public void addToCart() throws InterruptedException {
		productpageObject = new ProductPage(driver);
		Thread.sleep(2000);
		productpageObject.addToCart(amount);
		js.executeScript("arguments[0].scrollIntoView();", productpageObject.addtocartbtn);
		productpageObject.viewCart();
		
		
	}
	

}
