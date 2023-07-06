
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so n:");
        int input = sc.nextInt();
        int N = 2;
        while (N < input) {
            boolean flag = true;
            int i = 2;
            while (i <= Math.sqrt(N)) {
                if (N % i == 0) {
                    flag = false;
                    break;
                }
                i++;
            }
            if (flag) {
                System.out.print(N + " ");
            }
            N++;
        }

    }
}
