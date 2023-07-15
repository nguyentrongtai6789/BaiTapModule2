package bai_2;

import java.time.LocalDate;
import java.util.Scanner;

public class MaterialProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        MaterialManage materialManage = new MaterialManage();
        do {
            materialManage.displayMaterial();
            System.out.println("Menu:");
            System.out.println("1. Add a material. ");
            System.out.println("2. Edit a material. ");
            System.out.println("3. Delete a material. ");
            System.out.println("4. Discount material. ");
            System.out.println("5. The money difference due to discount: ");
            System.out.println("0. Exit.");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    materialManage.addMaterial();
                    break;
                case 2:
                    materialManage.editMaterial();
                    break;
                case 3:
                    materialManage.deleteMaterial();
                    break;
                case 4:
                    materialManage.discount();
                    break;
                case 5:
                    materialManage.differenceMoney();
                    break;
            }

        } while (choice != 0);

    }
}
