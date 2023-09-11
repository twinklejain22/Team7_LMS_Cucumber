package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	
	public void EnterText(WebElement element, String text)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
		jsExecutor.executeScript("arguments[0].value='" + text + "'", element);  
	}
	
	public Boolean ValidateTableHeaders(WebElement element, List<String> lstExpectedHeaders)
	{
		List<WebElement> headers = element.findElements(By.tagName("th"));
		List<String> headerText = new ArrayList<>();
		
		for (WebElement header : headers )
		{
			headerText.add(header.getText());
		}
		
		if(headerText.equals(lstExpectedHeaders))
			return true;
		else
			return false;
	}
	
	public void SortTableByColumn(WebElement element, String colName, String order) 
	{
		List<WebElement> headers = element.findElements(By.tagName("th"));
		for (WebElement col : headers )
		{
			if (!colName.equalsIgnoreCase(col.getText()))
			{
				element.click();
				String sortOrder = col.getAttribute("aria-sort");
				if (!order.equalsIgnoreCase(sortOrder)) {
					col.click();
				}
			}
		}
	}
	
	public Boolean VerifyURL(String urlText)
	{
		if(driver.getCurrentUrl().contains(urlText))
			return true;
		else
			return false;
	}
	
	public Boolean ValidateFooterText(WebElement element, String expectedPartialText)
	{
		if(element.getText().contains(expectedPartialText) || element.getText().equalsIgnoreCase(expectedPartialText))
				return true;
		else
			return false;
	}

	public Boolean IsEditButtonInTableRows(WebElement table)
	{
		List<WebElement> editButtons = table.findElements(By.xpath("//button[text()='Edit']"));
		List<WebElement> rows = table.findElements(By.tagName("//tr"));
		
		if(editButtons.size() == rows.size())
			return true;
		else
			return false;
	}
	
	public Boolean IsEditButtonEnabledInTableRows(WebElement table)
	{
		List<WebElement> editButtons = table.findElements(By.xpath("//button[text()='Edit']"));
		
		Boolean areEnabled = true;
		for(WebElement editButton : editButtons)
		{
			if(!editButton.isEnabled())
				areEnabled = false;
		}
		
		return areEnabled;
	}
	
	public Boolean IsDeleteButtonInTableRows(WebElement table)
	{
		List<WebElement> deleteButtons = table.findElements(By.xpath("//button[text()='Delete']"));
		List<WebElement> rows = table.findElements(By.tagName("//tr"));
		
		if(deleteButtons.size() == rows.size())
			return true;
		else
			return false;
	}
	
	public Boolean IsDeleteButtonEnabledInTableRows(WebElement table)
	{
		List<WebElement> deleteButtons = table.findElements(By.xpath("//button[text()='Edit']"));
		
		Boolean areEnabled = true;
		for(WebElement deleteButton : deleteButtons)
		{
			if(!deleteButton.isEnabled())
				areEnabled = false;
		}
		
		return areEnabled;
	}
	
	public Boolean IsCheckBoxInTableRows(WebElement table)
	{
		List<WebElement> checkboxes = table.findElements(By.xpath("//checkbox"));
		List<WebElement> rows = table.findElements(By.tagName("//tr"));
		
		if(checkboxes.size() == rows.size())
			return true;
		else
			return false;
	}
}
