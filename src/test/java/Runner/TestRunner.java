package Runner;

import Tests.TestBase;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (features = "src/test/java/features", glue = { "Steps" },
                plugin = { "pretty","html:target/cucumber-html-report" },
                tags = "@ValidateSubscriptionPackages"
        )

public class TestRunner extends TestBase {
}







