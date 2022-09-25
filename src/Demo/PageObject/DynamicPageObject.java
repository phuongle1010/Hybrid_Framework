package Demo.PageObject;

import Actions.Common.AbstractPage;
import Demo.Interfaces.DynamicUI;
import org.openqa.selenium.WebDriver;

public class DynamicPageObject extends AbstractPage {
    WebDriver driver;

    public DynamicPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyValueItem(String name, String position, String office, String age) {
        waitToVisibleDynamic(driver, DynamicUI.lblItem, name, position, office, age);
        return elementIsDisplayedDynamic(driver, DynamicUI.lblItem, name, position, office, age);
    }
}
