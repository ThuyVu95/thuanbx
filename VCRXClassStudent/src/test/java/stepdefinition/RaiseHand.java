package stepdefinition;

import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.*;
import pageobject.XtoolPage;
import pageobject.LoginPage;
import pageobject.VCRXPage;

public class RaiseHand {
	LoginPage loginPage;
	XtoolPage gotoclass;
	VCRXPage raisehand;

	public RaiseHand() {
		this.loginPage = new LoginPage();
		this.gotoclass = new XtoolPage();
		this.raisehand = new VCRXPage();
	}

	@Given("Login Xtool")
	public void login_Xtool() {
		this.loginPage.Open();
		this.loginPage.login("admin", "123456");

	}

	@Then("Go to in class VCRX")
	public void go_to_in_class_VCRX() {
		this.gotoclass.MovetoClass();
	}

	@Given("Page VCRX already")
	public void page_VCRX_already() {
		//this.raisehand.Open();
		this.gotoclass.switchToTop(this.raisehand);
	}

	@When("Raise hand")
	public void raise_hand() {
		this.raisehand.Raisehand();

	}

	@Then("Display icon raise hand on listuser")
	public void display_icon_raise_hand_on_listuser() {

	}

}
