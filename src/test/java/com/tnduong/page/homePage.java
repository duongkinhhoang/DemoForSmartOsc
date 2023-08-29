package com.tnduong.page;

public class homePage extends basePage{

    private final String XPATH_BTN_CLOSE_ADS = "//div[contains(@class,'CloseButton-')]";
    private final String XPATH_BTN_CLOSE_ADS2 = "//div[contains(@id,'modal-banner-close')]";
    private final String XPATH_SEARCH_BOX = "//input[@id='header-search-box']";
    private final String XPATH_BTN_SEARCH = "//img[contains(@class,'Se')]";
    private final String XPATH_FIRST_PRODUCT = "(//div[@class='MuiProductCard-Vertical-Name-productName'])[1]";
    private final String XPATH_PRICE = "//div[contains(@class,'ProductEssentialPrice__PriceSectionBott')]";

    public void clickCloseAds(){
        clickOnElement(XPATH_BTN_CLOSE_ADS);
        waitUntilElementReady(getElement(XPATH_BTN_CLOSE_ADS2));
        clickOnElement(XPATH_BTN_CLOSE_ADS2);
    }
    public void userInputKeywordIntoSearchBox(String keyword){
        waitForAllLoadingCompleted();
        waitAndType(XPATH_SEARCH_BOX,keyword);
    }
    public void userClickOnButtonSearch(){
        clickOnElement(XPATH_BTN_SEARCH);
    }
    public void userChooseFirstProduct(){
        clickOnElement(XPATH_FIRST_PRODUCT);
        switchToNewBrowserTab();
    }

    public void verifyDetailProductInfo(){
        verifyElementIsDisplayed(getElement(XPATH_PRICE),true);
    }
}
