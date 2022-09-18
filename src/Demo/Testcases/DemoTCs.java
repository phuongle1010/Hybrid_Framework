package Demo.Testcases;

import Actions.Common.AbstractTest;
import Demo.PageObject.DemoPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoTCs extends AbstractTest {
    WebDriver driver;
    DemoPageObject demoPageObject;

    @Parameters({"browsers","url"})
    @BeforeClass
    public void beforeClass(String browsers, String url){
        driver = getBrowser(browsers, url);
        demoPageObject = new DemoPageObject(driver);
    }
    @Test
    public void TC_01_VerifyValueItem(){
        demoPageObject.verifyValueItem("Angelica Ramos","Chief Executive Officer (CEO)","London","47");
    }
    @AfterClass
    public void afterClass(){}
}
