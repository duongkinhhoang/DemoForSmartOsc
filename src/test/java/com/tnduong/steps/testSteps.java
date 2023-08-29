package com.tnduong.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import com.tnduong.page.pageObject;

public class testSteps {
  @Steps pageObject pageObject;

//  @Given("I go to mobile menu")
//  public void iGoToMobileMenu() {
//    pageObject.open();
//    pageObject.goToMobileMenu();
//  }
//
//  @And("I go to Mobile Rate Plans menu")
//  public void iGoToMobileRatePlansMenu() {
//    pageObject.goToMobileRatePlan();
//  }
//
//  @When("I select Rs600 plan")
//  public void iSelectRs600Plan() {
//    pageObject.clickGetRs600Plan();
//  }
//
//  @Then("I select Foreigner at Identity Verification screen")
//  public void iSelectForeignerAtIdentityVerificationScreen() {
//    pageObject.selectForeignerIdentityVerificationScr();
//  }
//
//  @And("I enter passport number as {string}")
//  public void iEnterPassportNumberAs(String passportNumber) {
//    pageObject.inputPassportNumber(passportNumber);
//  }
//
//  @And("I click continue button")
//  public void iClickContinueButton() {
//    pageObject.clickContinueButton();
//  }
//
//  @And("I click continue button again")
//  public void iClickContinueButtonAgain() {
//    pageObject.clickContinueButtonAgain();
//  }
//
//  @And("I enter mobile number as {string}")
//  public void iEnterMobileNumberAs(String mobileNumber) {
//    pageObject.inputMobileNumber(mobileNumber);
//  }
//
//  @Then("I should be able to see OTP Verification popup")
//  public void iShouldBeAbleToSeeOTPVerificationPopup() {
//    Assert.assertTrue(pageObject.checkOTPPopUpVisibility());
//  }
//
//  @And("I click select plan button")
//  public void iClickSelectPlanButton() {
//    pageObject.clickSelectPlanButton();
//  }

  @Given("Go to Anhtester web")
  public void goToAnhtesterWeb() {
    pageObject.open();
  }

  @And("Select input form")
  public void selectInputForm() {
    pageObject.clickSelectInputForm();
  }

  @Then("Select simple form")
  public void selectSimpleForm() throws Throwable {
    pageObject.clickSelectSimpleForm();
  }
  @And("Close Popup")
  public void closePopup() throws Throwable {
    pageObject.closePopup();
  }

  @And("Enter randon as {string}")
  public void enterRandonAs(String random) throws Throwable {
    pageObject.inputRandom(random);
  }

  @Then("Click show message")
  public void clickShowMessage() throws Throwable {
    pageObject.clickShowMeassage();
  }

  @And("Verify message {string}")
  public void verifyMessage(String message) {
    Assert.assertTrue(pageObject.checkMessageDisplay(message));
  }

  @And("Enter number a as {string}")
  public void enterNumberAAs(String a) {
    pageObject.EnterA(a);
  }

  @And("Enter number b as {string}")
  public void enterNumberBAs(String b) {
    pageObject.EnterB(b);
  }

  @Then("Click get total")
  public void clickGetTotal() {
    pageObject.clickGetTotal();
  }


}
