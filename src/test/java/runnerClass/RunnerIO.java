package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features =".\\src\\test\\java\\featureFiles\\LoginToApp.feature",
		glue ="stepDefinitions",
		dryRun=true
		
		
		
		
		)
public class RunnerIO extends AbstractTestNGCucumberTests {

}
