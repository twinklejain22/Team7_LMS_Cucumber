package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utils.ActionHelper;
import utils.Log;

public class PaginationPage {

	WebDriver driver;
	ActionHelper actionHelper;
	
	@FindBy(xpath = "//div[contains(@class, 'pagination')]") WebElement pagination;
	@FindBy(xpath = "//button[contains(@class, 'prev')]") WebElement btnPrev;
	@FindBy(xpath = "//button[contains(@class, 'next')]") WebElement btnNext;
	@FindBy(xpath = "//button[contains(@class, 'first')]") WebElement btnFirst;
	@FindBy(xpath = "//button[contains(@class, 'last')]") WebElement btnLast;
	@FindBy(xpath = "//a[text()='2']") WebElement btnSecondPage;
	
	public PaginationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actionHelper = new ActionHelper(driver);
	}
	
	public void VerifyPaginationControlsPresent()
	{
		Assert.assertTrue(pagination.isDisplayed());
		Assert.assertTrue(btnPrev.isDisplayed());
		Assert.assertTrue(btnNext.isDisplayed());
		Assert.assertTrue(btnFirst.isDisplayed());
		Assert.assertTrue(btnLast.isDisplayed());
		Assert.assertTrue(btnSecondPage.isDisplayed());
		
		Log.info("Verified that pagination exists on page");
	}
	
	
}
