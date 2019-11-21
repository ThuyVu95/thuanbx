package topica;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-report/cucumber.json"},
        glue="stepdefinition",
        features = "src/test/resources/topica", monochrome =true
)
public class RunCucumberTest {
}
