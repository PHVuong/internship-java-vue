
/**
 * Bài 6: Xử lý Ký tự (Character), Chuỗi (String, StringBuilder) và Mảng (Arrays)
 */

import java.util.Arrays;

public class p4_StringAndArrays {

    public static void main(String[] args) {
        System.out.println("=== 1. MẢNG (ARRAYS) ===");
        int[] numbers = { 5, 2, 8, 1, 9 };
        System.out.println("Mảng ban đầu: " + Arrays.toString(numbers));

        // Sắp xếp mảng
        Arrays.sort(numbers);
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(numbers));

        System.out.println("\n=== 2. XỬ LÝ CHUỖI (STRING) ===");
        String str = "  Java Programming Junior  ";
        System.out.println("Độ dài: " + str.length());
        System.out.println("Cắt khoảng trắng: \"" + str.trim() + "\"");
        System.out.println("Chữ hoa: " + str.toUpperCase());
        System.out.println("Thay thế: " + str.replace("Junior", "Developer"));

        System.out.println("\n=== 3. STRINGBUILDER (TỐI ƯU HIỆU NĂNG THAO TÁC CHUỖI) ===");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.append(" 2026");
        System.out.println("Kết quả StringBuilder: " + sb.toString());
    }
}
