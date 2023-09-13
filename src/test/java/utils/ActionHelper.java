package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
		int fieldCenter = element.getSize().getWidth()/2;
		
		if(windowsCenter ==  fieldCenter)
			return true;
		else
			return false;
	}
	
	public Boolean IsAlignedInLeftHorizontally(WebElement element) 
	{
		int windowsCenter = driver.manage().window().getSize().getWidth()/2;
		int fieldRightEnd = element.getLocation().y;
		
		if(windowsCenter >  fieldRightEnd)
			return true;
		else
			return false;
	}
	
	public Boolean IsAlignedInRightHorizontally(WebElement element) 
	{
		int windowsCenter = driver.manage().window().getSize().getWidth()/2;
		int fieldRightEnd = element.getLocation().x;
		
		if(windowsCenter <  fieldRightEnd)
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
		List<WebElement> checkboxes = table.findElements(By.xpath("//input[type='checkbox']\""));
		List<WebElement> rows = table.findElements(By.tagName("//tr"));
		
		if(checkboxes.size() == rows.size())
			return true;
		else
			return false;
	}
	
	public WebDriver SwitchToAddEditPopUp(WebDriver driver)
	{
		String popUpHandler = null;

		Set<String> handles = driver.getWindowHandles(); 
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			popUpHandler = iterator.next();
		}
		
		// switch to pop up window
		driver.switchTo().window(popUpHandler);
		
		return driver;
	}
	
	public Boolean ValidatePageNotFoundError()
	{
		if(driver.getTitle().contains("404"))
			return true;
		else
			return false;
	}
	
	public Boolean ValidateErrorCode()
	{
		if(driver.getTitle().contains("40"))
			return true;
		else
			return false;
	}
	
	public void SelectDropdownValue(WebElement element, String value)
	{
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}
	
	public Boolean VerifySearchText(WebElement table, String text)
	{
		Boolean exists = false;
		List<WebElement> cells = table.findElements(By.tagName("//td"));
		for(WebElement cell : cells)
		{
			if(cell.getText().equalsIgnoreCase(text))
			{
				exists=true;
				break;
			}
		}
		
		return exists;
	}
	
	public Boolean VerifyRowPresent(WebElement table, List<String> lstValues)
	{
		Boolean exists = false;
		List<WebElement> cells = table.findElements(By.tagName("//td"));
		for(WebElement cell : cells)
		{
			if(lstValues.contains(cell.getText()))
			{
				exists = true;
			}
			else
			{
				exists = false;
				break;
			}
		}
		return exists;
	}
	
	public void ClickEditInRow(WebElement table, String value)
	{
		WebElement reqRow = null;
		List<WebElement> rows = table.findElements(By.tagName("//tr"));
		for(WebElement row : rows)
		{
			List<WebElement> cells = row.findElements(By.tagName("//td"));
			for(WebElement cell : cells)
			{
				if(cell.getText().equalsIgnoreCase(value))
				{
					reqRow = row;
					break;
				}
			}
			if(reqRow != null)
			{
				break;
			}
		}
		
		WebElement editButton = reqRow.findElement(By.xpath("//button[text()='Edit'])"));
		Click(editButton);
	}
	
	public Boolean VerifyTableIsEmpty(WebElement table)
	{
		List<WebElement> rows = table.findElements(By.tagName("//tr"));
		if(rows == null || rows.size() == 0)
			return true;
		else
			return false;
	}
	
	public void ClickDeleteInRow(WebElement table, String value)
	{
		WebElement reqRow = null;
		List<WebElement> rows = table.findElements(By.tagName("//tr"));
		for(WebElement row : rows)
		{
			List<WebElement> cells = row.findElements(By.tagName("//td"));
			for(WebElement cell : cells)
			{
				if(cell.getText().equalsIgnoreCase(value))
				{
					reqRow = row;
					break;
				}
			}
			if(reqRow != null)
			{
				break;
			}
		}
		
		WebElement deleteButton = reqRow.findElement(By.xpath("//button[text()='Delete'])"));
		Click(deleteButton);
	}
	
	public Boolean VerifyNoCheckBoxesSelected(WebElement table)
	{
		Boolean notSelected = true;
		List<WebElement> checkboxes = table.findElements(By.xpath("//input[type='checkbox']"));
		for(WebElement checkbox : checkboxes)
		{
			if(checkbox.isSelected())
			{
				notSelected = false;
				break;
			}
		}
		
		return notSelected;
	}
	
	public void ClickCheckboxInTable(WebElement table, String text)
	{
			WebElement reqRow = null;
			List<WebElement> rows = table.findElements(By.tagName("//tr"));
			for(WebElement row : rows)
			{
				List<WebElement> cells = row.findElements(By.tagName("//td"));
				for(WebElement cell : cells)
				{
					if(cell.getText().equalsIgnoreCase(text))
					{
						reqRow = row;
						break;
					}
				}
				if(reqRow != null)
				{
					break;
				}
			}
			
			WebElement checkbox = reqRow.findElement(By.xpath("//input[type='checkbox']"));
			Click(checkbox);
		
	}
}
