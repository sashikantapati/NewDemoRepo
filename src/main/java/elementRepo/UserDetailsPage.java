package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDetailsPage {
	public UserDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
@FindBy(id="first-name")
private WebElement firstName;
	public WebElement getFirstName() {
		return firstName;
	}
	@FindBy(id="last-name")
	private WebElement lasrName;
	public WebElement getLastName() {
		return lasrName;
	}
	@FindBy(id="postal-code")
	private WebElement pin;
	public WebElement getPin() {
		return pin;
	}
	@FindBy(id="continue")
	private WebElement continueButton;
	public WebElement getcontinueButton() {
		return continueButton;
	}
}
