package stepdefinitions;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import context.TestContext;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.Screenshots;
import io.cucumber.java.After;

public class Hooks {
	
	TestContext testContext;
	static WebDriver driver;

	public Hooks(TestContext context) 
	{
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
	}
	
	@After
	public void AfterStep(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			Screenshots.CaptureScreenshot(driver);
			Allure.attachment("Myscreenshot", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
		}
	}

}
