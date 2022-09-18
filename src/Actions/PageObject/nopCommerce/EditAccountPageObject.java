package Actions.PageObject.nopCommerce;

import Actions.Common.AbstractPage;
import Interfaces.nopCommerce.EditAccountUI;
import Interfaces.nopCommerce.HomepageUI;
import org.openqa.selenium.WebDriver;

public class EditAccountPageObject extends AbstractPage {
    WebDriver driver;

    public EditAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

//    public void clickAddress(){
//        waitToClickable(driver,EditAccountUI.lnkAddress);
//        clickToElement(driver,EditAccountUI.lnkAddress);
//    }
//      public void clickOrder(){
//        waitToClickable(driver,EditAccountUI.lnkOrder);
//        clickToElement(driver,EditAccountUI.lnkOrder);
//    }
//      public void lnkChangePass(){
//        waitToClickable(driver,EditAccountUI.lnkChangePass);
//        clickToElement(driver,EditAccountUI.lnkChangePass);
//    }

        public void clickMenu(String linkName){
        clickToElementDynamic(driver,EditAccountUI.lnkMenu, linkName);
        sleep(2);
    }

}
