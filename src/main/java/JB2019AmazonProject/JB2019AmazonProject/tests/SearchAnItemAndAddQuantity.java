package JB2019AmazonProject.JB2019AmazonProject.tests;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import JB2019AmazonProject.JB2019AmazonProject.infra.pages.AddedToCartPage;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.AmazonLandingPage;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.AmazonProductPage;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.AmazonSearchResultsPage;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.SearchAnItemAndAddQuantityPage;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class SearchAnItemAndAddQuantity extends AbstractTest {

	protected ReportDispatcher report = ReportManager.getInstance();

	@Test
	public void _08_SearchAnItemAndAddQuantity() throws Exception {

		// Step 1 - Browse to amazon.com landing page.
		// driver.get("http://wwww.amazon.com");
		report.startLevel("Step 1 - Browse to amazon.com landing page.");
		browseToUrl("http://amazon.com");
		AmazonLandingPage amazonLandingPage = new AmazonLandingPage(driver);
		report.endLevel();

		// Step 2 - Write a random search term in the top search bar and click the
		// search button. Transferred to search results page
		report.startLevel("Step 2 -  Write a random search term in the top search bar and click the search button.");
		String randomSearchTerm = generateRandomSearchTerm();
		amazonLandingPage.writeToSearchbox(randomSearchTerm);
		AmazonSearchResultsPage amazonSearchResultsPage = amazonLandingPage.clickOnGoButton();
		report.endLevel();

		// Step 3 - Click the title of some item in the search results list. // Transferred to the product details page.
		report.startLevel("Step 3 - Click the title of some item in the search results list.");
		AmazonProductPage amazonProductPage = amazonSearchResultsPage.clickOnSearchResultTitleByIndex(1);
		report.endLevel();

		// Step 4 - Choose Qty '10' Dropdown, Verify appear Green color ‘In Stock’ And
		// The Qty field update to ‘10’.
		report.startLevel("Step 4 - Choose Qty '10' Dropdown, Verify appear Green color ‘In Stock’ And The Qty field update to ‘10’.");
		SearchAnItemAndAddQuantityPage.ChooseQty10Dropdown();
		report.endLevel();

		// Step 4.1 - Switches control to the new window.
		report.startLevel("Step 4.1 - Switches control to the new window.");
		Set<String> eachwin = driver.getWindowHandles();
		for (String win : eachwin) {
			driver.switchTo().window(win);
		}
		report.endLevel();

		// Step 4.2 - Selecting value from Quantity Dropdown.
		report.startLevel("Step 4.2 - Selecting value from Quantity Dropdown.");
		WebElement ele = SearchAnItemAndAddQuantityPage.SelectingValueFromQuantityDropdown();
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText("10");
		report.startLevel("Step 4.2.1 - Choose '10' value from Quantity Dropdown.");
		Thread.sleep(1000);
		report.endLevel();

		// Step 4.3 - Switches to the new value Quantity = 10 selected.
		report.startLevel("Step 4.3 - Switches to the new value Quantity = 10 selected.");
		Set<String> eachwin2 = driver.getWindowHandles();
		for (String win2 : eachwin2) {
			driver.switchTo().window(win2);
		}
		report.endLevel();

		// Step 5 - Click on ‘Add to Cart’ Button. The Item ‘Added to Cart’.
		report.startLevel("Step 5 - Click on ‘Add to Cart’ Button. The Item ‘Added to Cart’.");
		AddedToCartPage addedToCartPage = amazonProductPage.clickAddToCartButton();
		report.endLevel();

		// Step 6 - Verify The name of the Button is: ‘Proceed to checkout (10 items)’.
		// // The name of the Button is: ‘Proceed to checkout (10 items)’.
		report.startLevel("Step 6 - Verify The name of the Button is: ‘Proceed to checkout (10 items)’.");
		WebElement warningMessageTitle = SearchAnItemAndAddQuantityPage.VerifyTheNameOfTheButton_ProceedToCheckout();
		String warningMessageTitleText = warningMessageTitle.getText();
		report.startLevel("Step 6.1 - You just add 10 items Button shown text: '" + warningMessageTitleText + "'.");
		Assert.assertEquals(warningMessageTitleText, "Proceed to checkout (10 items)", 
				"Step 6.2 - You just add 10 items Button shown text: 'Proceed to checkout (10 items)'.");
		report.endLevel();

		// Step 7 - Click on ‘Cart’ button. The item in Shopping Cart with Quantity of 10.
		report.startLevel("Step 7 - Click on ‘Cart’ button.	The item in Shopping Cart with Quantity of 10.");
		SearchAnItemAndAddQuantityPage.ClickOnCartButton();
		report.endLevel();

		// Step 8 - Verify The Shopping Cart show 10 in Cart. The Shopping Cart show 10 in Cart.
		report.startLevel("Step 8 - Verify The Shopping Cart show 10 in Cart. The Shopping Cart show 10 in Cart.");
		Assert.assertEquals(addedToCartPage.getCartCounterValue(), 10,"Step 8.1 - Verified The Shopping Cart show 10 in Cart. The Shopping Cart show 10 in Cart.");
		report.startLevel("Step 8.2 - Verified The Shopping Cart Show " + addedToCartPage.getCartCounterValue() + " in Cart.");
		report.endLevel();
	}
	private String generateRandomSearchTerm() {
		return "Franklin Sports Grip-Rite Junior Football — Fun Youth-Size Football for Kids’ Football Games — Synthetic Leather Football for Kids";
	}
}