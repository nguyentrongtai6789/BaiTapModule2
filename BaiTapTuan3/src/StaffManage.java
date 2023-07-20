import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StaffManage {
    Staff staff1 = new FullTimeStaff("John", 27, "0369911511", "abc@123", new Address(), 2_000_000, 1_000_000, 3_000_000);
    Staff staff2 = new FullTimeStaff("Wick", 27, "0369911511", "abc@12", new Address(), 2_000_000, 1_500_000, 4_500_000);
    Staff staff3 = new FullTimeStaff("Sam", 27, "0369911511", "abc@123", new Address(), 2_000_000, 1_000_000, 4_000_000);
    Staff staff4 = new FullTimeStaff("Zoe", 27, "0369911511", "abc@123", new Address(), 1_000_000, 2_000_000, 5_000_000);
    Staff staff5 = new FullTimeStaff("James", 27, "0369911511", "abc@123", new Address(), 1_000_000, 1_000_000, 7_000_000);
    Staff staff6 = new PartTimeStaff("Han", 25, "0123456789", "def@456", new Address(), 50);
    Staff staff7 = new PartTimeStaff("Map", 25, "0123456789", "def@456", new Address(), 55);
    Staff staff8 = new PartTimeStaff("Dick", 25, "0123456789", "def@456", new Address(), 60);
    Staff staff9 = new PartTimeStaff("Jayce", 25, "0123456789", "def@456", new Address(), 40);
    Staff staff10 = new PartTimeStaff("Darius", 25, "0123456789", "def@456", new Address(), 50);
    List<Staff> staffList = new ArrayList<>();
    private double totalSalary = 0;
    private double avgSalary;

    public void makeStaffList() {
        staffList.add(staff1);
        staffList.add(staff2);
        staffList.add(staff3);
        staffList.add(staff4);
        staffList.add(staff5);
        staffList.add(staff6);
        staffList.add(staff7);
        staffList.add(staff8);
        staffList.add(staff9);
        staffList.add(staff10);
    }

    public void showStaffList() {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i) instanceof FullTimeStaff fullTimeStaff) {
                System.out.println((i + 1) + ". " + fullTimeStaff);
            } else {
                PartTimeStaff partTimeStaff = (PartTimeStaff) staffList.get(i);
                System.out.println((i + 1) + ". " + partTimeStaff);
            }
        }
    }

    public void getAvgSalary() {
        for (Staff staff : staffList) {
            totalSalary += staff.allSalary();
        }
        avgSalary = totalSalary / staffList.size();
        System.out.println("The avg salary of company: " + avgSalary);
    }

    public void showFullTimeStaffHaveSalaryLowerAvg() {
        System.out.println("The full time staff have salary lower then avg salary: ");
        for (Staff staff : staffList) {
            if (staff instanceof FullTimeStaff fullTimeStaff) {
                if (fullTimeStaff.allSalary() < avgSalary) {
                    System.out.println(fullTimeStaff);
                }
            }
        }
    }

    public void showFullStaffByUpperSalary() {
        List<FullTimeStaff> fullTimeStaffList = new ArrayList<>();
        for (Staff staff : staffList) {
            if (staff instanceof FullTimeStaff fullTimeStaff) {
                fullTimeStaffList.add(fullTimeStaff);
            }
        }
        Collections.sort(fullTimeStaffList);
        System.out.println("Show full time staff by upper salary: ");
        for (FullTimeStaff fullTimeStaff : fullTimeStaffList) System.out.println(fullTimeStaff);
    }

    public void showAllMoneyPayForPartTimeStaff() {
        double money = 0;
        for (Staff staff : staffList) {
            if (staff instanceof PartTimeStaff partTimeStaff) {
                money += partTimeStaff.allSalary();
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        String moneyToString = decimalFormat.format(money);
        System.out.println("Money pay for part time staff: " + moneyToString);
    }

    public void showStaffByUpperAllSalary() {
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (int) Double.compare(o1.allSalary(), o2.allSalary());
            }
        });
        System.out.println("The list of staff by upper salary:");
        for (Staff staff : staffList) {
            System.out.println(staff + ". The salary of this staff: " + staff.allSalary());
        }
    }

}
