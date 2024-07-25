package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
(	features = "C:\\Users\\SIVAGAMI\\eclipse-workspace\\Automation\\Features",glue="BDDCucumber",publish= true)
public class Runnerclass {

}
