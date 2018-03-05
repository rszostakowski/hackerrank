package hackerrank.algorithms.javaLanguage.dataStructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class StudentSrt implements Comparable<StudentSrt> {

    private static final Comparator<StudentSrt> STUDENT_COMPARATOR =
            Comparator.comparingDouble(StudentSrt::getCgpa).reversed()
                    .thenComparing(StudentSrt::getFname)
                    .thenComparingInt(StudentSrt::getId);
    private int id;
    private String fname;
    private double cgpa;

    public StudentSrt(int id, String fname, double cgpa) {
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
    public int compareTo(StudentSrt other) {
        return STUDENT_COMPARATOR.compare(this, other);
    }
}

public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<StudentSrt> studentList = new ArrayList<StudentSrt>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            StudentSrt st = new StudentSrt(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }
        studentList.stream()
                .sorted()
                .forEach(el -> System.out.println(el.getFname()));
    }
}
