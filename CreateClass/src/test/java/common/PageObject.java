package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinition.Hooks;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PageObject {
    public String Title;
    public String Url;
    public String WindowHandler;

    public WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public PageObject() {
        this.driver = Hooks.driver;
    }

    public void Open()
    {
        if(!this.Url.trim().equalsIgnoreCase(""))
        {
            this.driver.get(this.Url);
            this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        else
        {
            throw new IllegalArgumentException("The Url of Page Object is missing");
        }
    }

    public boolean isShowed()
    {
        return this.driver.getTitle().equalsIgnoreCase(this.Title) || this.driver.getCurrentUrl().equalsIgnoreCase(this.Url);
    }

    public WebElement waitToElementAppear(By locator)
    {
        try
        {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(this.driver, 60);
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public WebElement findElement(By locator)
    {
        return this.waitToElementAppear(locator);
    }

    public void waitToElementDisappear(By locator)
    {
        WebDriverWait wait = new WebDriverWait(this.driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public <T extends PageObject> T switchToTop(T t)
    {
        this.WindowHandler = this.driver.getWindowHandle();
        Set<String> windows = this.driver.getWindowHandles();
        for(String handler: windows)
        {
            driver.switchTo().window(handler);
        }
        t.WindowHandler = this.driver.getWindowHandle();
        return t;
    }

    public void switchBack()
    {
        this.driver.switchTo().window(this.WindowHandler);
    }
}
