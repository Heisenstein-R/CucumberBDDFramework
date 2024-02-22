package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		stepNotifications = true,
		features = "C:\\Users\\91938\\eclipse-workspace\\CucumberBDDFramework\\src\\main\\java\\Features\\tags.feature",
		glue = {"StepDefinition"},
		plugin = {"pretty", "html:Reports\\report1.html"},
//		tags = "@Regression and @SmokeTest" , 
//		tags = "not @Regression" ,
		tags = "not @E2E" ,
		dryRun = true
//		monochrome = true
		)

public class TestRunner {

}
