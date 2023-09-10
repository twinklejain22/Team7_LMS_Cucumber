package context;

import managers.DriverManager;
import managers.PageObjectManager;
import utils.ActionHelper;

public class TestContext {
	
	private DriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContext()
	{
		webDriverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}
	
	public DriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
