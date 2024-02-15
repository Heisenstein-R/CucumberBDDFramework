package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		stepNotifications = true,
		features = "C:\\Users\\91938\\eclipse-workspace\\CucumberBDDFramework\\src\\main\\java\\Features\\login.feature",
		glue = {"StepDefinition"},
		plugin = {"pretty", "html:Reports\\report1.html"},
		dryRun = false
//		monochrome = true
		)

public class TestRunner {

}