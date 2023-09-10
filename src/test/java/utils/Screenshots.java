package utils;

import org.openqa.selenium.WebDriver;

import managers.FileReaderManager;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshots {

	public static void CaptureScreenshot(WebDriver driver)
	{
		try
		{
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(FileReaderManager.getInstance().getConfigReader().getScreenshotPath() + new Date() + ".jpeg"));
	
		}
		catch(IOException ex)
		{
			
		}
	}
}