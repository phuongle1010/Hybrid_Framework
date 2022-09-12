package Actions.PageObject.nopCommerce;

import Actions.Common.AbstractPage;
import Interfaces.nopCommerce.RegisterUI;
import org.openqa.selenium.WebDriver;

public class RegisterAction extends AbstractPage {
    WebDriver driver;

    public RegisterAction(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstname(String value) {
        waitToVisible(driver, RegisterUI.txtFirstName);
        sendKeytoElement(driver, RegisterUI.txtFirstName, value);
    }

    public void inputLastname(String value) {
        waitToVisible(driver, RegisterUI.txtLastName);
        sendKeytoElement(driver, RegisterUI.txtLastName, value);
    }

    public void inputEmail(String value) {
        waitToVisible(driver, RegisterUI.txtEmail);
        sendKeytoElement(driver, RegisterUI.txtEmail, value);
    }

    public void inputPassword(String value) {
        waitToVisible(driver, RegisterUI.txtPassword);
        sendKeytoElement(driver, RegisterUI.txtPassword, value);
    }

    public void inputConfirmPassword(String value) {
        waitToVisible(driver, RegisterUI.txtConfirmPassword);
        sendKeytoElement(driver, RegisterUI.txtConfirmPassword, value);
    }

    public void clickRegister() {
        waitToClickable(driver, RegisterUI.btnRegister);
        clickToElement(driver, RegisterUI.btnRegister);
    }
}
