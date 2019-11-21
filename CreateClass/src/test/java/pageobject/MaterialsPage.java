package pageobject;

import common.PageObject;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class MaterialsPage extends PageObject {
    By tbDateStudy = By.cssSelector("input[name=date_study]");
    By todayDate = By.cssSelector(".ui-datepicker-today a");
    By txttype = By.cssSelector("a.chosen-single");
    By type = By.xpath("//li[contains(text(),'LS')]");
    By txtlevel = By.cssSelector("select[name=level_class]");
    By level = By.xpath(" //option[contains(text(),'BO')]");
  //  By txtstudent = By.xpath("//div[@id='yui_3_9_1_2_1565944287966_117']");
   // By student = By.xpath("//li[contains(text(),'TL')]");
    By btnSearch = By.cssSelector("button.btn_submit_search");
    By btnCreateClass = By.linkText("Create a single room");
    public MaterialsPage()
    {
        super();
        this.Url = "https://lms10ntltester.topica.vn/local/materialservice/view.php?id=2";
    }

    public MaterialsPage chooseToday()
    {
        this.findElement(tbDateStudy).click();
        this.findElement(todayDate).click();
        this.findElement(txttype).click();
        this.findElement(type).click();
        this.findElement(txtlevel);
        this.findElement(level).click();
       // this.findElement(txtstudent).click();
     //   this.findElement(student).click();
        return this;
    }

    public void gotoCreateClass()
    {
        this.findElement(btnCreateClass).click();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void searchClass()
    {
        this.findElement(btnSearch).click();
    }


}
