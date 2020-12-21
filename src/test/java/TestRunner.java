import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"Features"},
        glue={"stepDefinitions","Hooks"},
        plugin = {"pretty","json:target/MyReports/report.json"},
        dryRun = false,
        publish = true,
        //tags = "@Example or @Bills",

        monochrome = false)
public class TestRunner {
}
