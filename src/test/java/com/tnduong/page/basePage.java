package com.tnduong.page;

import io.appium.java_client.functions.ExpectedCondition;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.util.Strings;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;
public class basePage extends PageObject{

        public static final long TIMEOUT_IN_SECONDS = 20;
        // <!---------------------------------------------------- BEGIN COMMON ------------------------------------------------------------>
        public <T> T executeJS(String command) {
            JavascriptExecutor jsExec = (JavascriptExecutor) getDriver();
            System.out.println("execute script: " + command);
            System.out.println();
            return (T) jsExec.executeScript(command);
        }
        public void highlightElement(WebElementFacade element) {
            executeJS("arguments[0].style.border='2px solid red'", element);
        }
        public void highlightElementAndLogText(WebElementFacade element) {
            highlightElement(element);
            String text = element.getText();
            System.out.println("Click on element " + ((text == null || text.isEmpty() || text.equals(" ")) ? element.toString() : "has text: [" + text +
                    "]"));
        }
        public <T> T executeJS(String script, WebElementFacade element) {
            return (T) ((JavascriptExecutor) getDriver()).executeScript(script, element);
        }
        public boolean isElementExist(String xPath) {
            boolean isExist = false;
            List<WebElementFacade> e = findAllElements(xPath);
            if (e.size() != 0) {
                highlightElement(e.get(0));
                isExist = true;
            }
            System.out.println("Is Element " + xPath + " Exist: " + isExist);
            return isExist;
        }
        public void hoverElement(String xPath) {
            WebElementFacade element = getElement(xPath);
            Actions builder = new Actions(getDriver());
            builder.moveToElement(element).perform();
        }
        public void scrollElementIntoView(WebElementFacade element) {
            executeJS("arguments[0].scrollIntoView(false);", element);
        }
        public WebElementFacade scrollElementIntoView(String xPath) {
            WebElementFacade element = getElement(xPath);
            scrollElementIntoView(element);
            return element;
        }

        public void quitDriver() {
            getDriver().manage().deleteAllCookies();
            getDriver().quit();
        }

        public void clearCacheAndRefreshPage() {
            clearCache();
            getDriver().navigate().refresh();
        }
        public void clearCache() {
            getDriver().manage().deleteAllCookies();
        }
        public void waitUntilElementReady(WebElementFacade element) {
            scrollElementIntoView(element);
            element.waitUntilClickable();
        }
        public void verifyTextNotNullOrEmpty(String expected) {
            boolean actual = Strings.isNullOrEmpty(expected);
            System.out.println("Verify text is not null/empty, actual is " + actual + ", expected is " + expected);
            assertThat(actual).isEqualTo(false);
        }
        public void verifyElementIsDisplayed(WebElementFacade element, boolean expected) {
            boolean actual = element.isDisplayed();
            System.out.println("Verify element is displayed, actual is " + actual + ", expected is " + expected);
            assertThat(actual).isEqualTo(expected);
        }
        public void verifyElementIsExisted(String xpath, boolean expected) {
            boolean actual = isElementExist(xpath);
            System.out.println("Verify element is existed, actual is " + actual + ", expected is " + expected);
            assertThat(actual).isEqualTo(expected);
        }
        public void verifyTextValueEquals(String actual, String expected) {
            System.out.println("Verify text value equals, actual is " + actual + ", expected is " + expected);
            assertThat(actual).isEqualTo(expected);
        }
        public void verifyNumberValueEquals(int actual, int expected) {
            System.out.println("Verify number value equals, actual is " + actual + ", expected is " + expected);
            assertThat(actual).isEqualTo(expected);
        }
        public void verifyResultSizeGreaterThanZero(int actual) {
            System.out.println("Verify results size is greater than 0, actual is " + actual);
            assertThat(actual).isGreaterThan(0);
        }
        public void verifyResultSizeGreaterThanOne(int actual) {
            System.out.println("Verify results size is greater than 0, actual is " + actual);
            assertThat(actual).isGreaterThan(1);
        }
        public void verifyResultSizeGreaterThanOrEqualOne(int actual) {
            System.out.println("Verify results size is greater than 1, actual is " + actual);
            assertThat(actual).isGreaterThanOrEqualTo(1);
        }
        public void verifyResultSizeLessThanOrEqual(int actual, int expect) {
            System.out.println("Verify results size is greater than 1, actual is " + actual);
            assertThat(actual).isLessThanOrEqualTo(expect);
        }
        public void verifyTextValueNotEqual(String actual, String expected) {
            System.out.println("Verify text value not equal, actual is " + actual + ", expected is " + expected);
            assertThat(actual).isNotEqualTo(expected);

        }
        public void verifyTextValueContains(String actual, String expected) {
            System.out.println("Verify text value contains" + expected + ", actual is " + actual + ", expected is " + expected);
            assertThat(actual.contains(expected)).isEqualTo(true);
        }
        public void verifyTextValueNotContains(String actual, String expected) {
            System.out.println("Verify text value not contains " + expected + ", actual is " + actual + ", expected is " + expected);
            assertThat(actual.contains(expected)).isEqualTo(false);
        }
        public void verifyTheNumberOfElements(String xpath, int expected) {
            int actual = findAllElements(xpath).size();
            System.out.println("Verify the number of elements, actual is " + actual + ", expected is " + expected);
            assertThat(actual).isEqualTo(expected);
        }
        public void verifyTextValueEqualsIgnoringCase(String actual, String expected) {
            System.out.println("Verify text value equals, actual is " + actual + ", expected is " + expected);
            assertThat(actual).isEqualToIgnoringCase(expected);
        }
        public By isXpathOrCssSelector(String value) {
            if (value.contains("//"))
                return By.xpath(value);
            else
                return By.cssSelector(value);
        }

