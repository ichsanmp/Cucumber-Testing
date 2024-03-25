package demoblaze.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"demoblaze.StepDefinition"},
        features = {"src/test/resources/webTesting"},
        tags = "@web_testing",
        plugin = {"pretty"},
        monochrome = true
)
public class webRunner {
}
