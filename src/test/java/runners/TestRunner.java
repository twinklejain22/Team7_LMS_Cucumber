package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)

@CucumberOptions(
		plugin = {"pretty", "html:target/index.html",
				//"junit:target/Destination.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, //reporting purpose
		monochrome=false,  //console output color
		//tags = "@LandingPage or @Register or @Signin or @Home or @DataStructures or @Array or @LinkedList or @Stack or @Tree" , //tags from feature file
		//tags = "@LandingPage",
		features = {"src/test/java/features"}, //location of feature files
		glue= "stepdefinitions") //location of step definition files

//public class TestRunner { }

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }


}