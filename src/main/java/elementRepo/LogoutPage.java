package elementRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
@FindBy(className="login_logo")
private WebElement logout;
	public WebElement getlogout() {
		return logout;
	}
	private By logoutEle=By.className("login_logo");
	public By getLogoutEle() {
		return logoutEle;
	}
}
