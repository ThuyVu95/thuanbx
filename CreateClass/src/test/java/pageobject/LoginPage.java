package pageobject;

import common.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    By tbEmail = By.xpath("//input[@placeholder='Email']");
    By tbPassword = By.xpath("//input[@placeholder='Password']");
    By btnLogin = By.cssSelector("input.btn-submit");

    public LoginPage()
    {
        super();
        this.Url = "https://lms10ntltester.topica.vn/login/index.php";
    }

    public LoginPage withEmail(String email)
    {
        this.findElement(tbEmail).sendKeys(email);
        return this;
    }

    public LoginPage withPassword(String password)
    {
        this.findElement(tbPassword).sendKeys(password);
        return this;
    }

    public void login()
    {
        this.findElement(btnLogin).click();
    }

}
