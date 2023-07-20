import java.util.Comparator;

public class FullTimeStaff extends Staff implements Comparable<FullTimeStaff> {
    private double bonusMoney; // tiền thưởng
    private double fineMoney; // tiền phạt
    private double basicSalary; // lương cứng

    public FullTimeStaff(String name, int age, String phoneNumber, String email, Address address, double bonusMoney, double fineMoney, double basicSalary) {
        super(name, age, phoneNumber, email, address);
        this.bonusMoney = bonusMoney;
        this.fineMoney = fineMoney;
        this.basicSalary = basicSalary;
    }

    public double getBonusMoney() {
        return bonusMoney;
    }

    public double getFineMoney() {
        return fineMoney;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBonusMoney(double bonusMoney) {
        this.bonusMoney = bonusMoney;
    }

    public void setFineMoney(double fineMoney) {
        this.fineMoney = fineMoney;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public double allSalary() {
        return basicSalary + bonusMoney - fineMoney;
    }

    @Override
    public String toString() {
        return "Full time staff: " + super.toString() + ". Bonus money: " + bonusMoney + ", fine money: " + fineMoney + ", basic salary: " + basicSalary;
    }

    @Override
    public int compareTo(FullTimeStaff o) {
        return (int) this.allSalary() - (int) o.allSalary();
    }
}
