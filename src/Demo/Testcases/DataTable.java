package Demo.Testcases;

import Actions.Common.AbstractTest;
import Demo.PageObject.DataTablePageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.security.Policy;

public class DataTable extends AbstractTest {
    WebDriver driver;
    DataTablePageObject dataTablePageObject;

    @Parameters({"browsers","url"})
    @BeforeClass()
     public void beforeClass(String browser,String url){
        driver = getBrowser(browser, url);
        dataTablePageObject = new DataTablePageObject(driver);
    }

    @Test
    public void TC_01_inputArtist(){
        dataTablePageObject.clickAdd();
        dataTablePageObject.clickAdd();
//        dataTablePageObject.inputValueTbl("hoalacanh");
        dataTablePageObject.inputValue("2","Year","2000");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
