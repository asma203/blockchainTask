package task.blockchain;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CheckoutTest extends TestBase {
	HomePage homepageObject;
	ProductPage productpageObject;
	CartPage cartpageObject;
	WebDriverWait wait;
	JavascriptExecutor js;
	String amount = "3";
	
	
	
	@Test(priority =1, alwaysRun = true)
	public void openProductPage() throws Exception {
		homepageObject = new HomePage(driver);
		homepageObject.clickOnShope();
		Thread.sleep(2000);
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
		//js.executeScript("arguments[0].scrollIntoView();", productpageObject.addtocartbtn);
		productpageObject.addToCartpage(amount);
		Thread.sleep(2000);
		productpageObject.viewCart();
		//wait.until(ExpectedConditions.visibilityOf(productpageObject.viewcartbtn));
		
		
	}
	
	@Test(priority = 3, dependsOnMethods = {"openProductPage", "openProductPage"})
	public void checkOut() {
		cartpageObject = new CartPage(driver);
		cartpageObject.checkoutPage();
		
		String actualamout = "C$75.00";
		String expected = driver.findElement(By.id("total-sum")).toString();
		softassert.assertEquals(actualamout, expected);
		
	}
	


}
