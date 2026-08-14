package testScripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import elementRepo.CartPage;
import elementRepo.CheckoutPage;
import elementRepo.HomePage;
import elementRepo.LastPage;
import elementRepo.LogoutPage;
import elementRepo.UserDetailsPage;
import genericLab.BaseClass;
import genericLab.CommonUtility;
import genericLab.DataUtility;
import genericLab.Retry;

@Listeners(genericLab.ListenerImplementation.class)
public class End2End extends BaseClass {
	String expectedLogo = "Swag Labs";
	String productName = "Sauce Labs Bolt T-Shirt";
	String expectedResult = "Thank you for your order!";

	@Test(retryAnalyzer = Retry.class, dataProvider = "testData", dataProviderClass = DataUtility.class)
	public void purchaseOrder(String firstName, String lastName, String pin) throws IOException, InterruptedException {
		SoftAssert sa = new SoftAssert();
		// Home Page
		HomePage hp = new HomePage(driver);
		String actualLogo = hp.getLogo().getText();
		sa.assertEquals(expectedLogo, actualLogo);
		// List of Products
		List<WebElement> allProducts = hp.getitemList();
		for (WebElement product : allProducts) {
			String allProductName = product.getText();
			sa.assertEquals(productName, allProductName);
			product.click();
			break;
		}
		hp.getaddProduct().click();
		hp.getcartIcon().click();
		// cart Page
		CartPage cp = new CartPage(driver);
		List<WebElement> addedProducts = cp.getitemList();
		for (WebElement cartProduct : addedProducts) {
			String cartProductNsme = cartProduct.getText();
			sa.assertEquals(productName, cartProductNsme);
			break;
		}
		cp.getcheckout().click();
		// User Details page
		UserDetailsPage udp = new UserDetailsPage(driver);
		//Single time if we need to execute
//		DataUtility dl = new DataUtility();
//		udp.getFirstName().sendKeys(dl.getTestData()[0]);
//		udp.getLastName().sendKeys(dl.getTestData()[1]);
//		udp.getPin().sendKeys(dl.getTestData()[2]);
		
		//Multiple time execution
		udp.getFirstName().sendKeys(firstName);
		udp.getLastName().sendKeys(lastName);
		udp.getPin().sendKeys(pin);
		udp.getcontinueButton().click();
		// Checkout Page
		CommonUtility cu = new CommonUtility();
		cu.fullPageSS(driver);
		CheckoutPage cop = new CheckoutPage(driver);
		cop.getFinishButton().click();
		// last Page
		LastPage lp = new LastPage(driver);
		String actualResult = lp.getLastText().getText();
		sa.assertEquals(expectedResult, actualResult);
		lp.getBackButton().click();
		// Logout
		cu.visibilityOfElement(driver, hp.getMenuBar());
		hp.getMenuOpt().click();
		hp.getlogoutLink().click();
		LogoutPage lop = new LogoutPage(driver);
		cu.visibilityOfElement(driver, lop.getLogoutEle());

	}

}
