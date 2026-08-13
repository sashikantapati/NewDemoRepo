package elementRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LastPage {
	public LastPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
@FindBy(className="complete-header")
private WebElement lastText;
	public WebElement getLastText() {
		return lastText;
	}
	@FindBy(id="back-to-products")
	private WebElement backButton;
	public WebElement getBackButton() {
		return backButton;
}
}
