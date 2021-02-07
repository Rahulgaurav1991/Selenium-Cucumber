package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"Features"},
        glue={"stepDefinitions","Hooks"},
        plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","rerun:target/failed_run.txt"},
        dryRun = false,
        publish = true,
        tags = "@Demo",

        monochrome = false)
public class TestRunner {


}
