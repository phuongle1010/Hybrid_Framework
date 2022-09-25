package Demo.Testcases;

import Actions.Common.AbstractTest;
import Actions.PageObject.nopCommerce.HomePagePageObject;
import Demo.PageObject.SoftAssertPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo extends AbstractTest {
    WebDriver driver;
    SoftAssertPageObject softAssertPageObject;
    HomePagePageObject homePagePageObject;
    SoftAssert softAssert;

    @Parameters({"browsers", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName, url);
        softAssertPageObject = new SoftAssertPageObject(driver);
        homePagePageObject = new HomePagePageObject(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void TC_01_Register() {
        homePagePageObject.clicklnkRegister("Register");
        softAssertPageObject.inputFirstname("Khoamama");
        softAssertPageObject.inputLastname("cancer");
        softAssertPageObject.inputEmail(generatorEmail());
        softAssertPageObject.inputPassword("123456a");
        softAssertPageObject.inputConfirmPassword("123456a");
        softAssertPageObject.clickRegister();
        // hard assert
        //Assert.assertEquals(softAssertPageObject.verifyMessage("Your registration completed"),"Your registration completed");
        // soft assert
        softAssert.assertEquals(softAssertPageObject.verifyMessage("Your registration completed"),"Your registration completed");
        softAssert.assertAll();
        homePagePageObject.clicklnkLogout();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}