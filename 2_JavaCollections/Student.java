import java.util.Objects;

public class Student implements Comparable<Student> {
    String name;
    int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return rollNo == student.rollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rollNo);
    }

    @Override
    public int compareTo(Student that) {
        return Integer.compare(this.rollNo, that.rollNo);
        // return this.name.compareTo(that.name); // for string
    }

    // public static void main(String[] args) {
    // Student s1 = new Student("Alice", 1);
    // Student s2 = new Student("Bob", 2);

    // System.out.println(s1.equals(s2)); // false
    // System.out.println(s1.compareTo(s2)); // -1
    // }
}
