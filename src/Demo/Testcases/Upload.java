package Demo.Testcases;

import Actions.Common.AbstractTest;
import Demo.PageObject.UploadPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Upload extends AbstractTest {
    WebDriver driver;
    UploadPageObject uploadPageObject;

    String img01 = "Nature01.jpg";
    String img02 = "Nature02.jpg";
    String img03 = "Nature03.jpg";
    String locationProject = System.getProperty("user.dir");
    String fileName01 = locationProject + "\\uploadFile\\" + img01;


    @Parameters({"browsers", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName, url);
        uploadPageObject = new UploadPageObject(driver);
    }

    @Test(enabled = false)
    public void TC_01_uploadAFile() {
        uploadPageObject.uploadFile(fileName01);
        uploadPageObject.clickStart(fileName01);
    }

    @Test(enabled = true)
    public void TC_02_uploadMultiFile() {
        uploadPageObject.uploadMultipleFile(img01, img02, img03);
        uploadPageObject.sleep(5);
        uploadPageObject.clickStart(img01);
        uploadPageObject.clickStart(img02);
        uploadPageObject.clickStart(img03);
    }
}