        // <!---------------------------------------------------- END COMMON ------------------------------------------------------------>
// <!---------------------------------------------------- BEGIN GET ELEMENTS --------------------------------------------------------->
        public WebElementFacade getElement(String xpathOrCss) {
            return find(isXpathOrCssSelector(xpathOrCss));
        }
        public List<WebElementFacade> findAllElements(String xpathOrCss) {
            return findAll(xpathOrCss);
        }
        // <!---------------------------------------------------- END GET ELEMENTS ------------------------------------------------------------>
// <!---------------------------------------------------- BEGIN CLICK ELEMENT --------------------------------------------------------->
        public void clickOnElement(WebElementFacade element) {
            DateTime timeout = DateTime.now().plusSeconds(Integer.parseInt(String.valueOf(TIMEOUT_IN_SECONDS)));
            do {
                try {
                    scrollElementIntoView(element);
                    highlightElementAndLogText(element);

                    element.click();
                    break;
                } catch (Exception exception) {
                    System.out.println("Retrying click element...");
                    
                }
            } while (DateTime.now().isBefore(timeout));
            waitForAllLoadingCompleted();
        }
        public void clickOnElement(String xpathOrCss) {
            System.out.println("xpathOrCss: " + xpathOrCss);
            WebElementFacade element = getElement(xpathOrCss);
            clickOnElement(element);
        }
        public void clickByJS(WebElementFacade element) {
            DateTime timeout = DateTime.now().plusSeconds(Integer.parseInt(String.valueOf(TIMEOUT_IN_SECONDS)));
            do {
                try {
                    scrollElementIntoView(element);
                    highlightElementAndLogText(element);
                    executeJS("arguments[0].click();", element);
                    break;
                } catch (Exception exception) {
                    System.out.println("Retrying click element...");
                    
                }
            } while (DateTime.now().isBefore(timeout));
            waitForAllLoadingCompleted();
        }
        public void clickByJS(String xpathOrCss) {
            WebElementFacade element = getElement(xpathOrCss);
            clickByJS(element);
        }
        public void doubleClick(String xpathOrCss) {
            WebElementFacade element = getElement(xpathOrCss);
            waitUntilElementReady(element);
            highlightElementAndLogText(element);
            Actions action = new Actions(getDriver());
            action.doubleClick(element).perform();
        }
        public void doubleClickByJS(String xpathOrCss) {
            WebElementFacade element = getElement(xpathOrCss);
            waitUntilElementReady(element);
            highlightElement(element);
            executeJS("var evt = document.createEvent('MouseEvents');"
                    + "evt.initMouseEvent('dblclick',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);"
                    + "arguments[0].dispatchEvent(evt);", element);

        }
        public void clickOnDisplayedElement(String xpathOrCss) {
            List<WebElementFacade> elements = findAllElements(xpathOrCss);
            if (elements.size() > 0) {
                WebElementFacade element = elements.stream().filter(WebElementFacade::isDisplayed).findFirst().get();
                clickOnElement(element);
            }
        }
        public void clickOnDisplayedElement(WebElementFacade element) {
            if (element.isDisplayed())
                clickOnElement(element);
        }
        public void selectOptionFromDDLByValue(String xpathOrCss, String item) {
            Select dropdown = new Select(getElement(xpathOrCss));
            dropdown.selectByValue(item);
        }
        public void selectOptionFromDDLByIndex(String xpathOrCss, int index) {
            Select dropdown = new Select(getElement(xpathOrCss));
            dropdown.selectByIndex(index);
        }
        public void selectOptionFromDDLByText(String xpathOrCss, String item) {

            Select dropdown = new Select(getElement(xpathOrCss));
            dropdown.selectByVisibleText(item);
        }
        // <!---------------------------------------------------- END CLICK ELEMENT --------------------------------------------------------->
// <!---------------------------------------------------- BEGIN GET TEXT --------------------------------------------------------->
        public String getText(String xpathOrCss) {
            WebElementFacade element = getElement(xpathOrCss);
            scrollElementIntoView(element);
            highlightElement(element);
            return element.getText();
        }
        public String getTextValue(String xpathOrCss) {
            WebElementFacade element = getElement(xpathOrCss);
            highlightElement(element);
            return element.getTextValue();
        }
        public String getTextByAttribute(String xpathOrCss, String attribute) {
            WebElementFacade element = getElement(xpathOrCss);
            highlightElement(element);
            return element.getAttribute(attribute);
        }
        // <!---------------------------------------------------- END GET TEXT --------------------------------------------------------->
// <!---------------------------------------------------- BEGIN IFRAME --------------------------------------------------------->
        public void switchToIFrame(WebElementFacade elementFacade) {
            System.out.println("Switch to iframe: " + elementFacade.toString());
            getDriver().switchTo().frame(elementFacade);
        }
        public void switchOutDefaultIFrame() {
            System.out.println("Switch out to default iframe");
            getDriver().switchTo().defaultContent();
        }
        public void openNewBrowserTab(String url) {
            ((JavascriptExecutor) getDriver()).executeScript("window.open();");
            switchToNewBrowserTab();
            getDriver().get(url);
        }
        public void switchToNewBrowserTab() {
            int size = getAllBrowserTab().size();
            String siteHandle = ((String) getAllBrowserTab().toArray()[size - 1]);
            getDriver().switchTo().window(siteHandle);
            getDriver().manage().window().maximize();
            System.out.println("Switch to the latest browser tab: " + (size - 1));
        }
        public void switchToChildWindowsWithContainsTitle(String title) {
            Set<String> allWindows = getDriver().getWindowHandles();
            for (String runWindow : allWindows) {
                getDriver().switchTo().window(runWindow);
                getDriver().manage().window().maximize();
                String currentWin = getDriver().getTitle();
                if (currentWin.contains(title)) {
                    break;
                }
            }
        }
        public void switchToBrowserTabByIndex(int index) {
            String siteHandle = ((String) getAllBrowserTab().toArray()[index]);
            getDriver().switchTo().window(siteHandle);
            System.out.println("Switch to browser tab with index: " + index);
        }
        public Set<String> getAllBrowserTab() {
            return getDriver().getWindowHandles();
        }
        public void closeCurrentBrowserTab() {
            getDriver().close();
        }
        public void closeAllNewBrowserTab() {
            int browsers = getDriver().getWindowHandles().size();
            for (int i = 0; i < browsers - 1; i++) {

                switchToNewBrowserTab();
                closeCurrentBrowserTab();
            }
            switchToNewBrowserTab();
            switchOutDefaultIFrame();
        }
        // <!---------------------------------------------------- END IFRAME --------------------------------------------------------->
// <!---------------------------------------------------- BEGIN WAIT --------------------------------------------------------->
        public void waitForAllLoadingCompleted() {
            waitUntilJQueryRequestCompleted(TIMEOUT_IN_SECONDS);
            waitForJQueryLoadingCompleted(TIMEOUT_IN_SECONDS);
            waitUntilHTMLReady(TIMEOUT_IN_SECONDS);
            waitForLoadingIndicatorCircle(TIMEOUT_IN_SECONDS);
        }
        public void waitForLoadingIndicatorCircle(long timeoutInSeconds) {
            waitForInvisibilityOfElement("div[data-role='loading-indicator']", timeoutInSeconds);
        }
        public void waitUntilJQueryRequestCompleted(long timeoutInSeconds) {
            new FluentWait<>(getDriver()).withTimeout(Duration.of(timeoutInSeconds, ChronoUnit.SECONDS))
                    .withMessage("**** INFO **** JQUERY STILL LOADING FOR OVER" + timeoutInSeconds + "SECONDS.")
                    .pollingEvery(Duration.of(300, ChronoUnit.MILLIS)).until((ExpectedCondition<Boolean>) driver -> {
                        try {
                            JavascriptExecutor jsExec = (JavascriptExecutor) driver;
                            return (Boolean) jsExec.executeScript("return jQuery.active === 0");
                        } catch (Exception e) {
                            return true;
                        }
                    });

        }
        public void waitForJQueryLoadingCompleted(long timeoutInSeconds) {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeoutInSeconds);
            ExpectedCondition<Boolean> jQueryLoad = driver -> {
                try {
                    return ((Long) ((JavascriptExecutor) getDriver()).executeScript("return $.active") == 0);
                } catch (Exception e) {
// no jQuery present
                    return true;
                }
            };
            wait.until(jQueryLoad);
        }
        public void waitUntilHTMLReady(long timeoutInSeconds) {
            new FluentWait<>(getDriver()).withTimeout(Duration.of(timeoutInSeconds, ChronoUnit.SECONDS))
                    .pollingEvery(Duration.of(300, ChronoUnit.MILLIS)).until(new ExpectedCondition<Boolean>() {
                        @Override
                        public Boolean apply(WebDriver d) {
                            try {
                                JavascriptExecutor jsExec = (JavascriptExecutor) d;
                                return jsExec.executeScript("return document.readyState").toString().equals("complete");
                            } catch (Exception e) {
                                return true;
                            }
                        }
                    });

        }
        public WebElementFacade waitElementToBePresent(String xpathOrCss) {
            this.waitFor(ExpectedConditions.presenceOfElementLocated(isXpathOrCssSelector(xpathOrCss)));
            return getElement(xpathOrCss);
        }
        public void waitForVisibilityOfElement(String xpathOrCss, long timeOutInSeconds) {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(isXpathOrCssSelector(xpathOrCss)));
        }
        public void waitForVisibilityOfElement(String xpathOrCss) {
            waitForVisibilityOfElement(xpathOrCss, TIMEOUT_IN_SECONDS);
        }
        public void waitForInvisibilityOfElement(String xpathOrCss, long timeOutInSecond) {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSecond);

            wait.until(ExpectedConditions.invisibilityOfElementLocated(isXpathOrCssSelector(xpathOrCss)));
        }
        public void waitForInvisibilityOfElement(String xpathOrCss) {
            waitForInvisibilityOfElement(xpathOrCss, TIMEOUT_IN_SECONDS);
        }
        public void waitForPresenceOfElement(String xpathOrCss, long timeOutInSecond) {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSecond);
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(isXpathOrCssSelector(xpathOrCss)));
        }
        public void waitForPresenceOfElement(String xpathOrCss) {
            waitForPresenceOfElement(xpathOrCss, TIMEOUT_IN_SECONDS);
        }
        public void waitForNotPresenceOfElement(String xpathOrCss) {
            WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT_IN_SECONDS);
            wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(isXpathOrCssSelector(xpathOrCss))));
        }
        public void waitForElementToBeClickable(String xpathOrCss) {
            WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT_IN_SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(isXpathOrCssSelector(xpathOrCss)));
        }
        public void waitForElementNotToBeClickable(String xpathOrCss) {
            WebDriverWait wait = new WebDriverWait(getDriver(), TIMEOUT_IN_SECONDS);
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(isXpathOrCssSelector(xpathOrCss))));
        }
        public void waitAbit(int millisecond) {
            waitABit(millisecond);
        }
        // <!---------------------------------------------------- END WAIT --------------------------------------------------------->
