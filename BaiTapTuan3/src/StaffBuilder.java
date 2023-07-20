public class StaffBuilder {
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private Address address;

    public StaffBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public StaffBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StaffBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public StaffBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StaffBuilder setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Staff createStaff() {
        return new Staff(name, age, phoneNumber, email, address);
    }
}