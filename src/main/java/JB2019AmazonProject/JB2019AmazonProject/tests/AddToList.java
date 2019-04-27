package JB2019AmazonProject.JB2019AmazonProject.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import JB2019AmazonProject.JB2019AmazonProject.infra.config.MainConfig;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.AddedToListPage;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.AmazonLandingPage;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.AmazonProductPage;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.AmazonSearchResultsPage;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.loginToAmazonPage;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class AddToList extends AbstractTest{

	protected ReportDispatcher report = ReportManager.getInstance();

	@Test
	public void _012_AddToListItem() throws Exception {

		// Step 1 - Browse to amazon.com landing page
		report.startLevel("Step 1 - Browse to amazon.com landing page");
		browseToUrl(MainConfig.baseUrl);
		AmazonLandingPage amazonLandingPage = new AmazonLandingPage(driver);
		report.endLevel();

		// Step 2 - Write a random search term in the top search bar and click the search button.	
		//Transferred to search results page
		report.startLevel("Step 2 - Write a random search term in the top search bar and click the search button.");
		String randomSearchTerm = generateRandomSearchTerm();
		amazonLandingPage.writeToSearchbox(randomSearchTerm);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AmazonSearchResultsPage amazonSearchResultsPage = amazonLandingPage.clickOnGoButton();
		report.endLevel();

		// Step 3 - Click the title of the first item in the search results list.
		// Transferred to the product details page
		report.startLevel("Step 3 - Click the title of the first item in the search results list.");
		AmazonProductPage amazonProductPage = amazonSearchResultsPage.clickOnSearchResultTitleByIndex(2);
		report.endLevel();

		// Step 4 - Click 'Add to List' button. //Transferred to Sign-In page and then to '<num> item added to Add to List page'.
		report.startLevel("Step 4 - Click 'Add to List' button. //Transferred to Sign-In page and then to '<num> item added to Add to List page'.");
		//AddedToListPage AddedToListPage = new AddedToListPage(driver);
		AddedToListPage.ClickAddToListItemButton();
		report.startLevel("Step 4.1 - Transferred to Sign-In page and then to '<num> item added to Add to List page'.");
		AddedToListPage.ClickAddToListButtonTransferedToSignInPage();
		loginToAmazonPage.SignInSubmit();
		report.endLevel();

		// Step 5 - Click on 'View your List' button.	//Transferred to Your List page.
		report.startLevel("Step 5 - Click on “View your List” button.	//Transferred to Your List page.");
		report.startLevel("Step 5.1 - Clicked on 'View Your List Button' in Shopping List Page");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		AddedToListPage.ClickOnViewYourListButton();
		report.endLevel();
		
		// Step 6 - After Added 'Item to Your List' and Click on 'View Your List' button.
		report.startLevel("Step 6 - After Added 'Item to Your List' and Click on 'View Your List' button.");
		WebElement warningMessageTitle2 = driver.findElement(By.xpath("//div[@id='list-header']/div[@id='wl-list-info']//span[@id='profile-list-name']"));
		String warningMessageTitleText2 = warningMessageTitle2.getText();
		report.startLevel("Step 6.1 - Verified Added 'Item to Your List' and Click on 'View Your List' You should be on '" + warningMessageTitleText2 + "', Page.");
		Assert.assertEquals(warningMessageTitleText2, "Shopping List", "Step 6.2 - Verified Added 'Item to Your List' and Click on 'View Your List' You should be on 'Shopping List' Page."); 
		report.endLevel();

	}
	private String generateRandomSearchTerm() {
		return "iPhone";
	}
}