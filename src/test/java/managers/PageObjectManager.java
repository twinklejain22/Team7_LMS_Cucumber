package managers;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager {
	
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private PaginationPage paginationPage;
	private UserPage userPage;
	
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
	
	public DashboardPage getDashboardPage()
	{
		return (dashboardPage == null) ? dashboardPage = new DashboardPage(driver) : dashboardPage;
	}
	
	public PaginationPage getPaginationPage()
	{
		return (paginationPage == null) ? paginationPage = new PaginationPage(driver) : paginationPage;
	}
	
	public UserPage getUserPage()
	{
		return (userPage == null) ? userPage = new UserPage(driver) : userPage;
	}

}
