package Demo.PageObject;

import Actions.Common.AbstractPage;
import Demo.Interfaces.DemoUI;
import org.openqa.selenium.WebDriver;

public class DemoPageObject extends AbstractPage {
    WebDriver driver;

public DemoPageObject(WebDriver driver){
    this.driver = driver;
}
    public boolean verifyValueItem(String name, String position, String office, String age){
    waitToVisibleDynamic(driver, DemoUI.lblItem,name,position,office,age);
    return elementIsDisplayedDynamic(driver, DemoUI.lblItem, name,position,office,age);
    }


}
