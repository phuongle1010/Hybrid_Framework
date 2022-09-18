package Actions.PageObject.orangeHRM;

import Actions.Common.AbstractPage;
import Interfaces.orangeHRM.EditEmployeeUI;
import org.openqa.selenium.WebDriver;

public class EditEmployeePageObject extends AbstractPage {
    WebDriver driver;

    public EditEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickbtnEdit() {
        waitToClickable(driver, EditEmployeeUI.btnEdit);
        clickToElement(driver, EditEmployeeUI.btnEdit);
    }

    public void clicklnkJob() {
        waitToClickable(driver, EditEmployeeUI.lnkJob);
        clickToElement(driver, EditEmployeeUI.lnkJob);
    }

    public void selectDdlJobTitle(String jobtitle) {
        waitToVisible(driver, EditEmployeeUI.ddlJobTitle);
        selectItemCustomDropdown(driver, EditEmployeeUI.ddlJobTitle, EditEmployeeUI.ddlJobTitleItem, jobtitle);
        sleep(5);
    }

    public void selectDdlSubUnit(String subUnit) {
        waitToVisible(driver, EditEmployeeUI.ddlSubUnit);
        selectItemCustomDropdown(driver, EditEmployeeUI.ddlSubUnit, EditEmployeeUI.ddlSubUnitItem, subUnit);
        sleep(5);
    }
}
