package task.blockchain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.testng.ITestResult;

import helper.HelperClass;



public class TestBase {
	protected static WebDriver driver;
	private static Properties prop;

	// soft assertion method
	SoftAssert softassert = new SoftAssert();

	// Initiate the Chrome browser
	@SuppressWarnings("deprecation")
	@BeforeMethod

	public void openBrowser() throws InterruptedException, Exception {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("resouces\\test.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String chromeDriverPath = prop.getProperty("chromepath");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.navigate().to("https://arielkiell.wixsite.com/interview");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();

	}
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			HelperClass.captureScreenshot(driver, result.getName());
		}

}
}
