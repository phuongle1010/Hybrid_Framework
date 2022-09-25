package Testcases.orangeHRM;

import Actions.Common.AbstractTest;
import Actions.PageObject.orangeHRM.AddEmployeePageObject;
import Actions.PageObject.orangeHRM.EditEmployeePageObject;
import Actions.PageObject.orangeHRM.LoginPageObject;
import Actions.PageObject.orangeHRM.SearchEmloyeePageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddEmployee extends AbstractTest {
    WebDriver driver;
    LoginPageObject loginPageObject;
    AddEmployeePageObject addEmployeePageObject;
    SearchEmloyeePageObject searchEmloyeePageObject;
    EditEmployeePageObject editEmployeePageObject;

    @Parameters({"browsers", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName, url);
        loginPageObject = new LoginPageObject(driver);
        addEmployeePageObject = new AddEmployeePageObject(driver);
        searchEmloyeePageObject = new SearchEmloyeePageObject(driver);
        editEmployeePageObject = new EditEmployeePageObject(driver);
    }

    @Test
    public void TC_01_Login() {
        loginPageObject.inputUserName("Admin");
        loginPageObject.inputPassword("admin123");
        loginPageObject.submit();
    }

    @Test
    public void TC_02_AddEmployee() {
        addEmployeePageObject.clickAddEployeelnk();
        addEmployeePageObject.inputFirstname("Wanda");
        addEmployeePageObject.inputMiddlenamr("van");
        addEmployeePageObject.inputLastname("da");
        addEmployeePageObject.clickSave();
    }

    @Test
    public void TC_03_SearchEmployee() {
        searchEmloyeePageObject.clicklnkEmployeelist();
        searchEmloyeePageObject.inputEmloyeeId("0250");
        loginPageObject.submit();
    }

    @Test
    public void TC_04_EditEmployee() {
        editEmployeePageObject.clickbtnEdit();
        editEmployeePageObject.clicklnkJob();
        editEmployeePageObject.selectDdlJobTitle("QA Lead");
        editEmployeePageObject.selectDdlSubUnit("Engineering");
        loginPageObject.submit();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
