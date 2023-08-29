package com.tnduong.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import com.tnduong.page.homePage;

public class homePageStep {
    @Steps homePage homePage;


    @When("user click close ads")
    public void clickCloseAds() {
        homePage.waitForAllLoadingCompleted();
        homePage.clickCloseAds();
        homePage.waitAbit(20000);
    }


    @Given("open home page")
    public void openHomePage() {
        homePage.open();
    }

    @And("user input keyword {string} into search box")
    public void userInputKeywordIntoSearchBox(String keyword) {
        homePage.userInputKeywordIntoSearchBox(keyword);
    }

    @And("user click on button search")
    public void userClickOnButtonSearch() {
        homePage.userClickOnButtonSearch();
    }

    @And("user choose first product")
    public void userChooseFirstProduct() {
        homePage.userChooseFirstProduct();
    }

    @Then("verify product information detail")
    public void verifyProductInformationDetail() {
        homePage.verifyDetailProductInfo();
    }
}
