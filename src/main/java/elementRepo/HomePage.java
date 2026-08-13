package elementRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
@FindBy(className="app_logo")
private WebElement logo;
	public WebElement getLogo() {
		return logo;
	}
	@FindBy(xpath="//div[@class='inventory_list']/div/div[2]//a/div")
	private List<WebElement> itemList;
		public List<WebElement> getitemList() {
			return itemList;
		}
		@FindBy(id="add-to-cart")
		private WebElement addProduct;
			public WebElement getaddProduct() {
				return addProduct;
			}
			@FindBy(className="shopping_cart_link")
			private WebElement cartIcon;
			public WebElement getcartIcon() {
				return cartIcon;
			}
			private By menuBar=By.id("react-burger-menu-btn");
			public By getMenuBar() {
				return menuBar;
			}
			@FindBy(id="react-burger-menu-btn")
			private WebElement menuOpt;
				public WebElement getMenuOpt() {
					return menuOpt;
				}
				@FindBy(id="logout_sidebar_link")
				private WebElement logoutLink;
				public WebElement getlogoutLink() {
					return logoutLink;
				}
}
