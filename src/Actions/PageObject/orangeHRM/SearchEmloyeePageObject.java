package Actions.PageObject.orangeHRM;

import Actions.Common.AbstractPage;
import Interfaces.orangeHRM.SearchEmployeeUI;
import org.openqa.selenium.WebDriver;

public class SearchEmloyeePageObject extends AbstractPage {
    WebDriver driver;

    public SearchEmloyeePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clicklnkEmployeelist(){
        waitToClickable(driver, SearchEmployeeUI.lnkEmployeelist);
        clickToElement(driver,SearchEmployeeUI.lnkEmployeelist);
    }
    public void inputEmloyeeId(String empleeId){
        waitToVisible(driver,SearchEmployeeUI.txtEmployeeId);
        sendKeytoElement(driver,SearchEmployeeUI.txtEmployeeId,empleeId);
        sleep(5);
    }
}
