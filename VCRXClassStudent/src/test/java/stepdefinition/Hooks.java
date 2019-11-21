package stepdefinition;

import common.DriverManager;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void testStart() {
        String platformName = System.getProperty("browser", "chrome");
        if(!platformName.equals(""))
        {
            this.driver = DriverManager.GetBrowser(platformName);
        }
        else
        {
            throw new IllegalArgumentException("The Platform name is missing from command");
        }

    }

    @After
    public void scenarioFinish(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}
