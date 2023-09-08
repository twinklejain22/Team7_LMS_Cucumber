package managers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	BrowserType browserType;
	
	public DriverManager()
	{
		browserType = FileReaderManager.getInstance().getConfigReader().getBrowserType();
	}
	
	public WebDriver getDriver() 
	{
		 if (driver.get() == null) 
	     {
		        switch (browserType) {	 
		        
		        case FIREFOX : 
		        	WebDriverManager.firefoxdriver().setup();
	                driver.set(new FirefoxDriver());
	                break;
			    	
		        case CHROME : 
		        	WebDriverManager.chromedriver().setup();
		            driver.set(new ChromeDriver());
		    		break;
		    		
		        case EDGE : 
		        	WebDriverManager.edgedriver().setup();
	                driver.set(new EdgeDriver());
	                break;
		        }
	      }

		 //driver.get().manage().deleteAllCookies();
	     driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	     driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
	     driver.get().manage().window().maximize();
	     
	     return driver.get();
	}	
	
	public void quit() 
	{
        driver.get().quit();
        driver.remove();
    }
}