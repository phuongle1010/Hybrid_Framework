package Access_Modifier_Auto;

public class Auto01 {
    public static void main(String[] args) {
        Auto auto = new Auto();
        System.out.println(auto.phone);
        System.out.println(auto.getPhone());
        auto.setPhone("hahaha");
        System.out.println(auto.getPhone());


    }
}
