package com.tnduong.steps;

import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import com.tnduong.page.homePage;

public class homePageStep {
    @Steps homePage homePage;


    @When("click close ads")
    public void clickCloseAds() {
        homePage.waitForAllLoadingCompleted();
        homePage.clickCloseAds();
        homePage.waitAbit(20000);
    }


}
