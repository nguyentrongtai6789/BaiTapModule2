import java.sql.Time;

public class PartTimeStaff extends Staff {
    private double timeWork;

    public PartTimeStaff(String name, int age, String phoneNumber, String email, Address address, double timeWork) {
        super(name, age, phoneNumber, email, address);
        this.timeWork = timeWork;
    }

    public double getTimeWork() {
        return timeWork;
    }

    public void setTimeWork(double timeWork) {
        this.timeWork = timeWork;
    }

    @Override
    public double allSalary() {
        return this.timeWork*100_000;
    }
    @Override
    public String toString() {
        return "Part time staff. " + super.toString() + ". Time work: " + timeWork;
    }
}