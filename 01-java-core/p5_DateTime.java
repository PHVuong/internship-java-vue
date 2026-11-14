
/**
 * Bài 7: Quản lý Ngày tháng (Date, SimpleDateFormat, LocalDate) & Methods
 */

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class p5_DateTime {

    public static void main(String[] args) {
        System.out.println("=== 1. SỬ DỤNG JAVA.UTIL.DATE & SIMPLEDATEFORMAT (CŨ) ===");
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Thời gian hiện tại: " + sdf.format(now));

        System.out.println("\n=== 2. SỬ DỤNG JAVA.TIME (JAVA 8+ PHỔ BIẾN HIỆN NAY) ===");
        LocalDate today = LocalDate.now();
        System.out.println("Hôm nay: " + today);
        System.out.println("Sau 10 ngày: " + today.plusDays(10));

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Định dạng LocalDateTime: " + currentDateTime.format(formatter));

        System.out.println("\n=== 3. KẾT QUẢ GỌI METHOD ===");
        int sum = calculateSum(15, 25);
        System.out.println("Tổng 15 + 25 = " + sum);
    }

    // Định nghĩa Method có tham số và giá trị trả về
    public static int calculateSum(int a, int b) {
        return a + b;
    }
}
