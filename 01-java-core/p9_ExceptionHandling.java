/**
 * Bài 9: Xử lý Ngoại lệ (Exception Handling - try, catch, finally, Checked vs
 * Unchecked)
 */

public class p9_ExceptionHandling {

    public static void main(String[] args) {
        System.out.println("=== 1. BẮT NGOẠI LỆ UNCHECKED (RUNTIME EXCEPTION) ===");
        try {
            int a = 10;
            int b = 0;
            int result = a / b; // Chia cho 0 sẽ ném ArithmeticException
            System.out.println("Kết quả: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Kích hoạt Catch: Không thể chia cho 0! (" + e.getMessage() + ")");
        } finally {
            System.out.println("Khối Finally luôn luôn được chạy!");
        }

        System.out.println("\n=== 2. THROW CUSTOM EXCEPTION ===");
        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Ngoại lệ tự bắn ra: " + e.getMessage());
        }
    }

    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Tuổi phải từ 18 trở lên để đăng ký!");
        }
        System.out.println("Tuổi hợp lệ!");
    }
}
