import java.util.Stack;

public class LearnStack {
    public static void main(String[] args) {
        Stack<String> students = new Stack<>();
        students.push("Kiran");
        students.push("Archana");
        students.push("Delzina");
        System.out.println(students);
        System.out.println(students.peek());
        System.out.println(students);
        students.pop();
        System.out.println(students);

    }
}
