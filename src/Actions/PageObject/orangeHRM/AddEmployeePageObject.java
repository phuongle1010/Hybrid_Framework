package Actions.PageObject.orangeHRM;

import Actions.Common.AbstractPage;
import Interfaces.orangeHRM.AddEmployeeUI;
import org.openqa.selenium.WebDriver;

public class AddEmployeePageObject extends AbstractPage {
    WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddEployeelnk(){
        waitToClickable(driver,AddEmployeeUI.lnkAddEmployee);
        clickToElement(driver,AddEmployeeUI.lnkAddEmployee);
    }

    public void inputFirstname(String firstname) {
        waitToVisible(driver, AddEmployeeUI.txtFirstName);
        sendKeytoElement(driver, AddEmployeeUI.txtFirstName, firstname);
        sleep(2);
    }
    public void inputMiddlenamr(String middlename){
        waitToVisible(driver,AddEmployeeUI.txtMiddleName);
    sendKeytoElement(driver,AddEmployeeUI.txtMiddleName,middlename);
        sleep(2);
    }
    public void inputLastname(String lastname){
        waitToVisible(driver,AddEmployeeUI.txtLastName);
        sendKeytoElement(driver,AddEmployeeUI.txtLastName,lastname);
        sleep(2);
    }
    public void clickSave(){
        waitToClickable(driver,AddEmployeeUI.btnSubmit);
        clickToElement(driver,AddEmployeeUI.btnSubmit);
    }

}
