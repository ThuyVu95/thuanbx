package pageobject;

import common.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

	By tbUsername = By.xpath("//input[@placeholder='Nhập tên người dùng']");
	By tbPassword = By.xpath("//input[@placeholder='Nhập mật khẩu']");
	By btnLogin = By.xpath("//button[contains(text(),'Đăng nhập')]");

	public LoginPage() {
		super();
		this.Url = "https://xtooltester.topica.vn/login";
	}
	public void login(String name, String pass) {
		this.findElement(tbUsername).sendKeys(name);
		this.findElement(tbPassword).sendKeys(pass);
		this.findElement(btnLogin).click();
	}

}
