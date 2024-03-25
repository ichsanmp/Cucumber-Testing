package dummyAPI_io.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"dummyAPI_io.stepDefinition"},
        features = {"src/test/resources/apiTesting"},
        tags = "@api_testing",
        plugin = {"pretty"},
        monochrome = true
)
public class apiRunner {
}
