package com.tnduong.page;

public class homePage extends basePage{

    private final String XPATH_BTN_CLOSE_ADS = "//div[contains(@class,'CloseButton-')]";
    public void clickCloseAds(){
        clickOnElement(XPATH_BTN_CLOSE_ADS);
    }

}
