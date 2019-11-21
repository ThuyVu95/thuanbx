package pageobject;

import common.PageObject;
import org.openqa.selenium.By;

public class CreateClassPage extends PageObject {
	By tbTitle = By.cssSelector("input[name=\"subject_name\"]");
	By tbCode = By.cssSelector("input[name=\"code\"]");
	By tbTopic = By.cssSelector("textarea[name=\"topic\"]");
	By tbObjective = By.cssSelector("textarea[name=\"objective\"]");
	By choosetxtTypestudent = By.xpath("//select[@id='id_student_type']");
	By chooseTypestudent = By.xpath("//select[@id='id_student_type']//option[2]");
	By choosetxtTypeclass = By.xpath("//select[@id='id_type_class']");
	By chooseTypeclass = By.xpath("//div[@id='fitem_id_type_class']//option[5]");
	By btnSave = By.cssSelector("input[name=\"submitbutton\"]");

	public CreateClassPage() {
		super();
		this.Title = "Create a single room";
		this.Url = "https://lms10ntltester.topica.vn/local/materialservice/create_class.php";
	}

	public CreateClassPage withTitle(String title) {
		this.findElement(tbTitle).sendKeys(title);
		return this;
	}

	public CreateClassPage withCode(String code) {
		this.findElement(tbCode).sendKeys(code);
		return this;
	}

	public CreateClassPage withTopic(String topic) {
		this.findElement(tbTopic).sendKeys(topic);
		return this;
	}

	public CreateClassPage withObjective(String objective) {
		this.findElement(tbObjective).sendKeys(objective);
		return this;
	}

	public CreateClassPage withTypestudent() {
		this.findElement(choosetxtTypestudent).click();
		this.findElement(chooseTypestudent).click();
		return this;
	}

	public CreateClassPage withTypeclass() {
		this.findElement(choosetxtTypeclass).click();
		this.findElement(chooseTypeclass).click();
		return this;
	}

	public void createClass() {
		this.findElement(btnSave).click();
		this.driver.close();
	}
}
