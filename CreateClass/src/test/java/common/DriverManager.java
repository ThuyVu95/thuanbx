package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;

public class DriverManager
{
    public static WebDriver GetBrowser(String browser)
    {
        WebDriver driver;
        if(browser.equalsIgnoreCase ("firefox"))
        {
            System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "/src/test/resources/webdriver/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(new FirefoxProfile());
            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("dom.webnotifications.enabled", false);
            options.addPreference("dom.push.enabled", false);
            driver = new FirefoxDriver(options);

        }
        else
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/webdriver/chromedriver.exe");
            Map prefs = new HashMap();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        return driver;
    }
}
