import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array;
        int size;
        do {
            System.out.println("Nhap vao kich thuoc cua mang:");
            size = input.nextInt();
            if (size <= 0) {
                System.out.println("Kich thuoc khong ho tro");
            }
        }
        while (size <= 0);
        array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhap vao gia tri tai vi tri thu " + (i + 1) + ": ");
            array[i] = input.nextInt();
        }
        System.out.println("Mang vua nhap la:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
