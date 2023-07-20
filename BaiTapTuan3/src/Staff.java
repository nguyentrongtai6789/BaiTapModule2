import java.util.ArrayList;
import java.util.List;

public class Staff {
    private static int id;
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private Address address;
    private static List<Integer> idList = new ArrayList<>();

    public Staff(String name, int age, String phoneNumber, String email, Address address) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        id++;
        idList.add(id);
    }

    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public static void setId(int id) {
        Staff.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static boolean checkId(int idNeedToCheck) {
        boolean check = false;
        for (int id : idList) {
            if (idNeedToCheck == id) {
                check = true;
                break;
            }
        }
        return check;
    }

    public double allSalary() {
        if (this instanceof FullTimeStaff) {
            FullTimeStaff fullTimeStaff = (FullTimeStaff) this;
            return fullTimeStaff.allSalary();
        } else {
            PartTimeStaff partTimeStaff = (PartTimeStaff) this;
            return partTimeStaff.allSalary();
        }
    }

    @Override
    public String toString() {
        return "Id: " + id + ", name: " + name + ", age: " + age + ", phone number: " + phoneNumber
                + ", email: " + email + ", address: " + address;
    }

}
