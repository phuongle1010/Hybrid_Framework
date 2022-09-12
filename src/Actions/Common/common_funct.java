package Actions.Common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class common_funct {
    /* NOTE
     * kieu tra ve cua ham la gi thi khai bao kieu ham y nhu vay
     * neu co tham so thi ko dung return
     * ko co tham so tra ve (vd kieu String, Int, ...) thi can phai return
     * thao tác với boolean => public boolean
     * thao tác vơi elements => public WebElement
     * liên quan đến action => public void
     * lấy 1 cái gì đó => public String
     * ngoại trừ public void => còn lại Return*/

    /*Window action*/
    // 1. Open URL
    public void OpenURL(WebDriver driver, String url) {
        driver.get(url);
    }

    // 2. Get Currrent URL
    public String getCurl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    // 3. get current Title
    public String getCTitle(WebDriver driver) {
        return driver.getTitle();
    }

    // 4. back to page
    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    // 5. forward to Page
    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    // 6. refresh
    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    // 7. switch to Window
    public void switchToWindow(WebDriver driver, String tabName) {
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        if (tabName.equals("tab1")) {
            driver.switchTo().window(tab.get(0));
        } else if (tabName.equals("tab2")) {
            driver.switchTo().window(tab.get(1));
        } else if (tabName.equals("tab3")) {
            driver.switchTo().window(tab.get(2));
        }
    }

    // 8. Close window
    public void closeWindow(WebDriver driver, String tabName) {
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        if (tabName.equals("tab1") && tab.size() == 1) {
            driver.switchTo().window(tab.get(0));
            driver.close();
        } else if (tabName.equals("tab2") && tab.size() == 2) {
            driver.switchTo().window(tab.get(1));
            driver.close();

        } else if (tabName.equals("tab3") && tab.size() == 3);
        driver.switchTo().window(tab.get(2));
        driver.close();
    }

    /* Alert action*/
    // 9. Accept Alert
    public void acceptAlert(WebDriver driver) {
        WebDriverWait explicitwait = new WebDriverWait(driver, 30);
        explicitwait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    // 10. Dismiss/Cancel Alert
    public void dismissAlert(WebDriver driver) {
        WebDriverWait ecplictiwait = new WebDriverWait(driver, 30);
        ecplictiwait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
    }

    //11. Send text to Alert
    public void sendTextToAlert(WebDriver driver, String value) {
        WebDriverWait explicitwait = new WebDriverWait(driver, 30);
        explicitwait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().sendKeys(value);
    }

    // 12. get text Alert
    public void getTextAlert(WebDriver driver) {
        WebDriverWait explicitwait = new WebDriverWait(driver, 30);
        explicitwait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().getText();
    }

    /*Element Action*/
    // 13. get 1 element
    public WebElement findElementByXpath(WebDriver driver, String locator){
        return driver.findElement(By.xpath(locator));
    }
    // 14. get multiple elements
    public List<WebElement> findMultipleElements(WebDriver driver, String locator){
        return driver.findElements(By.xpath(locator));
    }
    //* 15. click to element
    public void clickToElement(WebDriver driver, String locator){
        WebElement element = findElementByXpath(driver, locator);
        element.click();
    }
    //* 16. click to elements By JS
    public void clickElementByJS(WebDriver driver, String locator){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element1 = findElementByXpath(driver, locator);
        jsExecutor.executeScript("argument[0].click()", element1);
    }
    // 17. send text to element
    public void sendTextToElement(WebDriver driver,String locator, String value){
        WebElement element = findElementByXpath(driver, locator);
        element.clear(); // luôn luôn clear trước khi send Text
        element.sendKeys(value);
    }
    // 18. select item default dropdown
    public void selectItemDefaultDropdown(WebDriver driver, String locator, String value){
        Select select = new Select(findElementByXpath(driver, locator));
        select.selectByVisibleText(value);
    }
    // 19. check selected item or not
    public WebElement checkSelectedItemOrNot(WebDriver driver,String locator, String value){
        Select select = new Select(findElementByXpath(driver, locator));
       return select.getFirstSelectedOption();
    }
    // 20. select item, custom dropdown
//    public void selectItemCustomDropdown(WebDriver driver, String dropdownFieldXpath, String listLocator, String value){
//        WebDriverWait explicitwait = new WebDriverWait(driver, 30);
//        findElementByXpath(driver, dropdownFieldXpath).click();
//        explicitwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(listLocator)));
//        List<WebElement> allItem = findMultipleElements(driver, listLocator);
//        int totalItem = allItem.size();
//        for (int i = 0; i < totalItem; i++) {
//            String actual
//
//        }
//    }
    // 21. check to checkbox

    // 22. uncheck to checkbox
    // 23. get text
    // 24. get Attribute
    // 25. check element displayed or not?
    // 26. check element enable or not?
    // 27. check element selected or not?
    // 28. hover mouse
    // 29. right click
    // 30. double click
    // 31. click and hold
    // 32. drap and drop
    // 33. scroll to element
    // 34. by xpath
    // 35. wait to visible
    // 36. wait to invisible
    // 37. wait to click able
    // 38. generate number



}

