package Testcases.nopCommerce;

import Actions.Common.AbstractTest;
import Actions.PageObject.nopCommerce.EditAccountPageObject;
import Actions.PageObject.nopCommerce.HomepageAction;
import Actions.PageObject.nopCommerce.RegisterAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Register extends AbstractTest {
    WebDriver driver;
    RegisterAction registerAction;
    HomepageAction homepageAction;
    EditAccountPageObject editAccountPageObject;

    @Parameters("browsers")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowser(browserName);
        registerAction = new RegisterAction(driver);
        homepageAction = new HomepageAction(driver);
        editAccountPageObject = new EditAccountPageObject(driver);
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    public void TC_01_Register() {
        homepageAction.clicklnkRegister("Register");
        registerAction.inputFirstname("Khoamama");
        registerAction.inputLastname("cancer");
        registerAction.inputEmail(generatorEmail());
        registerAction.inputPassword("123456a");
        registerAction.inputConfirmPassword("123456a");
        registerAction.clickRegister();
        homepageAction.clicklnkLogout();
    }

    @Test
    public void TC_02_EditAcc() {
        homepageAction.clickMyAcc();
        editAccountPageObject.clickMenu("Orders");
        editAccountPageObject.clickMenu("Change password");
        editAccountPageObject.clickMenu("Addresses");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
