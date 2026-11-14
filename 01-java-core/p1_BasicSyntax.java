/**
 * Bài 1 & 2: Tổng quan về Cú pháp, Biến, Access Modifier và Comments trong Java
 * 
 * Access Modifiers (Phạm vi truy cập):
 * - public: Truy cập được từ bất kỳ đâu.
 * - protected: Truy cập trong cùng package hoặc class con khác package.
 * - default (không ghi gì): Truy cập trong cùng package.
 * - private: Chỉ truy cập được bên trong chính class đó.
 */

public class p1_BasicSyntax {

    // Biến instance (Instance Variables)
    public String publicVar = "Public Variable - Mọi nơi đều truy cập được";
    protected String protectedVar = "Protected Variable - Cùng package hoặc class con";
    String defaultVar = "Default Variable - Cùng package";
    private String privateVar = "Private Variable - Chỉ trong Class này";

    // Hằng số (Constants)
    public static final double PI = 3.14159;

    public static void main(String[] args) {
        // Biến cục bộ (Local Variable)
        int number = 10;

        System.out.println("=== 1. IN RA MÀN HÌNH ===");
        System.out.println("Giá trị biến number: " + number);
        System.out.println("Hằng số PI: " + PI);

        // Khởi tạo đối tượng
        p1_BasicSyntax obj = new p1_BasicSyntax();
        obj.demoAccessModifiers();
    }

    public void demoAccessModifiers() {
        System.out.println("\n=== 2. THỬ NGHỆM ACCESS MODIFIERS ===");
        System.out.println(publicVar);
        System.out.println(protectedVar);
        System.out.println(defaultVar);
        System.out.println(privateVar);
    }
}
