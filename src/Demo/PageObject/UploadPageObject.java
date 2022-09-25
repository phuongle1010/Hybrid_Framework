package Demo.PageObject;

import Actions.Common.AbstractPage;
import Demo.Interfaces.UploadUI;
import org.openqa.selenium.WebDriver;

public class UploadPageObject extends AbstractPage {
    WebDriver driver;

    public UploadPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(String file) {
        uploadFile(driver, UploadUI.btnUpload, file);
    }

    public void uploadMultipleFile(String... files) {
        uploadMultiFile(driver, UploadUI.btnUpload, files);
    }

    public void clickStart(String value) {
        clickToElementDynamic(driver, UploadUI.btbStart, value);
    }
}
