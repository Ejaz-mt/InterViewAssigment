package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utlities.ConfigurationReader;
import utlities.Driver;

public class Hooks {
    @Before()
    public void setUpScenario() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        System.out.println("BEFORE - setUp method is running before the scenario ");
    }


    @After
    public void tearDownScenario(Scenario scenario) {
        //This will take a screenshot whenever a scenario fails
        if(scenario.isFailed()) {
            byte[] image = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image, "image/png", scenario.getName());
        }

        System.out.println("TearDown:" + scenario.getName());
        Driver.closeDriver();
    }

}
