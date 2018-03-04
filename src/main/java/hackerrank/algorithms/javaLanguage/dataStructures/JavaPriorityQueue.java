package hackerrank.algorithms.javaLanguage.dataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaPriorityQueue {

    static class Priorities {
        public List<Student> getStudents(List<String> events) {
            events.stream()
                    .forEach(el -> {
                        if(el.substring(0, 5).equals("ENTER")) {
                            String[] splited = el.split("\\s+");
                            String name = splited[1];
                            double grade = Double.valueOf(splited[2]);
                            int id = Integer.valueOf(splited[3]);

                            System.out.println("ENTER " + name + " "+ grade + " " + id);
                        } else {
                            System.out.println("SERVED");
                        }
                    });
            return null;
        }
    }

    class Student {

        private int id;
        private String name;
        private double cgpa;

        public Student( int id, String name, double cgpa) {
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
    }

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
