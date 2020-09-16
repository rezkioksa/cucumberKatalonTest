import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


    @RunWith(Cucumber.class)
    @CucumberOptions(features="Include/features", glue="", plugin = ["pretty",
                        "junit:reports/cucumber.xml",
                        "html:reports",
                        "json:reports/cucumber.json"])
    public class CucumberEARunner {
    }