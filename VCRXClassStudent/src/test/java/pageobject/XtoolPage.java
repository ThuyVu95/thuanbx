package pageobject;

import common.PageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XtoolPage extends PageObject {
	By titleCongCu = By.xpath("//span[contains(text(),'Công cụ')]");
	By txtMoLop = By.xpath("//span[contains(text(),'Mở lớp')]");
	By btnTaoLop = By.xpath("//button[contains(text(),'Tạo lớp')]");
	By choosedomain = By.xpath(
			"//div[@class='section-class select-domain']//select[@class='mdb-select md-form colorful-select dropdown-primary']");
	By linkdomain = By.xpath("//option[contains(text(),'https://vcrxnvndev6.topica.vn')]");
	By btnLoc = By.xpath("//button[@class='btn btn-info btn-filter']");
	By linkHV = By.linkText("HV - 30-WEB");

	public XtoolPage() {
		super();
		this.Url = "https://xtooltester.topica.vn/openclass";
	}

	public void MovetoClass() {
		this.findElement(titleCongCu).click();
		this.findElement(txtMoLop).click();
		this.findElement(btnTaoLop).click();
		this.findElement(choosedomain).click();
		this.findElement(linkdomain).click();
		this.findElement(btnLoc).click();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.findElement(linkHV).click();

//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("use-fake-ui-for-media-stream");
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver(options);
//		driver.get("https://webcamera.io/");
//		if (driver != null) {
//			driver.quit();
//		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}
