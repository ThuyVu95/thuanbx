package stepdefinition;

import io.cucumber.java.en.*;
import pageobject.CreateClassPage;
import pageobject.LoginPage;
import pageobject.MaterialsPage;

public class CreateClassDefs {
    LoginPage loginPage;
    CreateClassPage createClassPage;
    MaterialsPage materialsPage;

    public CreateClassDefs()
    {
        this.loginPage = new LoginPage();
        this.createClassPage = new CreateClassPage();
        this.materialsPage = new MaterialsPage();
    }
    @Given("^The Login is Opened$")
    public void the_login_is_opened() throws Throwable {
        this.loginPage.Open();
    }

    @Given("^The Open Class windows already opened$")
    public void the_open_class_windows_already_opened() throws Throwable {
        this.materialsPage.Open();
    }

    @When("^The User attempt to create a single room$")
    public void the_user_attempt_to_create_a_single_room() throws Throwable {
        this.materialsPage.gotoCreateClass();
        this.materialsPage.switchToTop(this.createClassPage);
    }

    @Then("^The User attempt to login with \"([^\"]*)\" and \"([^\"]*)\" information$")
    public void the_user_attempt_to_login_with_something_and_something_information(String email, String pwd) throws Throwable {
        this.loginPage.withEmail(email).withPassword(pwd).login();
    }

    @Then("^The class manager will se the just created class on open class list$")
    public void the_class_manager_will_se_the_just_created_class_on_open_class_list() throws Throwable {
        this.materialsPage.switchBack();
        this.materialsPage.chooseToday().searchClass();
    }

    @And("^The class manager try to fill out the valid value to all fields before attempt to create a class$")
    public void the_class_manager_try_to_fill_out_the_valid_value_to_all_fields_before_attempt_to_create_a_class() throws Throwable {
        this.createClassPage.withTitle("AutoTest class")
                .withCode("LS_BS1608")
                .withTopic("LS_BS1608")
                .withObjective("LS_BS1608")
                .withTypestudent().withTypeclass()
                .createClass();
    }
}