// <!---------------------------------------------------- BEGIN INPUT FIELD --------------------------------------------------------->
        public void waitTypeAndTab(String xpathOrCss, String value) {
            WebElementFacade element = getElement(xpathOrCss);
            waitUntilElementReady(element);
            element.clear();
            element.typeAndTab(value);
        }
        public void waitAndType(String xpathOrCss, String value) {
            WebElementFacade element = getElement(xpathOrCss);
            waitUntilElementReady(element);
            element.clear();
            element.type(value);
        }
        public void waitTypeAndEnter(String xpathOrCss, String value) {
            WebElementFacade element = getElement(xpathOrCss);
            waitUntilElementReady(element);
            element.clear();
            element.typeAndEnter(value);
        }
        public String generateAUM() {
            int[] arr = {1, 2, 3};
            int ind = new Random().nextInt(arr.length);
            return "Vip" + arr[ind];
        }
        // <!---------------------------------------------------- END INPUT FIELD --------------------------------------------------------->
// <!---------------------------------------------------- BEGIN DROPDOWN LIST --------------------------------------------------------->
        public List<String> getListValueDDL(String xpath) {
            List<String> listValue = new ArrayList<>();
            List<WebElementFacade> ddlOption = findAllElements(xpath);
            for (WebElement e : ddlOption) {
                listValue.add(e.getText().trim());
            }
            return listValue;
        }
    }
