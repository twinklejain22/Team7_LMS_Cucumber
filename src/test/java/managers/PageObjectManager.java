package managers;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager {
	
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private ClassPage classPage;
	
	public PageObjectManager(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public HomePage getHomePage()
	{
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public LoginPage getLoginPage()
	{
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
	
	public ClassPage getClassPage()
	{
		return (classPage == null) ? classPage = new ClassPage(driver) : classPage;
	}
	

}
