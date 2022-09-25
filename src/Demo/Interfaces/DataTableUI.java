package Demo.Interfaces;

public class DataTableUI {
    public static final String btn = "//button[@title='Append Row']";
    public static final String tblColumnName ="//td[text()='%s']/preceding-sibling::td"; // tên cột phía trước cột muốn lấy (phải như này mới lấy được position của column muốn lấy)
    public static final String tblCellPosition = "//table/tbody/tr[%s]/td[%s]//input"; /// vị trí của dòng muốn lấy
}
