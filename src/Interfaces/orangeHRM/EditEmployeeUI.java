package Interfaces.orangeHRM;

public class EditEmployeeUI {
    public static final String btnEdit = "//i[contains(@class,'bi-pencil-fill')]/parent::button";
    public static final String lnkJob = "//a[text()='Job']";
    public static final String  ddlJobTitle ="//label[text()='Job Title']//parent::div/following-sibling::div";
    public static final String  ddlJobTitleItem ="//label[text()='Job Title']/parent::div//following-sibling::div//div[@role='option']";
    public static final String ddlSubUnit = "//label[text()='Sub Unit']//parent::div/following-sibling::div";
    public static final String ddlSubUnitItem = "//label[text()='Sub Unit']//parent::div//following-sibling::div//div[@role='option']";
}
