package com.tnduong.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class pageObject extends PageObject {
//  @FindBy(xpath = "//a[text()='Input Forms']")
//  public WebElementFacade sidebarInputForms;
//
//  public void clickInputForms() {
//    waitFor(sidebarInputForms).waitUntilVisible().click();
//    find(By.xpath("//a[text()='Input Forms']")).click();
//  }

  public void waitAbit(int millisecond) {
    waitABit(millisecond);
  }
  public void clickSelectInputForm() {
    WebElementFacade btnInputForm = $(By.xpath("//a[text()='Input Forms']"));

//    scrollIntoView(getDriver(), btnNext);
    btnInputForm.waitUntilVisible().click();
  }

  public void clickSelectSimpleForm() throws Throwable {
    WebElementFacade btnSimpleForm = $(By.xpath("//a[text()='Input Forms']/..//a[text()='Simple Form Demo']"));
//    scrollIntoView(getDriver(), btnNext);
    btnSimpleForm.waitUntilVisible().click();
    Thread.sleep(5000);
  }


  public void closePopup() throws Throwable {
    WebElementFacade btnPopup = $(By.id("at-cv-lightbox-close"));
//    scrollIntoView(getDriver(), btnNext);
    btnPopup.waitUntilVisible().click();
    Thread.sleep(1000);
  }
  public void inputRandom(String random) throws Throwable {
    WebElementFacade messageField = $(By.id("user-message"));
    messageField.waitUntilVisible().type(random);
    Thread.sleep(3000);
  }

  public void clickShowMeassage() throws Throwable {
    WebElementFacade btnShowMeassage = $(By.xpath("//button[text()='Show Message']"));
//    scrollIntoView(getDriver(), btnNext);
    btnShowMeassage.waitUntilVisible().click();
    Thread.sleep(3000);
  }

  public boolean checkMessageDisplay(String message) {
    WebElementFacade btnVerifyMessage = $(By.xpath(String.format("//span[@id='display' and text()='%s']",message)));
    return btnVerifyMessage.waitUntilVisible().isVisible();


  }
  public void EnterA(String a) {
    WebElementFacade firstField = $(By.id("sum1"));
    firstField.waitUntilEnabled().type(a);
  }
  public void EnterB(String b) {
    WebElementFacade secondField = $(By.id("sum1"));
    secondField.waitUntilEnabled().type(b);
  }
  public void clickGetTotal() {
    WebElementFacade btnGetTotal = $(By.xpath("//button[text()=\"Get Total\"]"));
//    scrollIntoView(getDriver(), btnNext);
    btnGetTotal.waitUntilVisible().click();
  }




}
