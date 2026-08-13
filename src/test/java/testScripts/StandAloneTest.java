package testScripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {
	public static void main(String[] args) throws IOException {
		String expectedLogo = "Swag Labs";
		String productName = "Sauce Labs Bolt T-Shirt";
		String expectedResult = "Thank you for your order!";
		Map<String, Object> abc=new HashedMap<String, Object>();
		abc.put("profile.password_manager_leak_detection", false);
		ChromeOptions opt=new ChromeOptions();
		opt.setExperimentalOption("prefs", abc);
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		// Home Page
		String actualLogo = driver.findElement(By.className("app_logo")).getText();
		if (expectedLogo.equals(actualLogo)) {
			System.out.println("Sucessfully logedin to the home page");
		}
		// List of Products
		List<WebElement> allProducts = driver
				.findElements(By.xpath("//div[@class='inventory_list']/div/div[2]//a/div"));
		for (WebElement product : allProducts) {
			String allProductName = product.getText();
			if (productName.equals(allProductName)) {
				product.click();
				break;
			}
		}
		driver.findElement(By.id("add-to-cart")).click();
		driver.findElement(By.className("shopping_cart_link")).click();
		// cart Page
		List<WebElement> addedProducts = driver.findElements(By.className("inventory_item_name"));
		for (WebElement cartProduct : addedProducts) {
			String cartProductNsme = cartProduct.getText();
			if (productName.equals(cartProductNsme)) {
				System.out.println("Added Product Verified");
				break;
			}
		}
		driver.findElement(By.id("checkout")).click();
		// Details Filling
		driver.findElement(By.id("first-name")).sendKeys("abc");
		driver.findElement(By.id("last-name")).sendKeys("efg");
		driver.findElement(By.id("postal-code")).sendKeys("153");
		driver.findElement(By.id("continue")).click();
		// Finish Page
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File("./Screenshot/FinishPage.png");
		FileUtils.copyFile(src, trg);
		driver.findElement(By.id("finish")).click();
		// last Page
		String actualResult = driver.findElement(By.className("complete-header")).getText();
		if (expectedResult.equals(actualResult)) {
			System.out.println("Shopping completed");
		}
		driver.findElement(By.id("back-to-products")).click();
		// Logout
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn")));
		driver.findElement(By.id("react-burger-menu-btn")).click();
		// System.out.println("Menu bar clicked");
		driver.findElement(By.id("logout_sidebar_link")).click();
		// System.out.println("Logout clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login_logo")));
		driver.close();
		System.out.println("Web Page Closed");
	}
}
