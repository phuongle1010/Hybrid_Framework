package Actions.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AbstractPage {

    // kieu tra ve cua ham la gi thi khai bao kieu ham y nhu vay
    // neu co tham so thi ko dung return
    // ko co tham so tra ve (vd kieu String, Int, ...) thi can phai return
    // thao tác với boolean => public boolean
    // thao tác vơi elements => public WebElement
    // liên quan đến action => public void
    // lấy 1 cái gì đó => public String
    // ngoại trừ public void => còn lại Return

    // 1. open url
    public void openURL(WebDriver driver, String url) {
        driver.get(url);
    }

    // 2. get current url
    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    // 3. get current title
    public String getCurrentTitle(WebDriver driver) {
        return driver.getTitle();
    }

    // 4. back to page
    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    // forward to page
    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    // refresh page
    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    // accept alert
    public void acceptAlert(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    // cancel alert
    public void dismissAlert(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    // send text alert
    public void sendTextAlert(WebDriver driver, String text) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(text);
    }

    // get text alert
    public String getTextAlert(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    // switch to windows / tab
    public void switchToWindowsTab(WebDriver driver, String tabName) {
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        if (tabName.equals("tab1")) {
            driver.switchTo().window(tab.get(0));
        }
        if (tabName.equals("tab2")) {
            driver.switchTo().window(tab.get(1));
        }
        if (tabName.equals("tab3")) {
            driver.switchTo().window(tab.get(2));
        }
    }

    // close to windows / tab
    public void closeWindowsTab(WebDriver driver, String tabName) {
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        if (tabName.equals("tab1") && tab.size() == 1) {
            driver.switchTo().window(tab.get(0));
            driver.close();
        }
        if (tabName.equals("tab2") && tab.size() == 2) {
            driver.switchTo().window(tab.get(1));
            driver.close();
        }
        if (tabName.equals("tab3") && tab.size() == 3) {
            driver.switchTo().window(tab.get(2));
            driver.close();
        }
    }

    // varArgument / restParameter
    // String... đại diện cho n tham số
    // String.format: return lại chuỗi đã dc format
    public String varAguments(String xpathxpathLocator, String... values) {
        return String.format(xpathxpathLocator, (Object[]) values);
    }

    // get element
    public WebElement findElementByXpath(WebDriver driver, String xpathxpathLocator) {
        return driver.findElement(By.xpath(xpathxpathLocator));
    }

    // get elements
    public List<WebElement> findElementsByXpath(WebDriver driver, String xpathxpathLocator) {
        return driver.findElements(By.xpath(xpathxpathLocator));
    }

    // click to element
    public void clickToElement(WebDriver driver, String xpathxpathLocator) {
       findElementByXpath(driver, xpathxpathLocator).click();
    }

    // click to element with dynamic xpathLocator
    public void clickToElement(WebDriver driver, String xpathxpathLocator, String... values) {
       findElementByXpath(driver, varAguments(xpathxpathLocator, values)).click();
    }

    // click to element by JS (include custom checkbox)
    public void clickToElementByJS(WebDriver driver, String xpathLocator) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = findElementByXpath(driver, xpathLocator);
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    // sendKey to element
    public void sendKeytoElement(WebDriver driver, String xpathLocator, String value) {
        WebElement element = findElementByXpath(driver, xpathLocator);
        element.clear(); // luôn luôn clear trước khi Input
        element.sendKeys(value);
    }

    // select item default dropdown
    public void selectItemDefaultDropdown(WebDriver driver, String xpathLocator, String value) {
        Select select = new Select(findElementByXpath(driver, xpathLocator));
        select.selectByVisibleText(value);
    }

    // select item default dropdown


    // get first selected option
    public WebElement getFirstSelectedOption(WebDriver driver, String xpathLocator) {
        Select select = new Select(findElementByXpath(driver, xpathLocator));
        return select.getFirstSelectedOption();
    }

    // get first selected option

    // select item custom dropdown
    public void selectItemCustomDropdown(WebDriver driver, String selectFieldXpath, String listXpath, String expectedValue) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        findElementByXpath(driver, selectFieldXpath).click();
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(listXpath)));
        List<WebElement> allItem = findElementsByXpath(driver, listXpath);
        int totalItem = allItem.size();
        for (int i = 0; i < totalItem; i++) {
            String actualValue = allItem.get(i).getText();
            if (actualValue.equals(expectedValue)) {
                allItem.get(i).click();
                break;
            }
        }
    }

    // get text
    public String getText(WebDriver driver, String xpathLocator) {
        return findElementByXpath(driver, xpathLocator).getText();
    }

    // get text with dynamic locator

    // get attribute
    public String getAttribute(WebDriver driver, String xpathLocator, String nameAttribute) {
        return findElementByXpath(driver, xpathLocator).getAttribute(nameAttribute);
    }

    // check to checkbox
    public void checkToCheckbox(WebDriver driver, String xpathLocator) {
        WebElement element = findElementByXpath(driver, xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    // uncheck to checkbox
    public void uncheckToCheckbox(WebDriver driver, String xpathLocator) {
        WebElement element = findElementByXpath(driver, xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    // verify element is displayed
    public boolean elementIsDisplayed(WebDriver driver, String xpathLocator) {
        return findElementByXpath(driver, xpathLocator).isDisplayed();
    }

    // verify element is displayed with dynamic locator

    // verify element is enabled
    public boolean elementIsEnable(WebDriver driver, String xpathLocator) {
        return findElementByXpath(driver, xpathLocator).isEnabled();
    }

    // verify element is selected
    public boolean elementIsSelected(WebDriver driver, String xpathLocator) {
        return findElementByXpath(driver, xpathLocator).isSelected();
    }

    // hover to element
    public void hoverToElement(WebDriver driver, String xpathLocator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElementByXpath(driver, xpathLocator)).perform();
    }

    // right click
    public void rightClick(WebDriver driver, String xpathLocator) {
        Actions actions = new Actions(driver);
        actions.contextClick(findElementByXpath(driver, xpathLocator)).perform();
    }

    // double click
    public void doubleClick(WebDriver driver, String xpathLocator) {
        Actions actions = new Actions(driver);
        actions.doubleClick(findElementByXpath(driver, xpathLocator)).perform();
    }

    // click and hold
    public void clickAndHold(WebDriver driver, String xpathLocator) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(findElementByXpath(driver, xpathLocator)).perform();
    }

    // drag and drop
    public void drapAndDrop(WebDriver driver, String source, String target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(findElementByXpath(driver, target), findElementByXpath(driver, source)).perform();
    }

    // scroll to element
    public void scrollToElement(WebDriver driver, String xpathLocator) {
        WebElement element = findElementByXpath(driver, xpathLocator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);)", element);
    }

    // by xpath(xpathLocator)
    public By byXpath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    // wait to visible
    public void waitToVisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathLocator)));
    }

    // wait to visible with dynamic locator

    // wait to invisible
    public void waitToInvisible(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathLocator)));
    }

    // wait to invisible with dynamic locator

    // wait to clickable
    public void waitToClickable(WebDriver driver, String xpathLocator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathLocator)));
    }

    // wait to clickable with dynamic locator

    public void sleep(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
