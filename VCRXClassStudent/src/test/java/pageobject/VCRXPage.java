package pageobject;

import common.PageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VCRXPage extends PageObject {
	By cal = By.xpath("//span[@class='time-count-down']");

	public VCRXPage() {
		super();
		this.Url = "https://vcrxnvntester.topica.vn/505";
	}

//	public boolean CountdownTime() {
//		String[] cal1 = this.findElement(cal).getText().split(":");
//		String hour1 = cal1[1];
//		String minute1 = cal1[2];
//		String second1 = cal1[3];
//
//		int minuteT = Integer.parseInt(minute1);
//		int secondT = Integer.parseInt(second1);
//		int hourT = Integer.parseInt(hour1);
//		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//		String[] cal2 = this.findElement(cal).getText().split(":");
//		String hour2 = cal2[1];
//		String minute2 = cal2[2];
//		String second2 = cal2[3];
//
//		int minuteS = Integer.parseInt(minute2);
//		int secondS = Integer.parseInt(second2);
//		int hourS = Integer.parseInt(hour2);
//		if (secondS < secondT) {
//			return true;
//		} else
//			return false;
//	}
//
//	public void Calendar(VCRXPage CountdownTime) {
//		Calendar c = Calendar.getInstance();
//		int hourLocal = c.get(Calendar.HOUR);
//		int minuteLocal = c.get(Calendar.MINUTE);
//		int secondLocal = c.get(Calendar.SECOND);
//
//		if (((minuteLocal >= 45) && (minuteLocal <= 59)) && ((secondLocal >= 0) && (secondLocal <= 59))) {
//			Assert.assertEquals(true, CountdownTime);
//		} else if (((minuteLocal < 45) && (minuteLocal > 59)) && ((secondLocal >= 0) && (secondLocal <= 59))) {
//			Assert.assertEquals(false, CountdownTime);
//		}
//	}

	public void Raisehand() {
//		//driver.switchTo().alert().accept();
		Actions actions = new Actions(driver);
		for (int i = 1; i < 5; i++) {
			actions.sendKeys(Keys.ESCAPE).build().perform();
		}
		// actions.ESCAPE.perform();
		WebElement HandOnTool = this.findElement(By.xpath("//i[@class='fa fa-hand-paper-o']"));
		HandOnTool.click();
		WebElement HandOnListUser = this.findElement(By.xpath("//i[@class='material-icons button-han']"));
		
		Assert.assertEquals(true, HandOnListUser.isDisplayed());
		
	}
}
