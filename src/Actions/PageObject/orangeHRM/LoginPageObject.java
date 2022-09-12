package Actions.PageObject.orangeHRM;

import Actions.Common.AbstractPage;
import Interfaces.orangeHRM.LoginUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param userName
     */
    public void inputUserName(String userName) {
        waitToVisible(driver, LoginUI.txtUsername);
        sendKeytoElement(driver, LoginUI.txtUsername, userName);
    }

    /**
     * @param password
     */
    public void inputPassword(String password) {
        waitToVisible(driver, LoginUI.txtPassword);
        sendKeytoElement(driver, LoginUI.txtPassword, password);
    }


    public void submit() {
        waitToClickable(driver, LoginUI.btnSubmit);
        clickToElement(driver, LoginUI.btnSubmit);
    }

public void selectItem(String number){
        waitToClickable(driver, LoginUI.ddlNumber);
        selectItemCustomDropdown(driver, LoginUI.ddlNumber,LoginUI.ddlNumberItem,number);
}
}
