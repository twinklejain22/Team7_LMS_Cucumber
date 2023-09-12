package managers;

import org.openqa.selenium.WebDriver;

import pages.*;

public class PageObjectManager {
	
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private StudentPage studentPage;
	
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
	public StudentPage getStudentPage()
	{
		return(studentPage==null)? studentPage=new StudentPage(driver): studentPage;
	}
}
