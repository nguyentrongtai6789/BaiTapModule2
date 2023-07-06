import java.util.Scanner;

public class MainStudent {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name, className;
        int age;
        System.out.print("Nhap vao ten cua student1: ");
        name = input.nextLine();
        System.out.print("Nhap tuoi cua student1: ");
        age = input.nextInt();
        input.nextLine();
        System.out.print("Nhap ten lop cua student1: ");
        className = input.nextLine();
        Student student1 = new Student(name, age, className);
        System.out.print("Student1 co ten la: " + student1.getName() + ", " +
                student1.getAge() + " tuoi, " + "hoc lop " + student1.getClassName());
    }
}
