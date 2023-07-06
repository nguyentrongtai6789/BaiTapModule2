public class Student {
    private String name;
    private int age;
    private String className;

    public Student(String n, int ag, String cls) {
        name = n;
        age = ag;
        className = cls;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
