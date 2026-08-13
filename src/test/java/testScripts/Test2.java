package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import elementRepo.HomePage;
import genericLab.BaseClass;

public class Test2 extends BaseClass {
	@Test
	public void Functional() {
		WebElement we = driver.findElement(By.className("product_sort_container"));
		Select s = new Select(we);
		s.selectByValue("lohi");
		System.out.println(driver.findElement(By.className("title")).getText());
		HomePage hp = new HomePage(driver);
		hp.getMenuOpt().click();
		hp.getlogoutLink().click();
	}
}
