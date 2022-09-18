package Actions.PageObject.nopCommerce;

import Actions.Common.AbstractPage;
import Interfaces.nopCommerce.HomepageUI;
import org.openqa.selenium.WebDriver;

public class HomepageAction extends AbstractPage {
    WebDriver driver;

    public HomepageAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clicklnkRegister(String name){
        //waitToClickable(driver,HomepageUI.lnkRegister);
        clickToElementDynamic(driver,HomepageUI.lnkRegister, name);
    }
    public void clicklnkLogout(){
        waitToClickable(driver,HomepageUI.lnkLogout);
        clickToElement(driver,HomepageUI.lnkLogout);
    }
    public void clickMyAcc(){
        waitToClickable(driver, HomepageUI.lnkMyAcc);
        clickToElement(driver, HomepageUI.lnkMyAcc);
    }
}


// tạo 1 class UI, tìm xpath của từng element
// tạo 1 class action,pre.condition: extends AbstractPage. Viết 1 hàm khởi tạo và đặt tên hàm trùng vs tên class, sau đó viết các hàm action để thao tác vs từng element (
// tạo 1 class TCs, muốn sử dụng action của page nào thì new page đó lên
