public class StaffMain {
    public static void main(String[] args) {
        StaffManage staffManage = new StaffManage();
        staffManage.makeStaffList();
        staffManage.showStaffList();
        staffManage.getAvgSalary();
        staffManage.showFullTimeStaffHaveSalaryLowerAvg();
        staffManage.showFullStaffByUpperSalary();
        staffManage.showAllMoneyPayForPartTimeStaff();
        staffManage.showStaffByUpperAllSalary();
    }
}
