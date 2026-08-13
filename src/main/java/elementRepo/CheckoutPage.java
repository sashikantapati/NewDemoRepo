package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
@FindBy(id="finish")
private WebElement finishButton;
	public WebElement getFinishButton() {
		return finishButton;
	}
}
