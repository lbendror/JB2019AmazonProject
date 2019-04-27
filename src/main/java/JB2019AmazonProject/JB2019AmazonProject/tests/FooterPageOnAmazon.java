package JB2019AmazonProject.JB2019AmazonProject.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import JB2019AmazonProject.JB2019AmazonProject.infra.config.MainConfig;
import JB2019AmazonProject.JB2019AmazonProject.infra.pages.AmazonLandingPage;
import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;

public class FooterPageOnAmazon extends AbstractTest {
	
	protected ReportDispatcher report = ReportManager.getInstance();

	@Test
	public void _02_amazonMusicTest() throws Exception {
		// Step 1 - Browse to amazon.com landing page
		report.startLevel("Step 1 - Browse to amazon.com landing page.");
		browseToUrl(MainConfig.baseUrl);
		report.endLevel();
		
		// Step 2 - Roll page down Footer on Amazon	System navigate to More on Amazon.com
		report.startLevel("Step 2 - Roll page down Footer on Amazon	System navigate to More on Amazon.com.");
		report.endLevel();
		
		// Step 3 - Click on the Amazon Music link.	Transferred to the “Amazon Music” page
		report.startLevel("Step 3 - Click on the Amazon Music link.");
		AmazonLandingPage FooterPageOnAmazon = new AmazonLandingPage(driver);
		AmazonLandingPage.clickAmazonMusicLink();
		report.endLevel();
		
		// Step 4 - Click on the Amazon Business link.	Transferred to the “Amazon Business” page
		report.startLevel("Step 4 - Click on the Amazon Business link.");
		Thread.sleep(1000);
		browseToUrl(MainConfig.baseUrl);
		AmazonLandingPage.clickAmazonBusinessLink();
		report.endLevel();
		
		// Step 5 - Click on the Book Depository link.	Transferred to the “Book Depository” page.
		report.startLevel("Step 5 - Click on the Book Depository link.");
		Thread.sleep(1000);
		browseToUrl(MainConfig.baseUrl);
		AmazonLandingPage.amazonBookDepositoryLink();
		report.endLevel();
		
		// Step 6 - Click on the Goodreads link.	Transferred to the “Goodreads” page.
		report.startLevel("Step 6 - Click on the Goodreads link.");
		Thread.sleep(1000);
		browseToUrl(MainConfig.baseUrl);
		AmazonLandingPage.amazonGoodreadsLink();
		report.endLevel();
		
		// Step 7 - Click on the Woot! link.	Transferred to the “Woot!” page.
		report.startLevel("Step 7 - Click on the Woot! link.");
		Thread.sleep(1000);
		browseToUrl(MainConfig.baseUrl);
		AmazonLandingPage.amazonWootLink();
		report.endLevel();
		
		// Step 8 - Click on the Amazon Advertising link.	Transferred to the “Amazon Advertising” page.
		report.startLevel("Step 8 - Click on the Amazon Advertising link.");
		Thread.sleep(1000);
		browseToUrl(MainConfig.baseUrl);
		AmazonLandingPage.amazonAmazonAdvertisingLink();
		report.endLevel();
		
		// Step 9 - Click on the Amazon Global link.	Transferred to the “AmazonGlobal” page.
		report.startLevel("Step 8 - Click on the Amazon Advertising link.");
		Thread.sleep(1000);
		browseToUrl(MainConfig.baseUrl);
		AmazonLandingPage.amazonAmazonAdvertisingLink();
		report.endLevel();
	}
}