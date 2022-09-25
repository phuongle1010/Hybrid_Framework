package Demo.PageObject;

import Actions.Common.AbstractPage;
import Demo.Interfaces.SoftAssertUI;
import org.openqa.selenium.WebDriver;

public class SoftAssertPageObject extends AbstractPage {
    WebDriver driver;

    public SoftAssertPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstname(String value) {
        waitToVisible(driver, SoftAssertUI.txtFirstName);
        sendKeytoElement(driver, SoftAssertUI.txtFirstName, value);
    }

    public void inputLastname(String value) {
        waitToVisible(driver, SoftAssertUI.txtLastName);
        sendKeytoElement(driver, SoftAssertUI.txtLastName, value);
    }

    public void inputEmail(String value) {
        waitToVisible(driver, SoftAssertUI.txtEmail);
        sendKeytoElement(driver, SoftAssertUI.txtEmail, value);
    }

    public void inputPassword(String value) {
        waitToVisible(driver, SoftAssertUI.txtPassword);
        sendKeytoElement(driver, SoftAssertUI.txtPassword, value);
    }

    public void inputConfirmPassword(String value) {
        waitToVisible(driver, SoftAssertUI.txtConfirmPassword);
        sendKeytoElement(driver, SoftAssertUI.txtConfirmPassword, value);
    }

    public void clickRegister() {
        waitToClickable(driver, SoftAssertUI.btnRegister);
        clickToElement(driver, SoftAssertUI.btnRegister);
    }
    public String verifyMessage(String msg){
        return getTextDynamic(driver,SoftAssertUI.lblMessage,msg);
    }
}
