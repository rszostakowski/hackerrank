package hackerrank.algorithms.java_language.data_structures;

import java.util.*;

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<Student>();
        events.stream()
                .forEach(el -> {
                    if (el.substring(0, 5).equals("ENTER")) {
                        String[] splited = el.split("\\s+");
                        String name = splited[1];
                        double grade = Double.valueOf(splited[2]);
                        int id = Integer.valueOf(splited[3]);

                        Student student = new Student(id, name, grade);
                        priorityQueue.add(student);
                    } else {
                        priorityQueue.poll();
                    }
                });
        ArrayList<Student> students = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            students.add(priorityQueue.poll());
        }

        return students;
    }
}

class Student implements Comparable<Student> {
    private final Comparator<Student> STUDENT_COMPARATOR =
            Comparator.comparingDouble(Student::getCgpa).reversed()
                    .thenComparing(Student::getName)
                    .thenComparingInt(Student::getId);

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.name = name;
        this.id = id;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student o) {
        return STUDENT_COMPARATOR.compare(this, o);
    }
}


public class JavaPriorityQueue {


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
