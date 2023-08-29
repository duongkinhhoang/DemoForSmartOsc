package com.thtung.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import com.thtung.page.homePage;

public class homePageStep {
    @Steps homePage homePage;


    @When("click close ads")
    public void clickCloseAds() {
        homePage.waitForAllLoadingCompleted();
        homePage.clickCloseAds();
        homePage.waitAbit(20000);
    }


}
