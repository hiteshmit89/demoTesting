package Framework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Features",
        glue = {"StepDefinitions","Framework/Setup"},
        monochrome = true,
        plugin = {"pretty","html:target/HtmlReports/testResult.html",
                "json:target/JSONReports/testResult.json",
                "junit:target/XMLReports/testResult.xml"},
       tags = "@Campaigns or @home or @login")

public class Runner {
}

