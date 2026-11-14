
/**
 * Bài 12: Java Collection Framework (List - ArrayList, Set - HashSet, Map - HashMap)
 */

import java.util.*;

public class p12_CollectionFramework {

    public static void main(String[] args) {
        System.out.println("=== 1. LIST (ARRAYLIST - DỮ LIỆU CÓ THỨ TỰ, CHO PHÉP TRÙNG LẶP) ===");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Spring Boot");
        list.add("Vue.js");
        list.add("Java"); // Trùng lặp
        System.out.println("Danh sách List: " + list);

        System.out.println("\n=== 2. SET (HASHSET - KHÔNG CHỨA DẦU VẾT TRÙNG LẶP) ===");
        Set<String> set = new HashSet<>(list); // Chuyển List sang Set để lọc phần tử trùng
        System.out.println("Danh sách Set (đã lọc trùng): " + set);

        System.out.println("\n=== 3. MAP (HASHMAP - LƯU CẶP KEY - VALUE) ===");
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("Nguyễn Văn A", 95);
        studentScores.put("Trần Thị B", 88);
        studentScores.put("Lê Văn C", 92);

        System.out.println("Điểm của Nguyễn Văn A: " + studentScores.get("Nguyễn Văn A"));

        System.out.println("\nDuyệt qua các phần tử trong Map:");
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            System.out.println("- Học viên: " + entry.getKey() + " | Điểm: " + entry.getValue());
        }
    }
}
