import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    int id;
    String name;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getCGPA() {
        return cgpa;
    }

    public String toString() {
        return name + " " + cgpa;
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        Comparator<Student> comparator = Comparator.comparing(Student::getCGPA).reversed()
                .thenComparing(Student::getName).thenComparing(Student::getId);
        PriorityQueue<Student> queue = new PriorityQueue<Student>(comparator);
        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts.length > 1) {
                Student student = new Student(Integer.parseInt(parts[3]), parts[1], Double.parseDouble(parts[2]));
                queue.add(student);
            } else {
                queue.poll();
            }
        }
        List<Student> remained = new ArrayList<>();
        while (!queue.isEmpty()) {
            remained.add(queue.poll());
        }

        return remained;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}