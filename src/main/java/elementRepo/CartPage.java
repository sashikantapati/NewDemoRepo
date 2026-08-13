package elementRepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="inventory_item_name")
	private List<WebElement> itemList;
		public List<WebElement> getitemList() {
			return itemList;
		}
		@FindBy(id="checkout")
		private WebElement checkout;
			public WebElement getcheckout() {
				return checkout;
			}
	
}
