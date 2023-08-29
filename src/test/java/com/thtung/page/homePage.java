package com.thtung.page;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;
public class homePage extends basePage{

    private final String XPATH_BTN_CLOSE_ADS = "//div[contains(@class,'CloseButton-')]";
    public void clickCloseAds(){
        clickOnElement(XPATH_BTN_CLOSE_ADS);
    }

}
