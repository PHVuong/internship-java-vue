/**
 * Bài 10 & 11: Lập trình Hướng đối tượng OOP (Inheritance, Polymorphism,
 * Abstract Class & Interface)
 */

// 1. Interface
interface Workable {
    void doWork(); // Method abstract ngầm định
}

// 2. Abstract Class
abstract class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Abstract method (Bắt buộc class con override)
    public abstract double calculateSalary();
}

// 3. Class con Kế thừa (Inheritance) & Triển khai Interface (Implements)
class Developer extends Employee implements Workable {
    private double bonus;

    public Developer(String name, double baseSalary, double bonus) {
        super(name, baseSalary); // Gọi constructor của class cha
        this.bonus = bonus;
    }

    // Overriding (Ghi đè phương thức - Đa hình)
    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void doWork() {
        System.out.println(getName() + " đang lập trình Java Spring Boot...");
    }

    // Overloading (Nạp chồng phương thức - Đa hình tại compile-time)
    public void codeTask(String taskName) {
        System.out.println(getName() + " đang làm task: " + taskName);
    }

    public void codeTask(String taskName, int hours) {
        System.out.println(getName() + " đang làm task " + taskName + " trong " + hours + " giờ.");
    }
}

public class p10_11_OOPPrinciples {

    public static void main(String[] args) {
        System.out.println("=== DEMO OOP: INHERITANCE, POLYMORPHISM, ABSTRACT & INTERFACE ===");

        Developer dev = new Developer("Nguyễn Văn A", 15000000, 3000000);

        dev.doWork();
        dev.codeTask("Tích hợp REST API");
        dev.codeTask("Tối ưu CSDL", 4);

        System.out
                .println("Tổng lương của " + dev.getName() + ": " + String.format("%,.0f VNĐ", dev.calculateSalary()));
    }
}
