package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
@FindBy(id="user-name")
private WebElement userName;
	public WebElement getUserName() {
		return userName;
	}
	@FindBy(id="password")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}
	@FindBy(id="login-button")
	private WebElement login;
	public WebElement getLogin() {
		return login;
	}
	
}
