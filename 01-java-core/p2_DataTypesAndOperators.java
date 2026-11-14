/**
 * Bài 1 & 2: Tổng quan về Cú pháp, Biến, Access Modifier và Comments trong Java
 * 
 * Access Modifiers (Phạm vi truy cập):
 * - public: Truy cập được từ bất kỳ đâu.
 * - protected: Truy cập trong cùng package hoặc class con khác package.
 * - default (không ghi gì): Truy cập trong cùng package.
 * - private: Chỉ truy cập được bên trong chính class đó.
 */

public class p2_DataTypesAndOperators {

    public static void main(String[] args) {
        System.out.println("=== 1. KIỂU DỮ LIỆU NGUYÊN THỦY (PRIMITIVE DATA TYPES) ===");
        byte b = 100;
        short s = 5000;
        int i = 100000;
        long l = 15000000000L; // Cần chữ L ở cuối
        float f = 5.75f; // Cần chữ f ở cuối
        double d = 19.99;
        boolean kt = true;
        char grade = 'A';

        System.out.println("int: " + i + ", double: " + d + ", boolean: " + kt + ", char: " + grade);

        System.out.println("\n=== 2. SPECIAL ESCAPE SEQUENCES (KÝ TỰ ĐẶC BIỆT) ===");
        System.out.println("Dòng 1\nDòng 2 (Xuống dòng con \\n)");
        System.out.println("Cột 1\tCột 2 (Tab con \\t)");
        System.out.println("Trích dẫn: \"Java Core Training\"");

        System.out.println("\n=== 3. TOÁN TỬ (OPERATORS) ===");
        int x = 15, y = 4;
        System.out.println("Cộng: " + (x + y));
        System.out.println("Chia lấy phần nguyên: " + (x / y));
        System.out.println("Chia lấy phần dư (%): " + (x % y));

        // Toán tử so sánh & logic
        boolean check = (x > y) && (y > 0);
        System.out.println("Kế quả so sánh (x > y) AND (y > 0): " + check);
    }
}
