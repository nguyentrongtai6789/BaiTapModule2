import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array = new int[10];
        int max = array[0];
        int index = 1, total = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + "\t");
            if (array[i] > max) {
                max = array[i];
                index = i + 1;
            }
            total = total + array[i];

        }
        System.out.println("Gia tri lon nhat trong mang la: " + max + " tai vi tri thu " + index);
        System.out.println("Tong cac gia tri trong mang la: " + total);
    }
}
