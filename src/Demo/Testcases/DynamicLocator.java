package Demo.Testcases;

import Actions.Common.AbstractTest;
import Demo.PageObject.DynamicPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DynamicLocator extends AbstractTest {
    WebDriver driver;
    DynamicPageObject dynamicPageObject;

    @Parameters({"browsers","url"})
    @BeforeClass
    public void beforeClass(String browsers, String url){
        driver = getBrowser(browsers, url);
        dynamicPageObject = new DynamicPageObject(driver);
    }
    @Test
    public void TC_01_VerifyValueItem(){
        dynamicPageObject.verifyValueItem("Angelica Ramos","Chief Executive Officer (CEO)","London","47");
    }
    @AfterClass
    public void afterClass(){}
}
