
/**
 * Bài 8: Xử lý Đọc và Ghi File (File I/O) sử dụng BufferedReader & BufferedWriter
 */

import java.io.*;

public class p8_FileIO {

    public static void main(String[] args) {
        String fileName = "sample_output.txt";

        System.out.println("=== 1. GHI DỮ LIỆU VÀO FILE ===");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Báo cáo thực tập Java Core\n");
            writer.write("Đã hoàn thành phần File I/O.\n");
            writer.write("Ngày ghi file: 2026\n");
            System.out.println("Ghi file thành công: " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }

        System.out.println("\n=== 2. ĐỌC DỮ LIỆU TỪ FILE ===");
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[READ]: " + line);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
