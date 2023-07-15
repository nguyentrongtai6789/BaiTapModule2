package bai_2;

import java.awt.geom.QuadCurve2D;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MaterialManage {
    Scanner scanner = new Scanner(System.in);
    Material meat1 = new Meat("001", "Thịt bò", LocalDate.of(2023, 7, 10), 55000, 110);
    Material meat2 = new Meat("002", "Thịt lợǹ", LocalDate.of(2023, 7, 11), 66000, 120);
    Material meat3 = new Meat("003", "Thịt gà", LocalDate.of(2023, 7, 12), 77000, 130);
    Material meat4 = new Meat("004", "Thịt chó", LocalDate.of(2023, 7, 9), 88000, 140);
    Material meat5 = new Meat("005", "Thịt cá mập", LocalDate.of(2023, 7, 8), 99000, 150);
    Material flour1 = new CrispyFlour("006", "Ajinomoto", LocalDate.of(2022, 9, 14), 11000, 160);
    Material flour2 = new CrispyFlour("007", "Vedan", LocalDate.of(2022, 10, 14), 12000, 170);
    Material flour3 = new CrispyFlour("008", "Chinsu", LocalDate.of(2022, 8, 14), 13000, 180);
    Material flour4 = new CrispyFlour("009", "A-one", LocalDate.of(2022, 11, 14), 14000, 190);
    Material flour5 = new CrispyFlour("010", "Lotte", LocalDate.of(2022, 12, 14), 15000, 200);
    Material[] materials = {meat1, meat2, meat3, meat4, meat5, flour1, flour2, flour3, flour4, flour5};
    Double money1 = 0.0;
    Double money2 = 0.0;
    public void displayMaterial() {
        System.out.println("The all materials of the shop:");
        for (int i = 0; i < materials.length; i++) {
            System.out.println((i + 1) + ". " + materials[i].toString());
        }
    }

    public void addMaterial() {
        int select;
        System.out.println("Select the type of new material: ");
        System.out.println("1. Meat");
        System.out.println("2. Flour");
        select = Integer.parseInt(scanner.nextLine());
        switch (select) {
            case 1:
                System.out.println("Enter name of the new meat: ");
                String name = scanner.nextLine();
                System.out.println("Enter id of the new meat: ");
                String id = scanner.nextLine();
                System.out.println("Enter the manufacturing of the new meat: (yyyy-MM-dd):");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate manufacturing = LocalDate.parse(scanner.nextLine(), formatter);
                System.out.println("Enter the cost of the new meat: ");
                int cost = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the weight of the new meat: ");
                int weight = Integer.parseInt(scanner.nextLine());
                Material newMaterial = new Meat(id, name, manufacturing, cost, weight);
                Material[] newMaterials = new Material[materials.length + 1];
                System.arraycopy(materials, 0, newMaterials, 0, materials.length);
                newMaterials[newMaterials.length - 1] = newMaterial;
                materials = newMaterials;
                break;
            case 2:
                System.out.println("Enter name of the new flour: ");
                String name2 = scanner.nextLine();
                System.out.println("Enter id of the new flour: ");
                String id2 = scanner.nextLine();
                System.out.println("Enter the manufacturing of the new flour: (yyyy-MM-dd):");
                LocalDate manufacturing2 = LocalDate.parse(scanner.nextLine());
                System.out.println("Enter the cost of the new flour: ");
                int cost2 = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the quantity of the new flour: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                Material newMaterial2 = new CrispyFlour(id2, name2, manufacturing2, cost2, quantity);
                Material[] newMaterials2 = new Material[materials.length + 1];
                System.arraycopy(materials, 0, newMaterials2, 0, materials.length);
                newMaterials2[newMaterials2.length - 1] = newMaterial2;
                materials = newMaterials2;
                break;
        }
    }

    public void deleteMaterial() {
        System.out.println("Enter the id of the material to delete: ");
        String id = scanner.nextLine();
        boolean flag = false;
        Material[] newMaterials = new Material[materials.length - 1];
        for (int i = 0; i < materials.length; i++) {
            if (materials[i].getId().equals(id)) {
                flag = true;
                System.arraycopy(materials, 0, newMaterials, 0, i);
                for (int j = i; j < newMaterials.length; j++) {
                    newMaterials[j] = materials[j + 1];
                }
                break;
            }
        }

        if(flag) {
            materials = newMaterials;
        }
        else {
            System.out.println("The id no exist.");
        }
    }
    public void editMaterial() {
        System.out.println("Enter the id of the material to edit:");
        String idEnterToEdit = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < materials.length; i++) {
            if (materials[i].getId().equals(idEnterToEdit)){
                flag = true;
                if (materials[i] instanceof Meat) {
                    System.out.println("Enter the new name of the meat:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the new id of the meat:");
                    String newId = scanner.nextLine();
                    System.out.println("Enter the new manufacturing date (yyyy-MM-dd) of the meat:");
                    LocalDate newDate = LocalDate.parse(scanner.nextLine());
                    System.out.println("Enter the new cost of the meat:");
                    int newCost = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the new weight of the meat:");
                    int newWeight = Integer.parseInt(scanner.nextLine());
                    Material newMeat = new Meat(newId, newName, newDate, newCost, newWeight);
                    materials[i] = newMeat;
                    break;
                }
                else {
                    System.out.println("Enter the new name of the flour:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter the new id of the flour:");
                    String newId = scanner.nextLine();
                    System.out.println("Enter the new manufacturing date (yyyy-MM-dd) of the flour:");
                    LocalDate newDate = LocalDate.parse(scanner.nextLine());
                    System.out.println("Enter the new cost of the flour:");
                    int newCost = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the new quantity of the flour:");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    Material newFlour = new CrispyFlour(newId, newName, newDate, newCost, newQuantity);
                    materials[i] = newFlour;
                    break;
                }
            }
        }
        if (!flag) {
            System.out.println("The id no exist.");
        }
    }
    public void discount() {
        for(Material material: materials) {
            if (material instanceof CrispyFlour) {
                CrispyFlour newMaterial = (CrispyFlour) material;
                System.out.println("The cost of " + material.getName() + " after discount: " + newMaterial.getRealMoney());
                money2 += newMaterial.getRealMoney();
            }
            if (material instanceof Meat) {
                Meat newMeat = (Meat) material;
                System.out.println("The cost of " + material.getName() + " after discount: " + newMeat.getRealMoney());
                money2 += newMeat.getRealMoney();
            }
        }
    }
    public void differenceMoney() {
        for (Material material: materials) {
            money1 += material.getCost();
        }
        System.out.println("The money difference due to discount: " + (money1-money2));
    }
}

