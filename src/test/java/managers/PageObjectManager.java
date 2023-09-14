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
	private ForgotPage forgotPage;
	private ResetPasswordPage resetPage;
	private StudentPage studentPage;
	private AttendancePage attendancePage;
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
	
	public ForgotPage getForgotPage()
	{
		return (forgotPage == null) ? forgotPage = new ForgotPage(driver) : forgotPage;
	}
	
	public ResetPasswordPage getResetPasswordPage()
	{
		return (resetPage == null) ? resetPage = new ResetPasswordPage(driver) : resetPage;
	}
	
	public StudentPage getStudentPage()
	{
		return(studentPage==null)? studentPage=new StudentPage(driver): studentPage;
	}
	
	public AttendancePage getAttendancePage()
	{
		return(attendancePage==null)? attendancePage=new AttendancePage(driver): attendancePage;
	}

	public ClassPage getClassPage()
	{
		return (classPage == null) ? classPage = new ClassPage(driver) : classPage;
	}

}
