package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionHelper { 
	
	WebDriver driver;
	
	public ActionHelper(WebDriver driver)
	{
		this.driver = driver;
	}

	public void Click(WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
		
	}

	public Boolean IsAlignedInCenterHorizontally(WebElement element) 
	{
		int windowsCenter = driver.manage().window().getSize().getWidth()/2;
		int usernameFieldCenter = element.getSize().getWidth()/2;
		
		if(windowsCenter ==  usernameFieldCenter)
			return true;
		else
			return false;
	}
	
	public Boolean IsHeaderValid(WebElement element, String expectedHeader)
	{
		if(element.getText() == expectedHeader)
			return true;
		else
			return false;
	}
	
	public Boolean IsPageOpen(String expectedPageTitle)
	{
		if(driver.getTitle() == expectedPageTitle)
			return true;
		else
			return false;
	}
	
	public Boolean VerifyFieldText(WebElement element, String expectedtxt)
	{
		if(element.getText() == expectedtxt)
			return true;
		else
			return false;
	}
	
	public Boolean VerifyFontColor(WebElement element, String expectedColorCode)
	{
		String elementFontColor = element.getCssValue("color");
		
		if(elementFontColor == expectedColorCode)
			return true;
		else
			return false;
	}

}
