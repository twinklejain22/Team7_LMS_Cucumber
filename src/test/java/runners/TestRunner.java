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
		features = {"src/test/java/features/HomePage.feature",
				"src/test/java/features/LoginPage.feature",
				"src/test/java/features/ForgotCredentialsPage.feature",
				"src/test/java/features/ResetPassword.feature",
				"src/test/java/features/DashboardPage.feature",
				"src/test/java/features/Student.feature",
				"src/test/java/features/StudentNavigation.feature",
				"src/test/java/features/UserPage.feature",
				"src/test/java/features/AddNewUser.feature",
				"src/test/java/features/EditUser.feature",
				"src/test/java/features/DeleteUser.feature",
				"src/test/java/features/DeleteMultipleUsers.feature",
				"src/test/java/features/AttendanceDetailsPopUpWindowVerification.feature",
				"src/test/java/features/PaginationInManageAttendance.feature",
				"src/test/java/features/DeleteAttendanceValidation.feature",
				"src/test/java/features/DeleteMultipleAttendance.feature",
				"src/test/java/features/ResetPassword.feature"}, //location of feature files
		glue= "stepdefinitions") //location of step definition files

//public class TestRunner { }

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }


}