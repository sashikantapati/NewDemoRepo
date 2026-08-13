package genericLab;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import elementRepo.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver listenerdriver;

	@BeforeMethod
	public void login() throws IOException {
		DataUtility du = new DataUtility();
		BrowserServers bs=new BrowserServers();
		driver=bs.initializeDriver();
		listenerdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(du.getProperties().getProperty("URL"));
		// Login
		LoginPage lp = new LoginPage(driver);
		lp.getUserName().sendKeys(du.getProperties().getProperty("userName"));
		lp.getPassword().sendKeys(du.getProperties().getProperty("password"));
		lp.getLogin().click();
	}

	@AfterMethod
	public void logout() {
		
		driver.close();
	}
}