/**
 * Bài 5: Vòng lặp (Loops) và Wrapper Classes (Integer, Double,
 * Autoboxing/Unboxing)
 */

public class p3_LoopsAndWrapperClasses {

    public static void main(String[] args) {
        System.out.println("=== 1. CÁC VÒNG LẶP (LOOPS) ===");

        // Vòng lặp for
        System.out.print("For loop: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Vòng lặp while
        System.out.print("While loop: ");
        int count = 1;
        while (count <= 3) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();

        System.out.println("\n=== 2. WRAPPER CLASSES & AUTOBOXING/UNBOXING ===");
        // Autoboxing: Tự động chuyển primitive -> Wrapper Object
        Integer intObj = 100; // int -> Integer
        Double doubleObj = 45.67;

        // Unboxing: Tự động chuyển Wrapper Object -> primitive
        int primitiveInt = intObj;

        // Một số utility method hữu ích của Wrapper class
        String numStr = "250";
        int parsedNum = Integer.parseInt(numStr); // Chuyển String thành int
        System.out.println("Chuỗi \"250\" sau khi parse thành int + 50 = " + (parsedNum + 50));
        System.out.println("Giá trị Max của Integer: " + Integer.MAX_VALUE);
    }
}
