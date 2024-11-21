package runners;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/results/shopplus/cucumber-report.json",  "html:target/results/shopplus/index.html"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@payment"

)

public class ShopPlusTestRunner extends BaseTestRunner {
}
