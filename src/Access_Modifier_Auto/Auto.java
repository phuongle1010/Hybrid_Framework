package Access_Modifier_Auto;

public class Auto {
    /* Access modifier (phạm vi truy cập) : kiểm tra 1 Class nằm trong hoặc ngoài package có thể truy cập vào 1 class khác hay không?
    * gồm 4 loại: private - default - protected - public
    * private: chỉ sử dụng được cho chính Class đó
    * Default: được sử dụng cho Class chính nó hoặc những Class khác nằm trong cùng 1 Package
    * Protected: tương tự Default nhưng có thể work với package khác bởi class con (extends từ class cha)
    * Public: có thể dùng cho toàn bộ Class thuộc  nhiều Package (không cần extends vẫn dùng được)
    * */

    // Private
    // thuộc tính: property / variable
    private String name = "CerKhum";
    // phương thức: method / funct
    // getter
    private String getName(){
        return name;
    }
    // setter
    private void setName(String userName){
        this.name = userName;
    }

    // default
    String phone = "0905243286";

    String getPhone(){
        return phone;
    }
    public void setPhone(String myPhone){
        this.phone = myPhone;
    }

    // protected
    protected String email = "haha01@yopmail.com";
    protected String getEmail(){
        return email;
    }
    protected void setEmail(String userEmail){
        this.email = userEmail;
    }
    // public
    public String pass = "123456a";

    public String getPass(){
        return pass;
    }
    public void setPass(String password){
        this.pass = password;
    }

    public static void main(String[] args) {
        Auto auto = new Auto();
        System.out.println(auto.name);
        System.out.println(auto.getName());
        auto.setName("KhoaKKK");
        System.out.println(auto.getName());

        System.out.println(auto.phone);
        System.out.println(auto.getPhone());
        auto.setPhone("19001000");
        System.out.println(auto.getPhone());

        System.out.println(auto.email);
        System.out.println(auto.getEmail());
        auto.setEmail("123@yopmail.com");
        System.out.println(auto.getEmail());

        System.out.println(auto.pass);
        System.out.println(auto.getPass());

    }
}
