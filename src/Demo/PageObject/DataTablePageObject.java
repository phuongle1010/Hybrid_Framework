package Demo.PageObject;

import Actions.Common.AbstractPage;
import Demo.Interfaces.DataTableUI;
import org.openqa.selenium.WebDriver;

public class DataTablePageObject extends AbstractPage {
    WebDriver driver;

    public DataTablePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAdd(){
        waitToClickable(driver, DataTableUI.btn);
        clickToElement(driver, DataTableUI.btn);
    }

//    public void inputValueTbl(String value){
//        waitToVisible(driver,DataTableUI.tblArtist);
//        sendKeytoElement(driver,DataTableUI.tblArtist,value);
//    }

    public void inputValue(String rowNumber, String columnName, String inputValue){
        // String.valueOf: convert data types khác sang String
        String columnNameNumber = String.valueOf(getSizeDynamic(driver, DataTableUI.tblColumnName, columnName) + 1);
        //table/tbody/tr[rowNumber]/td[columnNameNumber]/input
        waitToVisibleDynamic(driver, DataTableUI.tblCellPosition, rowNumber, columnNameNumber);
        sendKeysToElementDynamic(driver,DataTableUI.tblCellPosition, inputValue, rowNumber, columnNameNumber);
    }
}
