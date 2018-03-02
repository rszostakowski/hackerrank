package hackerrank.algorithms.javaLanguage.dataStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {

    private static final Comparator<Student> STUDENT_COMPARATOR =
            Comparator.comparingDouble(Student::getCgpa).reversed()
                    .thenComparing(Student::getFname)
                    .thenComparingInt(Student::getId);
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student other) {
        return STUDENT_COMPARATOR.compare(this, other);
    }
}

public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student> studentList = new ArrayList<Student>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        studentList.stream()
                .sorted()
                .forEach(el -> System.out.println(el.getFname()));
    }
}
